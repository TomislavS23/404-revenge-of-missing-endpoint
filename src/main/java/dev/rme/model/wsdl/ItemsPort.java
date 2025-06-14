
package dev.rme.model.wsdl;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ItemsPort", targetNamespace = "http://example.com/soap/model")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ItemsPort {


    /**
     * 
     * @param searchByPriceRequest
     * @return
     *     returns dev.rme.model.wsdl.SearchResponse
     */
    @WebMethod
    @WebResult(name = "searchResponse", targetNamespace = "http://example.com/soap/model", partName = "searchResponse")
    public SearchResponse searchByPrice(
        @WebParam(name = "searchByPriceRequest", targetNamespace = "http://example.com/soap/model", partName = "searchByPriceRequest")
        SearchByPriceRequest searchByPriceRequest);

}
