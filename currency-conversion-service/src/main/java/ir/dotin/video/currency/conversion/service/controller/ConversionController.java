package ir.dotin.video.currency.conversion.service.controller;

import ir.dotin.video.currency.conversion.service.model.vo.ConversionVO;
import ir.dotin.video.currency.conversion.service.srevice.CurrencyConversionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author Mohammad Yasin Sadeghi
 */
@RestController
@RequestMapping(value = "/currency-conversion")
public class ConversionController {

    private final CurrencyConversionService service;

    public ConversionController(CurrencyConversionService service) {
        this.service = service;
    }

    @GetMapping(value = "/from/{from}/to/{to}/quantity/{quantity}")
    public ConversionVO convert(@PathVariable String from,
                                @PathVariable String to, @PathVariable BigDecimal quantity) {
        return service.exchangeResponseFeign(from, to, quantity);
    }

}
