package org.apache.axis2.spring.boot.client;

import org.apache.axis2.client.Options;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit tests for {@link Axis2RpcClientTemplate}.
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 */
class Axis2RpcClientTemplateCoverageTest {

    @Test
    void defaultConstructor() {
        Axis2RpcClientTemplate template = new Axis2RpcClientTemplate();
        assertThat(template.overrideOptions).isNull();
    }

    @Test
    void constructorWithOptions() {
        Options options = new Options();
        options.setAction("test-action");
        Axis2RpcClientTemplate template = new Axis2RpcClientTemplate(options);
        assertThat(template.overrideOptions).isNotNull();
        assertThat(template.overrideOptions.getAction()).isEqualTo("test-action");
    }

    @Test
    void constructorWithNullOptions() {
        Axis2RpcClientTemplate template = new Axis2RpcClientTemplate(null);
        assertThat(template.overrideOptions).isNull();
    }
}
