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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Wager {

    private static final Logger LOGGER = LoggerFactory.getLogger(Wager.class);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany
    @JoinColumn(name = "outcome_odd_id")
    private List<OutcomeOdd> outcomeOdds;

    @OneToOne
    private Player player;

    @Column
    private BigDecimal amount;

    @Column
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @Column
    private Date timestamp;

    @Column(name = "is_processed")
    private boolean isProcessed;

    @Setter(AccessLevel.NONE)
    @Column(name = "is_winn")
    private boolean isWinn;

    public Wager() {
        outcomeOdds = new ArrayList<>();
    }

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

    public void addOutcomeOdd(OutcomeOdd outcomeOdd) {
        outcomeOdds.add(outcomeOdd);
    }

    public void setIsWin(boolean isWin){
        this.isWinn = isWin;
        if(isWin) {
            notifyPlayer();
        }
    }

    private void notifyPlayer() {
        final float oddValue = outcomeOdds.get(0).getOddValue();
        final BigDecimal outcomeMoney = amount.multiply(new BigDecimal(oddValue));
        BigDecimal newBalance = Money.roundBigDecimal(player.getBalance().add(outcomeMoney));
        player.setBalance(newBalance);
        LOGGER.info((String.format("%s new balance is %s", player.getName(), player.getBalance().toString())));
    }
}
