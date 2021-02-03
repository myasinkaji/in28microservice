package ir.dotin.video.limits.service.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Mohammad Yasin Sadeghi
 */
@Component
@ConfigurationProperties(prefix = "limit-service")
@Getter
@Setter
public class Configuration {
    private int minimum;
    private int maximum;
}
