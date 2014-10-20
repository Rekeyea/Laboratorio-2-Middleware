package middleware.componentes;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.transform.dom.DOMSource;

import middleware.clases.datatypes.Transactions;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;

import javax.xml.transform.TransformerFactory;

import org.springframework.oxm.XmlMappingException;
import org.springframework.xml.transform.StringSource;

public class MarshallerWS implements Marshaller, Unmarshaller {
	
	
@SuppressWarnings("restriction")
public void marshal(Object obj, Result res) throws IOException,
		XmlMappingException {
	// TODO Auto-generated method stub
	//System.out.println("MARSHALLER");
		Transactions t = (Transactions)obj;
		@SuppressWarnings("restriction")
		JAXBContext context;
		StringWriter sw = new StringWriter();
		try {
			context = JAXBContext.newInstance(Transactions.class);
			javax.xml.bind.Marshaller mar= context.createMarshaller();
			
			//mar.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT,true);
			mar.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT, true);
			mar.marshal(t, sw);
			String body = sw.toString();
			//String xmlString = "<ns2:ReceiveTransactions xmlns:ns2=\"ACME\"> " + body + "</ns2:ReceiveTransactions>";
			//System.out.println(xmlString);
			Transformer transform = TransformerFactory.newInstance().newTransformer();
            transform.transform(new StringSource(body), res);
			
		} catch (JAXBException e) {
			throw new IOException("Error al parsear objeto a xml",e);
		} catch (TransformerException e) {
			throw new IOException("Error al parsear objeto a xml",e);
		}

		}

public boolean supports(Class<?> arg0) {
	// TODO Auto-generated method stub
	return false;
}

public Object unmarshal(Source src) throws IOException,
		XmlMappingException {
		boolean isOk = false;
		String mensaje = "";
		middleware.clases.datatypes.Result Res = new middleware.clases.datatypes.Result();
		final NodeList nodeList = ((DOMSource)src).getNode().getChildNodes();
		if(nodeList.getLength() > 1){
			for(int i=0; i<nodeList.getLength(); i++){
				Node iter = nodeList.item(i);
				if(iter.getLocalName().equals("isOk")){
					isOk = Boolean.valueOf(iter.getTextContent());
				}else if(iter.getLocalName().equals("message")){
					mensaje = iter.getTextContent();
				}
			}
		}
		Res.setMessage(mensaje);
		Res.setOk(isOk);
		return Res;

	}

}
