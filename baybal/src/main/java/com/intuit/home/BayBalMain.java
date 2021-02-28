package com.intuit.home;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
public class BayBalMain {
    private static final Logger logger = LogManager.getLogger(BayBalMain.class.getName());

    public static void main(String[] args) {
        SpringApplicationBuilder app = new SpringApplicationBuilder(BayBalMain.class).web(WebApplicationType.SERVLET);
        app.build().addListeners(new ApplicationPidFileWriter("shutdown.pid"));
        app.run();
        logger.info(BayBalMain.class.getName() + " started.");
    }
}
