import lombok.extern.slf4j.Slf4j;

import java.text.NumberFormat;

/**
 * @author kan
 */
@Slf4j
public class FactoryNumberFormat {
    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
    NumberFormat percentFormatter = NumberFormat.getPercentInstance();

    public void printNumberFormat(double x) {
        log.info("Currency: " + this.currencyFormatter.format(x));
        log.info("Percent: " + this.percentFormatter.format(x));
    }
}
