package com.activemq.internal.parameters;

import java.util.List;
import java.util.Map;

import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.Parameter;

public class TestParameters {
	@Parameter
	@Optional

	private String stringParam;
	@Parameter
	@Optional
	private int intParam;
	@Parameter
	@Optional
	private boolean boolParam;
	
	@Parameter
	@Optional
	private List<String> listOfStrings;
	@Parameter
	@Optional
	private Map<String, String> mapParam;

	
	
}
