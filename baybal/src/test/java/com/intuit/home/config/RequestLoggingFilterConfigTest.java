package com.intuit.home.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RequestLoggingFilterConfigTest {
    RequestLoggingFilterConfig requestLoggingFilterConfig;

    @BeforeEach
    public void init() {
        requestLoggingFilterConfig = new RequestLoggingFilterConfig();
    }

    @Test
    public void logFilter() {
        CommonsRequestLoggingFilter requestLoggingFilter = requestLoggingFilterConfig.logFilter();
        assertNotNull(requestLoggingFilter);
    }
}
