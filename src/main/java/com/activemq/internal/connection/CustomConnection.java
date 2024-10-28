package com.activemq.internal.connection;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.jms.Connection;
import jakarta.jms.JMSException;
import jakarta.jms.Session;
import jakarta.jms.TextMessage;

public class CustomConnection {

	private static Logger logger = LoggerFactory.getLogger(CustomConnection.class);
	private Connection connection;

	CustomConnection(String username, String password, String brokerUrl) throws JMSException {
		ActiveMQConnectionFactory amf = new ActiveMQConnectionFactory(username, password, brokerUrl);
		this.connection = amf.createConnection();
		this.connection.start();

	}
	
	public void invalidateConnection() throws JMSException{
		if(connection!=null)
			connection.close();
	}
	
	
	public boolean isValid() {
		boolean isValid=true;
	
		try {
			Session session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
			TextMessage t = session.createTextMessage("Hello test");
			
			
		}catch(JMSException jme)
		{isValid=false;
			
		}
		return isValid;
}
}
