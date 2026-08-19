package org.apache.axis2.spring.boot.client;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p>Configuration properties.</p>
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
@ConfigurationProperties(Axis2ClientProperties.PREFIX)
public class Axis2ClientProperties {

	public static final String PREFIX = "axis2.client";
 
	/**
	 * Enable Axis2 Client.
	 */
	private boolean enabled = true;

    // client options for this service interaction
    private Axis2ClientOptions options = new Axis2ClientOptions();
    
	/**
	 * Returns the enabled.
	 *
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * Sets the enabled.
	 *
	 * @param enabled the enabled
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * Returns the options.
	 *
	 * @return the options
	 */
	public Axis2ClientOptions getOptions() {
		return options;
	}

	/**
	 * Sets the options.
	 *
	 * @param options the options
	 */
	public void setOptions(Axis2ClientOptions options) {
		this.options = options;
	}
	
}