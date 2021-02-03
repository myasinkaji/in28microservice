package ir.dotin.video.currency.conversion.service.srevice;

import ir.dotin.video.currency.conversion.service.model.vo.ConversionVO;
import ir.dotin.video.currency.conversion.service.srevice.client.CurrencyExchangeServiceProxy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mohammad Yasin Sadeghi
 */
@Service
public class CurrencyConversionService {
    private static final String CURRENCY_EXCHANGE_URI = "http://localhost:8001/currency-exchange/from/{from}/to/{to}";

    private final CurrencyExchangeServiceProxy proxy;

    public CurrencyConversionService(CurrencyExchangeServiceProxy proxy) {
        this.proxy = proxy;
    }

    public ConversionVO exchangeResponseFeign(String from, String to, BigDecimal quantity) {
        var response = proxy.exchange(from, to);
        response.setQuantity(quantity);
        response.setTotalAmount(response.getConversionMultiple().multiply(quantity));
        return response;
    }

    public ConversionVO exchangeResponse(String from, String to, BigDecimal quantity) {
        var client = new RestTemplate();
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);
        var response = client.getForEntity(CURRENCY_EXCHANGE_URI, ConversionVO.class, uriVariables);
        if (response.getStatusCode() == HttpStatus.OK) {
            final var conversionVO = response.getBody();
            conversionVO.setQuantity(quantity);
            conversionVO.setTotalAmount(conversionVO.getConversionMultiple().multiply(quantity));
            return conversionVO;
        } else
            return null;
    }
}
