package com.activemq.internal;

import org.mule.runtime.api.meta.ExternalLibraryType;
import org.mule.runtime.extension.api.annotation.Expression;
import org.mule.runtime.extension.api.annotation.ExternalLib;
import org.mule.runtime.extension.api.annotation.Operations;
import org.mule.runtime.extension.api.annotation.Sources;
import org.mule.runtime.extension.api.annotation.connectivity.ConnectionProviders;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.ParameterGroup;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Example;
import org.mule.runtime.extension.api.annotation.param.display.Password;
import org.mule.runtime.extension.api.annotation.param.display.Placement;
import org.mule.runtime.extension.api.annotation.param.display.Summary;
import org.mule.runtime.extension.api.annotation.param.display.Text;

import com.activemq.internal.operations.ActiveMqOperations;
import com.activemq.internal.parameters.ConnectionParameters;
import com.activemq.internal.parameters.ConsumerConfigParameters;
import com.activemq.internal.parameters.ProducerConfigParameters;

/**
 * This class represents an extension configuration, values set in this class
 * are commonly used across multiple operations since they represent something
 * core from the extension.
 */
@Operations(ActiveMqOperations.class)
@ConnectionProviders(ActiveMqConnectionProvider.class)
@Sources(ActiveMQSource.class)
@ExternalLib(name="ActiveMQ",description = "Description",type = ExternalLibraryType.DEPENDENCY,
requiredClassName = "org.apache.activemq.ActiveMQConnectionFactory",coordinates = "org.apache.activemq:activemq-client:5.15.3")
public class ActiveMqConfiguration {
	@ParameterGroup(name = "connection",showInDsl = true)
	private ConnectionParameters connectionParameters;
	@ParameterGroup(name = "producerConfig",showInDsl = true)
	@Placement(tab = "producer")
	private ProducerConfigParameters producerConfigParameters;
	@ParameterGroup(name = "consumerConfig",showInDsl = true)
	@Placement(tab = "consumer")
	private ConsumerConfigParameters consumerConfigParameters;

	public ConnectionParameters getConnectionParameters() {
		return connectionParameters;
	}

	public void setConnectionParameters(ConnectionParameters connectionParameters) {
		this.connectionParameters = connectionParameters;
	}

	public ProducerConfigParameters getProducerConfigParameters() {
		return producerConfigParameters;
	}

	public void setProducerConfigParameters(ProducerConfigParameters producerConfigParameters) {
		this.producerConfigParameters = producerConfigParameters;
	}

	public ConsumerConfigParameters getConsumerConfigParameters() {
		return consumerConfigParameters;
	}

	public void setConsumerConfigParameters(ConsumerConfigParameters consumerConfigParameters) {
		this.consumerConfigParameters = consumerConfigParameters;
	}

}
