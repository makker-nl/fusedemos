package nl.virtualsciences.fuse.soap.soaptosoap.processors;

import java.io.IOException;
import java.util.List;

import javax.xml.soap.SOAPException;
import javax.xml.transform.Source;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.cxf.CxfPayload;
import org.apache.cxf.binding.soap.SoapHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnimalQuoteResponseProcessor implements Processor {
	private static final Logger log = LoggerFactory.getLogger(AnimalQuoteResponseProcessor.class);
	public static final String SOAP_PROTOCOL = javax.xml.soap.SOAPConstants.SOAP_1_1_PROTOCOL;

	private static void debug(String methodName, String text) {
		log.info("AnimalQuoteResponseProcessor." + methodName + ": " + text);
	}

	@Override
	public void process(Exchange exchange) throws SOAPException, IOException {
		final String methodName = "process";
		debug(methodName, "start");

		Object[] args = exchange.getIn().getBody(Object[].class);
		debug(methodName, "Number of args: " + args.length);
		Object bodyObject = args[0];
		log.info("CanonicalClassName of Body: " + bodyObject.getClass().getCanonicalName());
		
		//String xmlDocument = exchange.getIn().getBody(String.class);
		//log.info("String representation of Body: " + xmlDocument);
		
		//AnimalQuoteResponseType aqr = (AnimalQuoteResponseType) exchange.getIn().getBody(Object[].class)[0];
		//AnimalQuoteType aq = aqr.getAnimalQuote();
		//AnimalType an = aq.getAnimal();
		//String animalId = an.getId();
		
		//log.info("Received quote for animalId: " + animalId);
		
		debug(methodName, "end");
	}

}