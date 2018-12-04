package org.apache.axis2.spring.boot.client;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(Axis2ClientProperties.PREFIX)
public class Axis2ClientProperties {

	public static final String PREFIX = "axis2.client";
 
	/**
	 * Enable Axis2 Client.
	 */
	private boolean enabled = true;

    // client options for this service interaction
    private Axis2ClientOptions options = new Axis2ClientOptions();
    
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Axis2ClientOptions getOptions() {
		return options;
	}

	public void setOptions(Axis2ClientOptions options) {
		this.options = options;
	}
	
}