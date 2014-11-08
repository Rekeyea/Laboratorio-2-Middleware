package org.midd.customtransformer;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

import java.security.MessageDigest;
import java.math.BigInteger;	

public class TransformXML implements Callable {

	public Object onCall(MuleEventContext context) throws Exception {
					
		
		Document document = (Document)context.getMessage().getPayload();
		String xmlData = document.asXML();
		
		//change namespace
		String pattern = "(xmlns:.*=)\"ACME\"";
		xmlData = xmlData.replaceAll(pattern,"$1\"ACMEv1\"");

		//get new document and change payload
		document = DocumentHelper.parseText(xmlData);		
		context.getMessage().setPayload(document);	
		
		//Ruta exacta para asegurarme que lo agrego en el lugar correcto.
		Node transNode = document.selectSingleNode( "/*[local-name()='Envelope']/*[local-name()='Body']/*[local-name()='Transactions']" );

		//Solo agrego el nodo si no existe.
		if(transNode.selectSingleNode("./*[local-name()='messageId']") == null){		
		
			//generate UUID -- Data
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(xmlData.getBytes());
			BigInteger number = new BigInteger(1, md.digest());
			String hash = number.toString(16);
			Element messageIdNode = ((Element)transNode).addElement("messageId");                     												
			messageIdNode.setText("legacy-" + hash);						
		}
		
		
		context.getSession().setProperty("isLegacy",  new Boolean(true));		
		
			  
		return context.getMessage().getPayload();
	}

}
