// # Flapi
// ### _A fluent API generator for Java_

/**  
 * Flapi is a Java DSL for generating fluent API's built on method chaining.
 * Using the tool you can create your own DSL's in Java, supporting
 * practices like Language Oriented Programming and enabling higher-order
 * abstractions in your projects. And because they are type safe, any
 * reasonable code autocompleter should be able to provide you with instant
 * coding hints as you type. Method docs are also available, and most IDE's
 * can display these for you inline.
 * 
 *
 * ### At Build Time
 *
 * In general, the user must first define a `Descriptor` which details how
 * the API should operate. Once constructed, the descriptor is then used to
 * generate a set of Java source files. These files are comprised of a few
 * runtime classes and generated interfaces. The generated sources should
 * be included in your project, perhaps as a module dependency. (This project
 * also contains a maven plugin which allows you to regenerate your sources
 * on the fly. See more [here](https://github.com/UnquietCode/Flapi/wiki/Maven-Build-Plugin)).
 *
 *
 * ### At Run Time
 *
 * When a new instance of your builder is constructed, a single JDK dynamic
 * proxy object is configured. Starting with the top-level type, each method
 * in your fluent API is invoked by the user on this proxy, which in turn
 * calls the relevant methods in your API's runtime implementation. (more on
 * this later)
 */

EmailGenerator.compose(new EmailHelperImpl())
    .sender("HAL9000@gmail.com")
    .addRecipient("dave@unquietcode.com")
    .subject("Just what do you think you're doing, Dave?")
    .body("I know that you and Frank were planning to disconnect me, " +
          "and I'm afraid that's something I cannot allow to happen...")
.send();


/**
 * ## Descriptors
 *
 * The top level object in Flapi is the `Descriptor`. This contains all of the
 * information needed to generate the source code. You can start creating a
 * new Descriptor using `Flapi.builder()`...`.build()`, making sure to call
 * all of the required methods in between. After the call to build you will
 * have a descriptor which is ready to be generated.
 */

Descriptor builder = Flapi.builder()
	.setPackage("unquietcode.tools.flapi.examples.email.builder")
	.setStartingMethodName("compose")
	.setDescriptorName("Email")

	.addMethod("subject(String subject)").atMost(1)
	.addMethod("addRecipient(String emailAddress)").atLeast(1)
	.addMethod("sender(String emailAddress)").exactly(1)
	.addMethod("body(String text)").atMost(1)
	.addMethod("send()").last(EmailMessage.class)
.build();

builder.writeToStream(System.out);

/**
 * ### DescriptorBuilder Methods
 *
 * Of the methods which you can call while constructing a new
 * `Descriptor` object, some are required in order to have a valid
 * descriptor in the end. In general, Flapi will throw an exception if
 * it detects an inconsistency. Where possible, the API has been made
 * "self-driving" and intuitive via autocomplete and javadocs. 
 */

// Start building a new Descriptor. Zero or more `ExecutionListener`
// instances can be provided. (check out `MethodLogger`, which is
// quite helpful when debugging an error)
Descriptor descriptor = Flapi.builder(ExecutionListener...listeners)

// Set the package for all generated classes. (**required**)
    .setPackage(String package)

// Set the starting method name. (optional, default is `create()`)
    .setStartingMethodName(String name)

// Set the name of the descriptor. These will yield names like
// `ZapBuilder` and `ZapGenerator` in the generated classes. (**required**)
    .setDescriptorName(String descriptor)

// Set the return type for the entire descriptor. (optional,
// default is `void`)
    .setReturnType(Class class)

// As above, except the type can be specified without
// creating a compile-time dependency on the class.
    .setReturnType(String class)

// Generate class names which are condensed at the expense of
// being mangled and not as readable by a human. This is
// useful if you have a complicated descriptor which creates
// class names too long to be compiled.  (optional, disabled by default)
    .enableCondensedClassNames()

// Complete the finished descriptor, returning a new 
// `Descriptor` object. (**required**)
.build()


/**
 * ### Descriptor Methods
 *
 * After you finish creating a new `Descriptor`, there are a
 * few methods which can be called on it in order to
 * generate the source files and write them out.
 */

// Write the generated source code to a stream.
.writeToStream(OutputStream stream);

// Write the generated source code to a directory.
.writeToFolder(String folder);

// Write each individual file to a different stream.
// The iterator should provide a potentially unlimited
// number of streams for use.
.writeToStreams(Iterator<OutputStream> streams)

