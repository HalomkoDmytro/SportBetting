package com.epam.training.model.sportevent;


import com.epam.training.model.bet.Bet;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@MappedSuperclass
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public abstract class AbstractSportEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    @Column
    protected String title;

    @Column(name = "start_date")
    protected Date startDate;

    @Column(name = "end_date")
    protected Date endDate;

    @Setter(AccessLevel.NONE)
    @Column(name = "event")
    @Enumerated(EnumType.STRING)
    protected Event event;

    @OneToOne()
    @JoinColumn(name = "result_id", referencedColumnName = "id")
    private Result result;

    @OneToMany(mappedBy = "event")
    private List<Bet> betList = new ArrayList<>();

    @Override
    public String toString() {
        return "SportEvent{" +
                "title='" + title + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", event=" + event +
                '}';
    }
}