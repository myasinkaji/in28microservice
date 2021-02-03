package ir.dotin.video.currency.exchange.service.model.dao;

import ir.dotin.video.currency.exchange.service.model.entity.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Mohammad Yasin Sadeghi
 */
@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Integer> {

    CurrencyExchange findByFromAndTo(String from, String to);
}
