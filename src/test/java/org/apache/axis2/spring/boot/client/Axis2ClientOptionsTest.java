package org.apache.axis2.spring.boot.client;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit tests for {@link Axis2ClientOptions}.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 */
class Axis2ClientOptionsTest {

    @Test
    void defaultValues() {
        Axis2ClientOptions options = new Axis2ClientOptions();
        assertThat(options.isExceptionToBeThrownOnSoapFault()).isFalse();
        assertThat(options.getTimeOutInMilliSeconds()).isEqualTo(-1L);
        assertThat(options.isUseSeparateListener()).isFalse();
        assertThat(options.getAction()).isNull();
        assertThat(options.getTransportInProtocol()).isNull();
        assertThat(options.isManageSession()).isFalse();
        assertThat(options.isCallTransportCleanup()).isFalse();
        assertThat(options.getUserName()).isNull();
        assertThat(options.getPassword()).isNull();
        assertThat(options.getProperties()).isNotNull().isEmpty();
    }

    @Test
    void setAndGetExceptionToBeThrownOnSoapFault() {
        Axis2ClientOptions options = new Axis2ClientOptions();
        options.setExceptionToBeThrownOnSoapFault(true);
        assertThat(options.isExceptionToBeThrownOnSoapFault()).isTrue();
        options.setExceptionToBeThrownOnSoapFault(false);
        assertThat(options.isExceptionToBeThrownOnSoapFault()).isFalse();
    }

    @Test
    void setAndGetTimeOutInMilliSeconds() {
        Axis2ClientOptions options = new Axis2ClientOptions();
        options.setTimeOutInMilliSeconds(5000L);
        assertThat(options.getTimeOutInMilliSeconds()).isEqualTo(5000L);
    }

    @Test
    void setAndGetUseSeparateListener() {
        Axis2ClientOptions options = new Axis2ClientOptions();
        options.setUseSeparateListener(true);
        assertThat(options.isUseSeparateListener()).isTrue();
    }

    @Test
    void setAndGetAction() {
        Axis2ClientOptions options = new Axis2ClientOptions();
        options.setAction("urn:test");
        assertThat(options.getAction()).isEqualTo("urn:test");
    }

    @Test
    void setAndGetTransportInProtocol() {
        Axis2ClientOptions options = new Axis2ClientOptions();
        options.setTransportInProtocol("http");
        assertThat(options.getTransportInProtocol()).isEqualTo("http");
    }

    @Test
    void setAndGetManageSession() {
        Axis2ClientOptions options = new Axis2ClientOptions();
        options.setManageSession(true);
        assertThat(options.isManageSession()).isTrue();
    }

    @Test
    void setAndGetCallTransportCleanup() {
        Axis2ClientOptions options = new Axis2ClientOptions();
        options.setCallTransportCleanup(true);
        assertThat(options.isCallTransportCleanup()).isTrue();
    }

    @Test
    void setAndGetUserName() {
        Axis2ClientOptions options = new Axis2ClientOptions();
        options.setUserName("admin");
        assertThat(options.getUserName()).isEqualTo("admin");
    }

    @Test
    void setAndGetPassword() {
        Axis2ClientOptions options = new Axis2ClientOptions();
        options.setPassword("secret");
        assertThat(options.getPassword()).isEqualTo("secret");
    }

    @Test
    void setAndGetProperties() {
        Axis2ClientOptions options = new Axis2ClientOptions();
        Map<String, Object> props = new HashMap<>();
        props.put("key1", "value1");
        props.put("key2", 42);
        options.setProperties(props);
        assertThat(options.getProperties()).containsEntry("key1", "value1").containsEntry("key2", 42);
    }
}
