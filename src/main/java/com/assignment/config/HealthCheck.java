package com.assignment.config;

import static com.assignment.constant.Constants.APPLICATION_NAME;
import static com.assignment.constant.Constants.APPLICATION_VERSION;
import static com.assignment.constant.Constants.NAME;
import static com.assignment.constant.Constants.VERSION;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * The Class HealthCheck.
 */
@Component
public class HealthCheck implements HealthIndicator {
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(HealthCheck.class);
	
	/** The environment. */
	@Autowired
	private Environment environment;
  
    /* (non-Javadoc)
     * @see org.springframework.boot.actuate.health.HealthIndicator#health()
     */
    @Override
    public Health health() {
    	logger.info("Health Actuator Invoked");
        return new Builder().withDetail(NAME, environment.getProperty(APPLICATION_NAME))
				.withDetail(VERSION, environment.getProperty(APPLICATION_VERSION)).up().build();
    }
}