/**
 * ## Blocks
 * 
 * Blocks are the basic unit of state in Flapi, and correlate with the
 * interfaces generated for your API. As a user invokes methods on your
 * builder, they are transitioned from state to state by way of Java's
 * type system. 
 *
 * You can define blocks at the `Descriptor` level, or nested inside
 * each other. When using your builder at runtime you are moving in
 * to and out of blocks until you finally 'escape' thetop block or
 * return a value from the current block.
 *
 * A block is comprised of methods, and these roughly correspond
 * to the methods found in the generated interfaces. Methods will
 * be discussed in just a moment.
 */

.startBlock("SomeBlock", "beginSomething()").any()
    .addMethod("someMethod()").last()
    .addMethod("someOtherMethod(java.io.File file)").last()

    .startBlock("Nested", "nestedBlock()").last()
        .addMethod("anotherMethod(String string)").atMost(1)
        .addMethod("finish()").last()
    .endBlock()
.endBlock()


/**
 * ### BlockBuilder Methods
 *
 * A new block is started with `startBlock(...)` and must
 * end with a call to `endBlock()`. There should
 * be at least one method in every block which is marked as a
 * terminal method (via `last(...)`). There is one exception to
 * this rule, which is when all of your methods are disappearing
 * (via `atMost(...)`). In that case, a warning is printed and
 * the last method available in each state is marked as terminal.
 */

// Start a new block. This can be called either from the top level
// descriptor (which is actually just a special kind of block) or
// from within an existing block.
.startBlock(String blockName, String methodSignature)

// Start a new anonymous block. The names of these blocks will be
// generated, and so they cannot be referenced.
.startBlock(String methodSignature)

// End the current block. Returns a `MethodBuilder` to
// configure the invocation in the parent. (**required**)
.endBlock()

// Add a new method to the block. If no return type is provided
// then `void` is inferred.
.addMethod("someMethod()").any()
.addMethod("String someOtherMethod()").atLeast(1)

// Method parameters which are within the `java.lang` and `java.util` package are inferred.
// Other types must be fully qualified.
.addMethod("someMethod(String name)").any()
.addMethod("someOtherMethod(java.io.File file)").atMost(1)


/**
 * ### Enum Selectors
 *
 * Enum Selectors take an enum with a series of values and fans them
 * out into block with methods of the same name. This avoids importing
 * enums while still making use of them.  
 *
 * In the example, the method `test()` will be added to the current
 * block, the use of which looks like this:
 * ```java
 * .test().One()
 * .test().TWO()
 * .test().three()
 * ```
 */

public enum TestEnum {
    One, TWO, three
}
 
.addEnumSelector(TestEnum.class, "test()").any()


// Add a method which starts a new block whose methods are
// comprised of every enum in the provided enum class.
// Returns a `MethodBuilder` which can be used to configure
// the method's invocation in the parent block.
.addEnumSelector(Class enumClass, String methodSignature)


/**
 * ### Block References
 *
 * It is possible to make use of an already declared block by
 * using a 'block reference'. This allows you to add a method which
 * returns the block type without having to redefine it in your
 * descriptor. (This technique can also be used recursively to
 * return a new instance of the current block.)
 *
 * When a block is declared, a name can be provided which uniquely
 * identifies it within the scope of your descriptor. A block can
 * also be declared anonymously, in which case it cannot be
 * referenced.
 */

// Add a method which starts a new block, but by referencing it
// instead of defining it. Returns a `MethodBuilder` to
// configure the call.
.addBlockReference(String blockName, String methodSignature)


/**
 * ## Methods 
 * 
 * Methods in Flapi roughly correspond to the methods in your
 * generated interfaces. Methods have rules which define how many
 * times they can be called, when they become visible or invisible,
 * etc. In Flapi a method becomes _invisible_ when it has been
 * called the maximum number of times, or if another method
 * in the same group causes it to disappear. Similarly, trigger
 * methods allow a method to become _visible_ only after another 
 * method is called.
 *
 * 'visible' here means listed as a method in an interface which
 * the user of our descriptor will interact with. If a user
 * attempts to invoke a method which is invisible, the method will
 * not be a member of the  current class and a compile error
 * will occur! When using autocomplete it is very clear that the
 * method is no longer available to be called.
 */

.addMethod("unlimited()").any()

.addMethod("once()").atMost(1)

.addMethod("terminal()").last()

.addMethod("terminalWithValue()").last(Integer.class)


