package org.metabook.server;

import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Base class to implement transactional integration tests using the root application configuration.
 * 
 * @author Ian Morris
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = ApplicationConfiguration.class)
//@SpringApplicationConfiguration(classes = MetabookServerAppConfig.class)
@Transactional
public abstract class AbstractIntegrationTest {

}
