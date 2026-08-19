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
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
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

	/**
	 * Returns the exception to be thrown on soap fault.
	 *
	 * @return the exception to be thrown on soap fault
	 */
	public boolean isExceptionToBeThrownOnSoapFault() {
		return exceptionToBeThrownOnSoapFault;
	}

	/**
	 * Sets the exception to be thrown on soap fault.
	 *
	 * @param exceptionToBeThrownOnSoapFault the exception to be thrown on soap fault
	 */
	public void setExceptionToBeThrownOnSoapFault(boolean exceptionToBeThrownOnSoapFault) {
		this.exceptionToBeThrownOnSoapFault = exceptionToBeThrownOnSoapFault;
	}

	/**
	 * Returns the time out in milli seconds.
	 *
	 * @return the time out in milli seconds
	 */
	public long getTimeOutInMilliSeconds() {
		return timeOutInMilliSeconds;
	}

	/**
	 * Sets the time out in milli seconds.
	 *
	 * @param timeOutInMilliSeconds the time out in milli seconds
	 */
	public void setTimeOutInMilliSeconds(long timeOutInMilliSeconds) {
		this.timeOutInMilliSeconds = timeOutInMilliSeconds;
	}

	/**
	 * Returns the use separate listener.
	 *
	 * @return the use separate listener
	 */
	public boolean isUseSeparateListener() {
		return useSeparateListener;
	}

	/**
	 * Sets the use separate listener.
	 *
	 * @param useSeparateListener the use separate listener
	 */
	public void setUseSeparateListener(boolean useSeparateListener) {
		this.useSeparateListener = useSeparateListener;
	}

	/**
	 * Returns the action.
	 *
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * Sets the action.
	 *
	 * @param action the action
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * Returns the transport in protocol.
	 *
	 * @return the transport in protocol
	 */
	public String getTransportInProtocol() {
		return transportInProtocol;
	}

	/**
	 * Sets the transport in protocol.
	 *
	 * @param transportInProtocol the transport in protocol
	 */
	public void setTransportInProtocol(String transportInProtocol) {
		this.transportInProtocol = transportInProtocol;
	}

	/**
	 * Returns the manage session.
	 *
	 * @return the manage session
	 */
	public boolean isManageSession() {
		return manageSession;
	}

	/**
	 * Sets the manage session.
	 *
	 * @param manageSession the manage session
	 */
	public void setManageSession(boolean manageSession) {
		this.manageSession = manageSession;
	}

	/**
	 * Returns the call transport cleanup.
	 *
	 * @return the call transport cleanup
	 */
	public boolean isCallTransportCleanup() {
		return callTransportCleanup;
	}

	/**
	 * Sets the call transport cleanup.
	 *
	 * @param callTransportCleanup the call transport cleanup
	 */
	public void setCallTransportCleanup(boolean callTransportCleanup) {
		this.callTransportCleanup = callTransportCleanup;
	}

	/**
	 * Returns the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName the user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Returns the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public Map<String, Object> getProperties() {
		return properties;
	}

	/**
	 * Sets the properties.
	 *
	 * @param properties the properties
	 */
	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}
	
}
