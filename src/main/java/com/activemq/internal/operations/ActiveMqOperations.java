package com.activemq.internal.operations;

import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;

import org.mule.runtime.extension.api.annotation.Alias;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.ParameterGroup;
import org.mule.runtime.extension.api.runtime.parameter.CorrelationInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.activemq.internal.ActiveMqConfiguration;
import com.activemq.internal.ActiveMqConnection;
import com.activemq.internal.connection.CustomConnection;
import com.activemq.internal.parameters.ConsumeParameters;
import com.activemq.internal.parameters.DestinationParameters;
import com.activemq.internal.parameters.PublishParameters;
import com.activemq.internal.parameters.TestParameters;

import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Connection;

/**
 * This class is a container for operations, every public method in this class
 * will be taken as an extension operation.
 */
public class ActiveMqOperations {
	public static Logger logger = LoggerFactory.getLogger(ActiveMqOperations.class);

	@Alias("Publish")
	public void produceOperation(@ParameterGroup(name="Consumer") PublishParameters publishParameters, @Config ActiveMqConfiguration config,@Connection CustomConnection con ) {
logger.info("Publish to q");
logger.info("Broker url"+config.getConnectionParameters().getBrokerUrl());
	}

	@Alias("Consume")
	@MediaType(value = MediaType.ANY)
	public String consumeOperation(@ParameterGroup(name="Destination",showInDsl = true)
	DestinationParameters destinationParameters,@ParameterGroup(name="Consumer",showInDsl = true) 
	ConsumeParameters consumeParameters, @Config ActiveMqConfiguration config,CorrelationInfo correlationInfo,@Connection CustomConnection con ) {
		return "";
	}
	
	
	@Alias("Test")
	public void testOperation(@ParameterGroup(name="Test") TestParameters testParameters) {
		
	}
	
}
