
package unquietcode.tools.flapi.examples.xhtml.builder.Element;

import unquietcode.tools.flapi.runtime.MethodInfo;
import unquietcode.tools.flapi.runtime.TransitionType;

import javax.annotation.Generated;


/**
 * This class was generated using Flapi, the fluent API generator for Java.
 * Modifications to this file will be lost upon regeneration.
 * You have been warned!
 * 
 * Visit https://github.com/UnquietCode/Flapi for more information.
 * 
 * 
 * Generated on July 02, 2013 0:08:51 PDT using version 0.4
 */
@Generated(value = "unquietcode.tools.flapi", date = "July 02, 2013 0:08:51 PDT", comments = "generated using Flapi, the fluent API generator for Java")
public interface ElementBuilder_endElement_setValue<_ReturnType> {
    @MethodInfo(type = TransitionType.Recursive, chain = {

    })
    ElementBuilder_endElement_setValue<_ReturnType> addAttribute(String key, String value);

    @MethodInfo(type = TransitionType.Recursive, chain = {

    })
    ElementBuilder_endElement_setValue<_ReturnType> addComment(String comment);

    @MethodInfo(type = TransitionType.Ascending, chain = {

    })
    _ReturnType endElement();

    @MethodInfo(type = TransitionType.Lateral, chain = {

    })
    ElementBuilder_endElement<_ReturnType> setValue(String value);

    @MethodInfo(type = TransitionType.Recursive, chain = {
        ElementBuilder_endElement_setValue.class
    })
    ElementBuilder_endElement_setValue<ElementBuilder_endElement_setValue<_ReturnType>> startElement(String tagName);
}
