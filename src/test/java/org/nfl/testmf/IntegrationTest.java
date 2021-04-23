package org.nfl.testmf;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.nfl.testmf.MfMainGatewayApp;
import org.nfl.testmf.config.TestSecurityConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { MfMainGatewayApp.class, TestSecurityConfiguration.class })
public @interface IntegrationTest {
}
