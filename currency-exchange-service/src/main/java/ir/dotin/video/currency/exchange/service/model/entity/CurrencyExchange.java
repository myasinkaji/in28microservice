package ir.dotin.video.currency.exchange.service.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author Mohammad Yasin Sadeghi
 */
@Entity
@Data
public class CurrencyExchange {
    @Id
    private int id;
    @Column(name = "c_from")
    private String from;
    @Column(name = "c_to")
    private String to;
    private BigDecimal conversionFactor;

}
