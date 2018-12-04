package org.apache.axis2.spring.boot.client;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(Axis2ClientProperties.PREFIX)
public class Axis2ClientProperties {

	public static final String PREFIX = "axis2.client";
 
	/**
	 * Enable Axis2 Client.
	 */
	private boolean enabled = true;

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
}