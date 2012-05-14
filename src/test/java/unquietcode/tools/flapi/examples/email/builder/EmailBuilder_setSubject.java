
package unquietcode.tools.flapi.examples.email.builder;

import java.io.File;


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
public interface EmailBuilder_setSubject<_ReturnType >{


    EmailBuilder_setSubject<_ReturnType> addAttachment(File file);

    EmailBuilder_setSubject<_ReturnType> addBCC(String emailAddress);

    EmailBuilder_setSubject<_ReturnType> addCC(String emailAddress);

    EmailBuilder_setSubject<_ReturnType> addRecipient(String emailAddress);

    _ReturnType send();

    EmailBuilder<_ReturnType> setSubject(String subject);

}