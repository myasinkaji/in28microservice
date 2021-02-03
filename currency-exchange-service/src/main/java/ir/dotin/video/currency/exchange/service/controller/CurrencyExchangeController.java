package ir.dotin.video.currency.exchange.service.controller;

import ir.dotin.video.currency.exchange.service.CurrencyExchangeService;
import ir.dotin.video.currency.exchange.service.model.vo.ExchangeResponse;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author Mohammad Yasin Sadeghi
 */
@RestController
@RequestMapping(value = "/currency-exchange")
public class CurrencyExchangeController {

    private static final String SPRING_PORT_PROPERTY = "local.server.port";
    private CurrencyExchangeService service;
    private Environment environment;

    public CurrencyExchangeController(CurrencyExchangeService service, Environment environment) {
        this.service = service;
        this.environment = environment;
    }

    @GetMapping(value = "/from/{from}/to/{to}")
    public ExchangeResponse exchange(@PathVariable String from, @PathVariable String to) {

        try {
            final var entity = service.find(from, to);
            final var response = new ExchangeResponse((long) entity.getId(),
                    entity.getFrom(), entity.getTo(), entity.getConversionFactor());
            response.setPort(Integer.parseInt(Objects.requireNonNull(environment.getProperty(SPRING_PORT_PROPERTY))));
            return response;
        } catch (Exception e) {
            return null;
        }
    }
}
