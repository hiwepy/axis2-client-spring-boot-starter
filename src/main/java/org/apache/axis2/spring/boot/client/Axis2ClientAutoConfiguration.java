package org.apache.axis2.spring.boot.client;

import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.context.ConfigurationContextFactory;
import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
 

@Configuration
@ConditionalOnProperty(prefix = Axis2ClientProperties.PREFIX, value = "enabled", havingValue = "true")
@EnableConfigurationProperties({ Axis2ClientProperties.class })
@AutoConfigureOrder(Ordered.LOWEST_PRECEDENCE - 8)
public class Axis2ClientAutoConfiguration implements ApplicationContextAware {

	private ApplicationContext applicationContext;
 
	@Bean
	public ConfigurationContext configContext() throws Exception {
		return ConfigurationContextFactory.createDefaultConfigurationContext();
	}
	
	@Bean
	public Axis2DocClientTemplate axis2DocClientTemplate() throws Exception {
		return new Axis2DocClientTemplate();
	}
	
	@Bean
	public Axis2RpcClientTemplate axis2RpcClientTemplate() throws Exception {
		return new Axis2RpcClientTemplate();
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

}
