package webservices;

import java.util.Collections;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class WebServiceHandler implements SOAPHandler<SOAPMessageContext> {

	public boolean handleMessage(SOAPMessageContext context) {
		return true;
	}

	public boolean handleFault(SOAPMessageContext context) {
		try {
			final MessageFactory messageFactory = MessageFactory.newInstance();

			SOAPMessage m = messageFactory.createMessage();
			SOAPEnvelope env = m.getSOAPPart().getEnvelope();
			SOAPBody body = env.getBody();
			SOAPElement fResponse = body.addBodyElement(env.createName("sayHelloResponse","ns2", "http://webservices/"));
			SOAPElement result = fResponse.addChildElement(env.createName("return"));
			SOAPElement code = result.addChildElement(env.createName("code"));
			code.addTextNode("99");
			SOAPElement msg = result.addChildElement(env.createName("msg"));
			msg.addTextNode("Non pas titi !!!");
			((SOAPMessageContext) context).setMessage(m);
		} catch (SOAPException e) {

		}
		return true;
	}

	public void close(MessageContext context) {
		// TODO Auto-generated method stub

	}

	public Set<QName> getHeaders() {
		return Collections.emptySet();
	}

}
