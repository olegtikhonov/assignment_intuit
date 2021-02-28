package com.intuit.home;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
public class RiskEngineMain {
    private static final Logger logger = LogManager.getLogger(RiskEngineMain.class.getName());

    public static void main(String[] args) {
        SpringApplicationBuilder app = new SpringApplicationBuilder(RiskEngineMain.class).web(WebApplicationType.SERVLET);
        app.build().addListeners(new ApplicationPidFileWriter("risk-engine-shutdown.pid"));
        app.run();
        logger.info(RiskEngineMain.class.getName() + " started.");
    }
}
