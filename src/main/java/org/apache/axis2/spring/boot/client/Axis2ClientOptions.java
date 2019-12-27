/*
 * Copyright (c) 2018, hiwepy (https://github.com/hiwepy).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.apache.axis2.spring.boot.client;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 * 
 * @author ： <a href="https://github.com/hiwepy">hiwepy</a>
 */
public class Axis2ClientOptions {

	// ==========================================================================
	// Parameters that can be set via Options
	// ==========================================================================

	private boolean exceptionToBeThrownOnSoapFault; // defaults to true;

	private long timeOutInMilliSeconds = -1; // =
	// DEFAULT_TIMEOUT_MILLISECONDS;

	private boolean useSeparateListener; // defaults to false

	// Addressing specific properties
	private String action;

	private String transportInProtocol;

	// To control , session management , default is set to true , if user wants he
	// can set that to true
	// The operation client will manage session using ServiceGroupID if it is there
	// in the response
	private boolean manageSession = false;

	// This property can be used to specify to call the auto transport clean up
	private boolean callTransportCleanup;
	private String userName;
	private String password;

	/**
     * @serial properties
     */
    private Map<String, Object> properties = new HashMap<String, Object>();;

	public boolean isExceptionToBeThrownOnSoapFault() {
		return exceptionToBeThrownOnSoapFault;
	}

	public void setExceptionToBeThrownOnSoapFault(boolean exceptionToBeThrownOnSoapFault) {
		this.exceptionToBeThrownOnSoapFault = exceptionToBeThrownOnSoapFault;
	}

	public long getTimeOutInMilliSeconds() {
		return timeOutInMilliSeconds;
	}

	public void setTimeOutInMilliSeconds(long timeOutInMilliSeconds) {
		this.timeOutInMilliSeconds = timeOutInMilliSeconds;
	}

	public boolean isUseSeparateListener() {
		return useSeparateListener;
	}

	public void setUseSeparateListener(boolean useSeparateListener) {
		this.useSeparateListener = useSeparateListener;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getTransportInProtocol() {
		return transportInProtocol;
	}

	public void setTransportInProtocol(String transportInProtocol) {
		this.transportInProtocol = transportInProtocol;
	}

	public boolean isManageSession() {
		return manageSession;
	}

	public void setManageSession(boolean manageSession) {
		this.manageSession = manageSession;
	}

	public boolean isCallTransportCleanup() {
		return callTransportCleanup;
	}

	public void setCallTransportCleanup(boolean callTransportCleanup) {
		this.callTransportCleanup = callTransportCleanup;
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

	public Map<String, Object> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}
	
}
