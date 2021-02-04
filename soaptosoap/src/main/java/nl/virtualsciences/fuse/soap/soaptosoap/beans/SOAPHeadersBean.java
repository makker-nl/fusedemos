package nl.virtualsciences.fuse.soap.soaptosoap.beans;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;

import org.apache.camel.Message;
import org.apache.camel.util.CastUtils;
import org.apache.cxf.binding.soap.SoapHeader;
import org.apache.cxf.headers.Header;
import org.apache.cxf.headers.Header.Direction;
import org.apache.cxf.jaxb.JAXBDataBinding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nl.virtualsciences.fuse.soap.soaptosoap.processors.LogHeadersProcessor;
import nl.vs.xmlns.fuse.demo.xsd.animalquotes.SessionHeaderType;

public class SOAPHeadersBean {
	private final Logger log = LoggerFactory.getLogger(SOAPHeadersBean.class);
	public final String ANIMALQUOTE_TNS = "http://xmlns.vs.nl/fuse/demo/soap/animalquotes/sessionHeader";
	public final String SESSION_SOAPHDR = "SessionHeader";
	public final String SESSIONID_MSGHDR = "animalQuoteSessionId";

	public void initHeaders(Message in) throws Exception {
		final String methodName="initHeaders";
		log.debug(methodName+": Start");
		log.debug(methodName+": Init header "+Header.HEADER_LIST);
		in.setHeader(Header.HEADER_LIST, new ArrayList<SoapHeader>());
		log.debug(methodName+": End");
	}

	public void addSoapHeader(Message in, String targetNameSpace, Object soapHeaderContent) throws Exception {
		final String methodName="setSoapHeader";
		log.debug(methodName+": Start");
		if (in.getHeader(Header.HEADER_LIST) == null) {
			initHeaders(in);
		}
		log.debug(methodName+": Get camel header "+Header.HEADER_LIST);
		List<SoapHeader> soapHeaders = CastUtils.cast((List<?>) in.getHeader(Header.HEADER_LIST));
		try {
			log.debug(methodName+": Create a soap header");
			SoapHeader soapHeader = new SoapHeader(new QName(targetNameSpace, SESSION_SOAPHDR), soapHeaderContent,
					new JAXBDataBinding(soapHeaderContent.getClass()));
			soapHeader.setDirection(Direction.DIRECTION_OUT);
			soapHeader.setMustUnderstand(true);
			soapHeaders.add(soapHeader);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		log.debug(methodName+": End");
	}

	public void setAnimalQuoteSessionId(Message in) throws Exception {
		final String methodName="setAnimalQuoteSessionId";
		log.debug(methodName+": Start");
		initHeaders(in);
		SessionHeaderType sessionHeader = new SessionHeaderType();
		String sforceSessionId = (String) in.getHeader(SESSIONID_MSGHDR);
		sessionHeader.setSessionId(sforceSessionId);
		addSoapHeader(in, ANIMALQUOTE_TNS, sessionHeader);
		log.debug(methodName+": End");
	}

}
