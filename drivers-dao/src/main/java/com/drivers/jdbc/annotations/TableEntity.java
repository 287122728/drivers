package com.drivers.jdbc.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Specifies the primary table for the annotated entity.
 * <p> If no <code>Table</code> annotation is specified for an entity
 * class, the default values apply.
 * <p/>
 * <pre>
 *    Example:
 *
 *    &#064;Table( "CUST" )
 *    public class Customer { ... }
 * </pre>
 *
 * @since Java Persistence 1.0
 */
@Target(TYPE)
@Retention(RUNTIME)
public @interface TableEntity {

    /**
     * The name of the table.
     * <p> Defaults to the entity name.
     */
    String value() default "";


}
