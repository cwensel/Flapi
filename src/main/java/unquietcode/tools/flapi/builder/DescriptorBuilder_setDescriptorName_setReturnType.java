
package unquietcode.tools.flapi.builder;



/**
 * This class was generated using Flapi, the fluent API generator for Java.
 * Modifications to this file will be lost upon regeneration.
 * You have been warned!
 * 
 * Visit http://www.unquietcode.com/flapi for more information.
 * 
 * 
 * Generated on May 12, 2012 24:38:04 CDT using version 0.1
 * 
 */
public interface DescriptorBuilder_setDescriptorName_setReturnType<_ReturnType >{


    MethodBuilder_addBlockChain<DescriptorBuilder_setDescriptorName_setReturnType<_ReturnType>> addMethod(String methodSignature);

    _ReturnType build();

    MethodBuilder_addBlockChain<BlockBuilder<DescriptorBuilder_setDescriptorName_setReturnType<_ReturnType>>> startBlock(String blockName, String methodSignature);

    DescriptorBuilder_setReturnType<_ReturnType> setDescriptorName(String descriptorName);

    DescriptorBuilder_setDescriptorName<_ReturnType> setReturnType(Class returnType);

}