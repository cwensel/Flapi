
package unquietcode.tools.flapi.examples.pizza.builder;

import unquietcode.tools.flapi.examples.pizza.DisappearingPizzaExample.SauceType;


/**
 * This class was generated using Flapi, the fluent API generator for Java.
 * Modifications to this file will be lost upon regeneration.
 * You have been warned!
 * 
 * Visit http://www.unquietcode.com/flapi for more information.
 * 
 * 
 * Generated on May 09, 2012 23:31:29 CDT using version 0.1
 * 
 */
public interface PizzaBuilder_addCheese_addSauce<_ReturnType >{


    _ReturnType bake();

    PizzaBuilder_addSauce<_ReturnType> addCheese();

    PizzaBuilder_addCheese<_ReturnType> addSauce(SauceType sauceType);

}
