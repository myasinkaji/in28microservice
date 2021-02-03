package ir.dotin.video.limits.service.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Mohammad Yasin Sadeghi
 */
@Data
@AllArgsConstructor
public class LimitConfiguration {
    private int maximum;
    private int minimum;

}
