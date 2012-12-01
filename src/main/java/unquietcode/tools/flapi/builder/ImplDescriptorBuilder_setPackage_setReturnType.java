
package unquietcode.tools.flapi.builder;

import java.lang.reflect.Field;
import javax.annotation.Generated;
import unquietcode.tools.flapi.Descriptor;
import unquietcode.tools.flapi.support.BuilderImplementation;
import unquietcode.tools.flapi.support.v0_2.ExpectedInvocationsException;
import unquietcode.tools.flapi.support.v0_2.ObjectWrapper;


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
public class ImplDescriptorBuilder_setPackage_setReturnType
    implements DescriptorBuilder_setPackage_setReturnType, BuilderImplementation
{

    private final DescriptorHelper _helper;
    private final Object _returnValue;
    int ic_Descriptor_setPackage$String_packageName = 1;

    ImplDescriptorBuilder_setPackage_setReturnType(DescriptorHelper helper, Object returnValue) {
        _helper = helper;
        _returnValue = returnValue;
    }

    public BuilderImplementation _getParent() {
        if (_returnValue instanceof BuilderImplementation) {
            return ((BuilderImplementation) _returnValue);
        } else {
            return null;
        }
    }

    private void _transferInvocations(Object next) {
        Class clazz = next.getClass();
         
        try {
            Field field = clazz.getDeclaredField("ic_Descriptor_setPackage$String_packageName");
            field.setInt(next, ic_Descriptor_setPackage$String_packageName);
        } catch (Exception _x) {
            // nothing
        }
    }

    public void _checkInvocations() {
        if (ic_Descriptor_setPackage$String_packageName > 0) {
            throw new ExpectedInvocationsException("Expected at least 1 invocations of method 'setPackage(String packageName)'.");
        }
    }

    public Descriptor build() {
        BuilderImplementation cur = this;
        while (cur!= null) {
            cur._checkInvocations();
            cur = cur._getParent();
        }
         
        Descriptor intermediateResult = _helper.build();
         
        return intermediateResult;
    }

    public DescriptorBuilder_setPackage setReturnType(Class returnType) {
        _helper.setReturnType(returnType);
        ImplDescriptorBuilder_setPackage step1 = new ImplDescriptorBuilder_setPackage(_helper, _returnValue);
         
        _transferInvocations(step1);
        return step1;
    }

    public DescriptorBuilder_setReturnType setPackage(String packageName) {
        --ic_Descriptor_setPackage$String_packageName;
        _helper.setPackage(packageName);
        ImplDescriptorBuilder_setReturnType step1 = new ImplDescriptorBuilder_setReturnType(_helper, _returnValue);
         
        _transferInvocations(step1);
        return step1;
    }

    public MethodBuilder_addBlockChain addBlockReference(String blockName, String methodSignature) {
        ObjectWrapper<MethodHelper> helper1 = new ObjectWrapper<MethodHelper>();
        _helper.addBlockReference(blockName, methodSignature, helper1);
        ImplMethodBuilder_addBlockChain step1 = new ImplMethodBuilder_addBlockChain(helper1 .get(), this);
         
        return step1;
    }

    public MethodBuilder_addBlockChain startBlock(String methodSignature) {
        ObjectWrapper<MethodHelper> helper1 = new ObjectWrapper<MethodHelper>();
        ObjectWrapper<BlockHelper> helper2 = new ObjectWrapper<BlockHelper>();
        _helper.startBlock(methodSignature, helper1, helper2);
        ImplBlockBuilder step1 = new ImplBlockBuilder(helper2 .get(), this);
        ImplMethodBuilder_addBlockChain step2 = new ImplMethodBuilder_addBlockChain(helper1 .get(), step1);
         
        return step2;
    }

    public MethodBuilder_addBlockChain addMethod(String methodSignature) {
        ObjectWrapper<MethodHelper> helper1 = new ObjectWrapper<MethodHelper>();
        _helper.addMethod(methodSignature, helper1);
        ImplMethodBuilder_addBlockChain step1 = new ImplMethodBuilder_addBlockChain(helper1 .get(), this);
         
        return step1;
    }

    public MethodBuilder_addBlockChain startBlock(String blockName, String methodSignature) {
        ObjectWrapper<MethodHelper> helper1 = new ObjectWrapper<MethodHelper>();
        ObjectWrapper<BlockHelper> helper2 = new ObjectWrapper<BlockHelper>();
        _helper.startBlock(blockName, methodSignature, helper1, helper2);
        ImplBlockBuilder step1 = new ImplBlockBuilder(helper2 .get(), this);
        ImplMethodBuilder_addBlockChain step2 = new ImplMethodBuilder_addBlockChain(helper1 .get(), step1);
         
        return step2;
    }

}
