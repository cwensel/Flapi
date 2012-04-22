package unquietcode.tools.flapi.builder;

/**
 * @author Ben Fagin
 * @version 03-04-2012
 */
public interface DescriptorBuilder_showLog<_ReturnType> {
	_ReturnType build();
	MethodBuilder<DescriptorBuilder_showLog<_ReturnType>> addMethod(String methodSignature);
	MethodBuilder<BlockBuilder_addBlockChain<DescriptorBuilder_showLog<_ReturnType>>> startBlock(String blockName, String methodSignature);

	DescriptorBuilder<_ReturnType> showLog(boolean showLog);
}