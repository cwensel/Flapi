
package unquietcode.tools.flapi.examples.email.builder;

import java.io.File;
import java.lang.reflect.Field;
import unquietcode.tools.flapi.MinimumInvocationsException;


/**
 * This class was generated using Flapi, the fluent API generator for Java.
 * Modifications to this file will be lost upon regeneration.
 * You have been warned!
 * 
 * Visit http://www.unquietcode.com/flapi for more information.
 * 
 * 
 * Generated on May 13, 2012 24:29:29 CDT using version 0.2
 * 
 */
public class ImplEmailBuilder_setBody_setSender_setSubject
    implements EmailBuilder_setBody_setSender_setSubject
{

    private final EmailHelper _helper;
    private final Object _returnValue;
    int ic_Email_addRecipient$String_emailAddress = 1;
    int ic_Email_setSender$String_emailAddress = 1;

    ImplEmailBuilder_setBody_setSender_setSubject(EmailHelper helper, Object returnValue) {
        _helper = helper;
        _returnValue = returnValue;
    }

    private void _transferInvocations(Object next) {
        Class clazz = next.getClass();
         
        try {
            Field field = clazz.getDeclaredField("ic_Email_addRecipient$String_emailAddress");
            field.setInt(next, ic_Email_addRecipient$String_emailAddress);
        } catch (Exception _x) {
            // nothing
        }
         
        try {
            Field field = clazz.getDeclaredField("ic_Email_setSender$String_emailAddress");
            field.setInt(next, ic_Email_setSender$String_emailAddress);
        } catch (Exception _x) {
            // nothing
        }
    }

    private void _checkInvocations() {
        if (ic_Email_addRecipient$String_emailAddress > 0) {
            throw new MinimumInvocationsException("Expected at least 1 invocations of method 'addRecipient(String emailAddress)'.");
        }
        if (ic_Email_setSender$String_emailAddress > 0) {
            throw new MinimumInvocationsException("Expected at least 1 invocations of method 'setSender(String emailAddress)'.");
        }
    }

    public EmailBuilder_setBody_setSender_setSubject addAttachment(File file) {
        _helper.addAttachment(file);
         
        EmailBuilder_setBody_setSender_setSubject retval = this;
        return retval;
    }

    public EmailBuilder_setBody_setSender_setSubject addBCC(String emailAddress) {
        _helper.addBCC(emailAddress);
         
        EmailBuilder_setBody_setSender_setSubject retval = this;
        return retval;
    }

    public EmailBuilder_setBody_setSender_setSubject addCC(String emailAddress) {
        _helper.addCC(emailAddress);
         
        EmailBuilder_setBody_setSender_setSubject retval = this;
        return retval;
    }

    public EmailBuilder_setBody_setSender_setSubject addRecipient(String emailAddress) {
        _helper.addRecipient(emailAddress);
         
        EmailBuilder_setBody_setSender_setSubject retval = this;
        --ic_Email_addRecipient$String_emailAddress;
        return retval;
    }

    public Object send() {
        _checkInvocations();
        _helper.send();
         
        Object retval = _returnValue;
        return retval;
    }

    public EmailBuilder_setSender_setSubject setBody(String text) {
        _helper.setBody(text);
         
        EmailBuilder_setSender_setSubject retval = new ImplEmailBuilder_setSender_setSubject(_helper, _returnValue);
        _transferInvocations(retval);
        return retval;
    }

    public EmailBuilder_setBody_setSubject setSender(String emailAddress) {
        _helper.setSender(emailAddress);
         
        EmailBuilder_setBody_setSubject retval = new ImplEmailBuilder_setBody_setSubject(_helper, _returnValue);
        --ic_Email_setSender$String_emailAddress;
        _transferInvocations(retval);
        return retval;
    }

    public EmailBuilder_setBody_setSender setSubject(String subject) {
        _helper.setSubject(subject);
         
        EmailBuilder_setBody_setSender retval = new ImplEmailBuilder_setBody_setSender(_helper, _returnValue);
        _transferInvocations(retval);
        return retval;
    }

}
