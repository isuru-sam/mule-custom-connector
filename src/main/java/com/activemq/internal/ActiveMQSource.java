package com.activemq.internal;

import org.mule.runtime.api.connection.ConnectionProvider;
import org.mule.runtime.api.exception.MuleException;
import org.mule.runtime.extension.api.annotation.Alias;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.ConfigOverride;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.ParameterGroup;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.runtime.operation.Result;
import org.mule.runtime.extension.api.runtime.source.Source;
import org.mule.runtime.extension.api.runtime.source.SourceCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.activemq.internal.connection.CustomConnection;
import com.activemq.internal.operations.ActiveMqOperations;
import com.activemq.internal.parameters.DestinationParameters;

@Alias("listener")
@DisplayName("onNewMessage")
@MediaType(value = MediaType.ANY,strict = false)
public class ActiveMQSource extends Source<String,Void>{
	public static Logger logger = LoggerFactory.getLogger(ActiveMQSource.class);
	@Connection
	private ConnectionProvider<CustomConnection> connectionProvider;
	private CustomConnection customConnection;
	@ParameterGroup(name="Destination",showInDsl = true)
    private DestinationParameters destinationParameters;
	@Parameter
	@Optional
	@ConfigOverride
private String selector;
	@Config
	private ActiveMqConfiguration  config;
	
	
	@Override
	public void onStart(SourceCallback<String, Void> sourceCallback) throws MuleException {
		customConnection = connectionProvider.connect();
		// TODO Auto-generated method stub
		Result.Builder<String, Void> resultBuilder=Result.builder();
		Result<String,Void> result = resultBuilder.output("Hello").build();
		sourceCallback.handle(result);
	}

	@Override
	public void onStop() {
		// TODO Auto-generated metho
		if(customConnection!=null) {
			connectionProvider.disconnect(customConnection);
		}
	}

}
