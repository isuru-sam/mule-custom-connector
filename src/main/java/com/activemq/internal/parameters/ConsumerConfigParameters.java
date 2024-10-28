package com.activemq.internal.parameters;

import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.Parameter;

public class ConsumerConfigParameters {
	@Parameter
	@Optional
	private String selector;
	@Parameter
	@Optional(defaultValue = "10")
	private int maxWaitSeconds;

}
