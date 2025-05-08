
package dev.rme.model.rpc;

import jakarta.annotation.Generated;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the dev.rme.model.rpc package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
@Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.2", date = "2025-05-08T20:13:25+02:00")
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: dev.rme.model.rpc
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Hrvatska }
     * 
     */
    public Hrvatska createHrvatska() {
        return new Hrvatska();
    }

    /**
     * Create an instance of {@link Hrvatska.Grad }
     * 
     */
    public Hrvatska.Grad createHrvatskaGrad() {
        return new Hrvatska.Grad();
    }

    /**
     * Create an instance of {@link Hrvatska.DatumTermin }
     * 
     */
    public Hrvatska.DatumTermin createHrvatskaDatumTermin() {
        return new Hrvatska.DatumTermin();
    }

    /**
     * Create an instance of {@link Hrvatska.Grad.Podatci }
     * 
     */
    public Hrvatska.Grad.Podatci createHrvatskaGradPodatci() {
        return new Hrvatska.Grad.Podatci();
    }

}
