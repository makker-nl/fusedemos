package nl.virtualsciences.fuse.soap.soaptosoap.aggregationstrategies;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nl.vs.xmlns.fuse.demo.xsd.animalorders.AnimalOrderResponseType;
import nl.vs.xmlns.fuse.demo.xsd.animalorders.OrderlineType;

public class AnimalOrderlineAggregationStrategy implements AggregationStrategy {
	private final Logger log = LoggerFactory.getLogger(AnimalOrderlineAggregationStrategy.class);
	public final static  String PROP_AO_RESP = "AnimalOrderResponse";
	public final static  String PROP_AOL_RESP = "AnimalOrderLineResponse";

	private AnimalOrderResponseType getAnimalOrderResponse(Exchange exchange) {
		return (AnimalOrderResponseType) exchange.getProperty(PROP_AO_RESP);
	}

	private OrderlineType getOrderline(Exchange exchange) {
		return (OrderlineType) exchange.getProperty(PROP_AOL_RESP);
	}
	
	private void addOrderLine(AnimalOrderResponseType animalOrderResponse, OrderlineType orderline) {
		List<OrderlineType> orderLines = animalOrderResponse.getAnimalOrder().getOrderlines().getOrderline();
		orderLines.add(orderline);
	}

	@Override
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		OrderlineType newOrderline = getOrderline(newExchange);
		if (oldExchange == null) {
			AnimalOrderResponseType newAnimalOrderResponse = getAnimalOrderResponse(newExchange);
			addOrderLine(newAnimalOrderResponse, newOrderline);
			return newExchange;
		} else {
			AnimalOrderResponseType oldAnimalOrderResponse = getAnimalOrderResponse(oldExchange);
			addOrderLine(oldAnimalOrderResponse, newOrderline);
			return oldExchange;
		}
	}
}
