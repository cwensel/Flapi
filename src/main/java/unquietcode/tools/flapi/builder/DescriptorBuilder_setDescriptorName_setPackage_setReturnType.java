
package unquietcode.tools.flapi.builder;

import javax.annotation.Generated;
import unquietcode.tools.flapi.Descriptor;


/**
 * This class was generated using Flapi, the fluent API generator for Java.
 * Modifications to this file will be lost upon regeneration.
 * You have been warned!
 * 
 * Visit http://www.unquietcode.com/flapi for more information.
 * 
 * 
 * Generated on November 25, 2012 17:55:21 CST using version 0.3
 * 
 */
@Generated(value = "unquietcode.tools.flapi", date = "November 25, 2012 17:55:21 CST", comments = "generated using Flapi, the fluent API generator for Java")
public interface DescriptorBuilder_setDescriptorName_setPackage_setReturnType<_ReturnType >{


    DescriptorBuilder_setDescriptorName_setPackage<_ReturnType> setReturnType(Class returnType);

    MethodBuilder_addBlockChain<BlockBuilder<DescriptorBuilder_setDescriptorName_setPackage_setReturnType<_ReturnType>>> startBlock(String blockName, String methodSignature);

    Descriptor build();

    DescriptorBuilder_setDescriptorName_setReturnType<_ReturnType> setPackage(String packageName);

    MethodBuilder_addBlockChain<BlockBuilder<DescriptorBuilder_setDescriptorName_setPackage_setReturnType<_ReturnType>>> startBlock(String methodSignature);

    DescriptorBuilder_setPackage_setReturnType<_ReturnType> setDescriptorName(String descriptorName);

    MethodBuilder_addBlockChain<DescriptorBuilder_setDescriptorName_setPackage_setReturnType<_ReturnType>> addBlockReference(String blockName, String methodSignature);

    MethodBuilder_addBlockChain<DescriptorBuilder_setDescriptorName_setPackage_setReturnType<_ReturnType>> addMethod(String methodSignature);

}
