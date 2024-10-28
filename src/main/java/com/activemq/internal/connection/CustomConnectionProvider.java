package com.activemq.internal.connection;

import org.mule.runtime.api.connection.ConnectionException;
import org.mule.runtime.api.connection.ConnectionProvider;
import org.mule.runtime.api.connection.ConnectionValidationResult;
import org.mule.runtime.extension.api.annotation.param.ParameterGroup;

import com.activemq.internal.parameters.ConnectionParameters;

import jakarta.jms.JMSException;

public class CustomConnectionProvider implements ConnectionProvider<CustomConnection> {

	@ParameterGroup(name="ConnectionDetails",showInDsl = true)
	private ConnectionParameters connectionParameters;
	
	@Override
	public CustomConnection connect() throws ConnectionException {
		CustomConnection  con=null;
		try {
			  con=new CustomConnection(connectionParameters.getUserName(),connectionParameters.getPassword(), connectionParameters.getBrokerUrl());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			throw new ConnectionException("Error in connection", e);
		}
		return con;
	}

	@Override
	public void disconnect(CustomConnection customConnection) {
		try {
			customConnection.invalidateConnection();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ConnectionValidationResult validate(CustomConnection customConnection) {
		boolean isValid = customConnection.isValid();
	return	isValid?ConnectionValidationResult.success():ConnectionValidationResult.failure("Connection invalid",new RuntimeException("Invalid connection"));
	}

}
