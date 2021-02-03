package ir.dotin.video.currency.exchange.service.model.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Mohammad Yasin Sadeghi
 */
@Data
public class ExchangeResponse {
    private final Long id;
    private final String from;
    private final String to;
    private final BigDecimal conversionMultiple;
    private int port;
}