/**
 * ### MethodBuilder Methods
 * 
 * A descriptor method is defined with a preset number of times
 * which it can be, or should be, invoked. Setting the _quantifier_
 * for a method is one way to adjust its behavior. A method may
 * be marked `any()`, `atMost(...)`, `atLeast(...)`,
 * `between(...)`, `exactly(...)`, or `last(...)`. Each of these
 * are terminal methods in the `MethodBuilder` classes, making
 * them effectively required.
 * 
 * **Every block must have at least one terminal method**, and
 * this can be set via `last(...)`. This states that the
 * method should exit the current block, either by returning
 * a value (if a return type is provided on the method or
 * the block), returning the parent block, or returning
 * `void` if no return type is available.
 */


/**
 * ### Method Quantifiers
 */

// Specifies that the method can be called at most _x_ times.
// After that amount, the method will no longer be available
// to be called.
.atMost(int x)

// The method must be called at least _x_ times.
.atLeast(int x)

// The method must be called between _x_ and _y_ times.
.between(int x, int y)

// The method must be called exactly _x_ times.
.exactly(int x)

// The method can be called any number of times.
.any()

// The method can be called once, and will return
// the block's return type after being called. Every
// block should have a last method so that there is
// a way to exit it (think of a state machine stuck
// in an infinite loop).
.last()

// The method, in addition to being last, will also
// return the specified type. This overrides any
// return type set for the block.
.last(Class class)

// As above, except the type can be specified without
// creating a compile-time dependency on the class.
.last(String class)


/**
 * ### Method Groups
 *
 * Methods can be grouped together, and this causes
 * them to influence each others' behaviors. Using
 * groups allows for complicated "A xor B" types of
 * workflows.
 */

// Members of the same group will become invisible
// as soon as this method does so.
.atMost(int x, int group)

// The method will only become visible after at
// least one member of the group has been called.
.after(int group)

// Members of the same group will become invisible
// after this method is called for the first time.
.any(int group)


/**
 * ### Block Chains
 * 
 * Sometimes you want a method to pass through a series
 * of blocks before returning. This can be accomplished
 * by adding a Block Chain to any method. The chain may
 * contain any number of block references, named blocks,
 * and anonymous blocks.
 *
 * Before the target of any method is reached (be it the current
 * block, a new block, the parent block, or a terminal value),
 * it first passes through its block chain, which is empty by
 * default. The order in which the chain is defined in the
 * builder is the same as what the user will experience later
 * when interacting with your API.
 *
 * ```
 * Block chains are NOT preserved when you reference an
 * existing block. That is, the block chain is part of
 * the method invocation which returns the block, not
 * the block itself.
 * ```
 */

.addMethod("method()")
    .addBlockChain()
        .addBlockReference("SomeBlock")
    .end()
.any()

.startBlock("block()")
    .addBlockChain()
        .addBlockReference("SomeBlock")
    .end()
.any()
    .addMethod("done()").last()
.endBlock()


// Add a block chain to the method. Returns a `BlockChainBuilder`
// which can be used to define the sequence.
.addBlockChain()

// reference an existing block
    .addBlockReference(String blockName)
    
// new named block
    .startBlock(String blockName)
        ...
    .endBlock()

// new anonymous block
    .startBlock()
        ...
    .endBlock()

// finish defining the block chain
.end()


/**
 * ### Method Documentation
 * 
 * When declaring a method, it is possible to specify a
 * documentation string to include on the method in the
 * generated interfaces. Users will be able to look up
 * the documentation in their IDE for these methods. As
 * well, it is possible to run the generated source 
 * through the javadocs tool to generate API docs.
 *
 * The documentation methods are available on the
 * `MethodBuilder` class, and allow for either a single
 * line or a multi-line declaration. It is also possible
 * to mark a method with the `@Deprecated` annotation.
 */

.addMethod("someMethod()")
    .withDocumentation("Single line of documentation.")
.last()

.addMethod("someOtherMethod()")
    .withDocumentation()
        .addContent("First line.")
        .addContent("Second line.")
    .finish()
.last()


// Add a single line of documentation to the method.
.withDocumentation(String text)


// Add multiple lines of documentation to the method.
.withDocumentation()

// Add another line of content.
    .addContent(String text)

// Finish defining the documentation.
.finish()

// Marks the method as `@Deprecated`. Also adds
// a `@deprecated` tag to the javadocs.
.markAsDeprecated(String reason)


/**
 * ## Thanks!
 * Visit the project [on GitHub](https://github.com/UnquietCode/Flapi)
 * for more information.
 */