package com.activemq.internal.errors;

import org.mule.runtime.extension.api.error.ErrorTypeDefinition;

public enum ActiveMQerrors implements ErrorTypeDefinition<ActiveMQerrors>{
	PUBLISHING,CONSUMING,EMPTYMESSAGE,NOMESSAGE

}
