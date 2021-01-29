package nl.virtualsciences.fuse.soap.soaptosoap.webservices;

import javax.xml.soap.SOAPMessage;
import javax.xml.ws.Provider;

import org.springframework.stereotype.Component;

@Component
public class AnimalQuoteServiceProvider implements Provider<SOAPMessage> {

	@Override
	public SOAPMessage invoke(SOAPMessage soapMessage) {
		return null;
	}

	public SOAPMessage quote(SOAPMessage soapMessage) {
		return null;
	}

}
