package org.apache.axis2.spring.boot.client;

import org.apache.axis2.client.Options;
import org.apache.axis2.context.ConfigurationContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Unit tests for {@link Axis2ClientAutoConfiguration}.
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 */
class Axis2ClientAutoConfigurationTest {

    @Test
    void configContext() throws Exception {
        Axis2ClientAutoConfiguration config = new Axis2ClientAutoConfiguration();
        ConfigurationContext ctx = config.configContext();
        assertThat(ctx).isNotNull();
    }

    @SuppressWarnings("unchecked")
    private ObjectProvider<org.apache.axis2.kernel.TransportListener> mockTransportListenerProvider() {
        ObjectProvider<org.apache.axis2.kernel.TransportListener> provider = mock(ObjectProvider.class);
        when(provider.getIfAvailable()).thenReturn(null);
        return provider;
    }

    @Test
    void overrideOptions() throws Exception {
        Axis2ClientAutoConfiguration config = new Axis2ClientAutoConfiguration();
        Axis2ClientProperties properties = new Axis2ClientProperties();
        Axis2ClientOptions options = properties.getOptions();
        options.setAction("test-action");
        options.setPassword("pass");
        options.setUserName("user");
        options.setTimeOutInMilliSeconds(3000L);
        options.setTransportInProtocol("http");
        options.setManageSession(true);
        options.setCallTransportCleanup(true);
        options.setExceptionToBeThrownOnSoapFault(true);
        options.setUseSeparateListener(true);

        Options result = config.overrideOptions(properties, mockTransportListenerProvider());
        assertThat(result).isNotNull();
        assertThat(result.getAction()).isEqualTo("test-action");
        assertThat(result.getPassword()).isEqualTo("pass");
        assertThat(result.getUserName()).isEqualTo("user");
        assertThat(result.getTimeOutInMilliSeconds()).isEqualTo(3000L);
        assertThat(result.getTransportInProtocol()).isEqualTo("http");
    }

    @Test
    void overrideOptionsWithNullValues() throws Exception {
        Axis2ClientAutoConfiguration config = new Axis2ClientAutoConfiguration();
        Axis2ClientProperties properties = new Axis2ClientProperties();
        // Leave all options at defaults (nulls)

        Options result = config.overrideOptions(properties, mockTransportListenerProvider());
        assertThat(result).isNotNull();
    }

    @Test
    void axis2DocClientTemplate() throws Exception {
        Axis2ClientAutoConfiguration config = new Axis2ClientAutoConfiguration();
        Options options = new Options();
        Axis2DocClientTemplate template = config.axis2DocClientTemplate(options);
        assertThat(template).isNotNull();
        assertThat(template.overrideOptions).isSameAs(options);
    }

    @Test
    void axis2RpcClientTemplate() throws Exception {
        Axis2ClientAutoConfiguration config = new Axis2ClientAutoConfiguration();
        Options options = new Options();
        Axis2RpcClientTemplate template = config.axis2RpcClientTemplate(options);
        assertThat(template).isNotNull();
        assertThat(template.overrideOptions).isSameAs(options);
    }

    @Test
    void applicationContext() {
        Axis2ClientAutoConfiguration config = new Axis2ClientAutoConfiguration();
        assertThat(config.getApplicationContext()).isNull();
        org.springframework.context.support.GenericApplicationContext ctx =
                new org.springframework.context.support.GenericApplicationContext();
        config.setApplicationContext(ctx);
        assertThat(config.getApplicationContext()).isSameAs(ctx);
    }
}
