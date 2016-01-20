package webservices;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import dto.Message;

@WebService
@SOAPBinding(style = Style.RPC)
@HandlerChain(file="/handler-chains.xml")
public class HelloService {

	@WebMethod
	public Message sayHello(@WebParam(name="name") String name){
		if("titi".equals(name)){
			throw new RuntimeException("Non pas titi");
		}
		return new Message(0, "Hello "+ name);
	}
	
}
