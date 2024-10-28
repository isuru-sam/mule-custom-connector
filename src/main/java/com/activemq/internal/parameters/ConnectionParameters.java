package com.activemq.internal.parameters;

import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Password;
import org.mule.runtime.extension.api.annotation.param.display.Summary;

public class ConnectionParameters {
	@Parameter
	  //@Optional
	  //@Expression
	  @DisplayName("Broker URL")
	  @Summary("tooltip")
	  //@Placement
	 // @Text
	 // @Password
	  //@Example
	private String brokerUrl;
	@Optional
	private String userName;
	@Password
	@Optional
	private String password;
	public String getBrokerUrl() {
		return brokerUrl;
	}
	public void setBrokerUrl(String brokerUrl) {
		this.brokerUrl = brokerUrl;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
