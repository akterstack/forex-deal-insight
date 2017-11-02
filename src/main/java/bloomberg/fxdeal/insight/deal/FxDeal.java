package bloomberg.fxdeal.insight.deal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Currency;

public class FxDeal {

    @Id
    private String id;

    @Indexed @NotNull(message = "UUID cannot be null")
    private String uuid;

    @NotNull(message = "Order Currency from cannot be null")
    private Currency fromCurrency;

    @NotNull(message = "Currency to convert to cannot be null")
    private Currency toCurrency;

    private Timestamp timestamp;

    @NotNull(message = "Amount cannot be null")
    private Double amount;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Currency getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(Currency fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public Currency getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(Currency toCurrency) {
        this.toCurrency = toCurrency;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return uuid + ":" + fromCurrency;
    }
}
