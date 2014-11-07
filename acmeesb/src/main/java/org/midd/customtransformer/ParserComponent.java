package org.midd.customtransformer;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.mule.api.transport.PropertyScope;

public class ParserComponent implements Callable{

	public Object onCall(MuleEventContext context) throws Exception {
		
		
		Boolean isLegacy = context.getSession().getProperty("isLegacy");
		
		boolean ok = isLegacy != null && isLegacy ;

		if(ok){
			Document doc = context.getMessage().getPayload(org.dom4j.Document.class);
			String toParse = doc.asXML();
			toParse = toParse.replaceAll("\"ACMEv1\"","\"ACME\"");
			
			try {
				Document parseText = DocumentHelper.parseText(toParse);
				context.getMessage().setPayload(parseText);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return context.getMessage().getPayload();
	}

}

