
package unquietcode.tools.flapi.builder;

import javax.annotation.Generated;
import unquietcode.tools.flapi.support.ObjectWrapper;


/**
 * This class was generated using Flapi, the fluent API generator for Java.
 * Modifications to this file will be lost upon regeneration.
 * You have been warned!
 * 
 * Visit http://www.unquietcode.com/flapi for more information.
 * 
 * 
 * Generated on December 01, 2012 13:14:02 CST using version 0.3
 * 
 */
@Generated(value = "unquietcode.tools.flapi", date = "December 01, 2012 13:14:02 CST", comments = "generated using Flapi, the fluent API generator for Java")
public interface MethodHelper {


    void exactly(int num);

    void between(int atLeast, int atMost);

    void any();

    void last(Class returnType);

    void addBlockChain(ObjectWrapper<BlockChainHelper> _helper1);

    void last();

    void atMost(int num);

    void atLeast(int num);

}
