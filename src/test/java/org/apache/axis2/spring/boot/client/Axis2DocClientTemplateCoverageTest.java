package org.apache.axis2.spring.boot.client;

import java.util.HashMap;
import java.util.Map;

import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Unit tests for {@link Axis2DocClientTemplate}.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 */
class Axis2DocClientTemplateCoverageTest {

    @Test
    void defaultConstructor() {
        Axis2DocClientTemplate template = new Axis2DocClientTemplate();
        assertThat(template.overrideOptions).isNull();
    }

    @Test
    void constructorWithOptions() {
        Options options = new Options();
        options.setAction("test-action");
        Axis2DocClientTemplate template = new Axis2DocClientTemplate(options);
        assertThat(template.overrideOptions).isNotNull();
        assertThat(template.overrideOptions.getAction()).isEqualTo("test-action");
    }

    @Test
    void constructorWithNullOptions() {
        Axis2DocClientTemplate template = new Axis2DocClientTemplate(null);
        assertThat(template.overrideOptions).isNull();
    }

    @Test
    void sendReceiveWithActionAndArgs() {
        Options opts = new Options();
        opts.setAction("test");
        Axis2DocClientTemplate template = new Axis2DocClientTemplate(opts);
        Map<String, String> args = new HashMap<>();
        args.put("param1", "value1");
        assertThatThrownBy(() -> template.sendReceive("http://localhost:19999/test", "urn:action", "urn:ns", "method", args))
                .isInstanceOf(Exception.class);
    }

    @Test
    void sendReceiveWithAction() {
        Axis2DocClientTemplate template = new Axis2DocClientTemplate(new Options());
        assertThatThrownBy(() -> template.sendReceive("http://localhost:19999/test", "urn:action", "urn:ns", "method"))
                .isInstanceOf(Exception.class);
    }

    @Test
    void sendReceiveWithNamespaceAndMethod() {
        Axis2DocClientTemplate template = new Axis2DocClientTemplate(new Options());
        assertThatThrownBy(() -> template.sendReceive("http://localhost:19999/test", "urn:ns", "method"))
                .isInstanceOf(Exception.class);
    }

    @Test
    void sendReceiveWithNamespaceMethodAndArgs() {
        Axis2DocClientTemplate template = new Axis2DocClientTemplate(new Options());
        Map<String, String> args = new HashMap<>();
        args.put("key", "val");
        assertThatThrownBy(() -> template.sendReceive("http://localhost:19999/test", "urn:ns", "method", args))
                .isInstanceOf(Exception.class);
    }

    @Test
    void sendReceiveNonBlocking() throws Exception {
        Axis2DocClientTemplate template = new Axis2DocClientTemplate(new Options());
        Map<String, String> args = new HashMap<>();
        // sendReceiveNonBlocking is async and does not throw on connection failure
        template.sendReceiveNonBlocking("http://localhost:19999/test", "urn:action", "urn:ns", "method", args, null);
    }
}
