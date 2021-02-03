package ir.dotin.video.limits.service.controller;

import ir.dotin.video.limits.service.model.dto.LimitConfiguration;
import ir.dotin.video.limits.service.service.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mohammad Yasin Sadeghi
 */
@RestController
public class LimitsConfigurationController {
    private Configuration configuration;

    public LimitsConfigurationController(Configuration configuration) {
        this.configuration = configuration;
    }

    @GetMapping(value = "limits")
    public LimitConfiguration retrieveLimitsFromConfiguration() {
        return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
    }
}
