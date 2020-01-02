package com.epam.training.model.wager;

import com.epam.training.model.outcome.OutcomeOdd;
import com.epam.training.model.user.Currency;
import com.epam.training.model.user.Player;
import com.epam.training.util.Money;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Wager {

    private static final Logger LOGGER = LoggerFactory.getLogger(Wager.class);

    private OutcomeOdd outcomeOdd;
    private Player player;

    private BigDecimal amount;
    private Currency currency;
    private Date timestamp;
    private boolean isProcessed;
    @Setter(AccessLevel.NONE)
    private boolean isWinn;

    @Override
    public String toString() {
        return "Wager{" +
                ", player=" + player +
                ", currency=" + currency +
                ", timestamp=" + timestamp +
                ", isProcessed=" + isProcessed +
                ", isWinn=" + isWinn +
                '}';
    }

    public void setIsWin(boolean isWin){
        this.isWinn = isWin;
        if(isWin) {
            notifyPlayer();
        }
    }

    private void notifyPlayer() {
        final float oddValue = outcomeOdd.getOddValue();
        final BigDecimal outcomeMoney = amount.multiply(new BigDecimal(oddValue));
        BigDecimal newBalance = Money.roundBigDecimal(player.getBalance().add(outcomeMoney));
        player.setBalance(newBalance);
        LOGGER.info((String.format("%s new balance is %s", player.getName(), player.getBalance().toString())));
    }
}
