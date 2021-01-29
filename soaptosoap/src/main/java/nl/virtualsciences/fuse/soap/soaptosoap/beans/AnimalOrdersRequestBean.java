package nl.virtualsciences.fuse.soap.soaptosoap.beans;

import java.util.List;

import nl.vs.xmlns.fuse.demo.xsd.animalorders.AnimalOrderRequestType;
import nl.vs.xmlns.fuse.demo.xsd.animalorders.OrderlineType;

public class AnimalOrdersRequestBean {
    /**
     * Split the AnimalOrderRequest into a list of OrderLines
     *
     * @param AnimalOrderRequestType the AnimalOrderRequest
     * @return the OrderLines
     */
    public List<OrderlineType> splitOrderlines(AnimalOrderRequestType animalOrderRequest) {
        // this is a very simple logic, but your use cases
        // may very well require more complex logic
        return animalOrderRequest.getAnimalOrder().getOrderlines().getOrderline();
    }
}
