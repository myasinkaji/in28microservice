package ir.dotin.video.currency.exchange.service;

import ir.dotin.video.currency.exchange.service.model.dao.CurrencyExchangeRepository;
import ir.dotin.video.currency.exchange.service.model.entity.CurrencyExchange;
import org.springframework.stereotype.Service;

/**
 * @author Mohammad Yasin Sadeghi
 */
@Service
public class CurrencyExchangeService {
    private CurrencyExchangeRepository repository;

    public CurrencyExchangeService(CurrencyExchangeRepository repository) {
        this.repository = repository;
    }

    public CurrencyExchange find(String from, String to) {
        return repository.findByFromAndTo(from, to);
    }
}
