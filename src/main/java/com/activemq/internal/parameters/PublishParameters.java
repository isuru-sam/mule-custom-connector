package com.activemq.internal.parameters;

import java.io.InputStream;
import java.util.Map;

import org.mule.runtime.api.meta.ExpressionSupport;
import org.mule.runtime.api.metadata.TypedValue;
import org.mule.runtime.extension.api.annotation.Expression;
import org.mule.runtime.extension.api.annotation.param.ConfigOverride;
import org.mule.runtime.extension.api.annotation.param.Content;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Example;
import org.mule.runtime.extension.api.annotation.param.display.Summary;

public class PublishParameters {
	@Parameter
	@Summary("Summary")
	//expression support by default
	@Content(primary = true)
	private TypedValue<InputStream> body;
	
	@Parameter
	@Optional
	@Summary("summary")
	@Expression(ExpressionSupport.NOT_SUPPORTED)
	@DisplayName("Content Type")
	@Example("application/json")
	private String contentType;
	
	
	@Parameter
	@Optional
	@Summary("summary")
	@Expression(ExpressionSupport.NOT_SUPPORTED)
	@DisplayName("Encoding")
	@Example("utf-8")
	private String encoding;
	

	@Parameter
	@Optional
	@Summary("summary")
	
	@DisplayName("JMS type")
	@ConfigOverride
	private String type;
	
	@Parameter
	@Optional
	@Summary("summary")
	@ConfigOverride
	private int priority;
	
	@Parameter
	@Optional
	@Summary("summary")
	
	@Example(value="#[uuid()]")
	
	private String corelationId;
	
	@Parameter
	@Optional
	@Summary("summary")
	
	@DisplayName("User Properties")
	@Content
	private Map<String, String> userProperties;

}
