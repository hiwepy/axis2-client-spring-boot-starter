package org.apache.axis2.spring.boot.client;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit tests for {@link Axis2ClientProperties}.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 */
class Axis2ClientPropertiesTest {

    @Test
    void defaultPrefix() {
        assertThat(Axis2ClientProperties.PREFIX).isEqualTo("axis2.client");
    }

    @Test
    void defaultValues() {
        Axis2ClientProperties properties = new Axis2ClientProperties();
        assertThat(properties.isEnabled()).isTrue();
        assertThat(properties.getOptions()).isNotNull();
    }

    @Test
    void setAndEnabled() {
        Axis2ClientProperties properties = new Axis2ClientProperties();
        properties.setEnabled(false);
        assertThat(properties.isEnabled()).isFalse();
    }

    @Test
    void setAndGetOptions() {
        Axis2ClientProperties properties = new Axis2ClientProperties();
        Axis2ClientOptions options = new Axis2ClientOptions();
        options.setAction("test-action");
        properties.setOptions(options);
        assertThat(properties.getOptions().getAction()).isEqualTo("test-action");
    }
}
