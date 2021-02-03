package ir.dotin.video.currency.conversion.service.srevice.client;


import ir.dotin.video.currency.conversion.service.model.vo.ConversionVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "currencyExchangeServiceProxy",
        url = CurrencyExchangeServiceProxy.CURRENCY_EXCHANGE_BASE_URI)
public interface CurrencyExchangeServiceProxy {
    String CURRENCY_EXCHANGE_BASE_URI = "http://localhost:8001/currency-exchange/";
    String CURRENCY_EXCHANGE_URI = "/from/{from}/to/{to}";

    @GetMapping(value = CURRENCY_EXCHANGE_URI)
    ConversionVO exchange(@PathVariable String from, @PathVariable String to);
}