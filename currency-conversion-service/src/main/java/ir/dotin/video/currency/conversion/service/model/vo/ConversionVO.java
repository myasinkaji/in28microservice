package ir.dotin.video.currency.conversion.service.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Mohammad Yasin Sadeghi
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConversionVO {
    private int id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private BigDecimal quantity;
    private BigDecimal totalAmount;
    private int port;
}
