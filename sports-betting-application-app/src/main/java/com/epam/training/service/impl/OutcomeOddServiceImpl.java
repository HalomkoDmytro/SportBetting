package com.epam.training.service.impl;

import com.epam.training.dao.OutcomeOddDao;
import com.epam.training.exception.notFound.OutcomeOddNotFoundException;
import com.epam.training.model.outcome.OutcomeOdd;
import com.epam.training.service.OutcomeOddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutcomeOddServiceImpl implements OutcomeOddService {

    private final OutcomeOddDao outcomeOddDao;

    @Autowired
    public OutcomeOddServiceImpl(OutcomeOddDao outcomeOddDao) {
        this.outcomeOddDao = outcomeOddDao;
    }

    @Override
    public OutcomeOdd create(OutcomeOdd outcomeOdd) {
        return outcomeOddDao.save(outcomeOdd);
    }

    @Override
    public OutcomeOdd update(OutcomeOdd outcomeOdd) {
        return outcomeOddDao.save(outcomeOdd);
    }

    @Override
    public List<OutcomeOdd> findAll() {
        return outcomeOddDao.findAll();
    }

    @Override
    public OutcomeOdd findById(int id) {
        return outcomeOddDao.findById(id)
                .orElseThrow(() -> new OutcomeOddNotFoundException(String.format("OutcomeOdd with id %d not found", id)));
    }

    @Override
    public void delete(OutcomeOdd outcomeOdd) {
        outcomeOddDao.delete(outcomeOdd);
    }

    @Override
    public OutcomeOdd findWithOutcome(int id) {
        return outcomeOddDao.findById(id)
                .orElseThrow(() -> new OutcomeOddNotFoundException(String.format("OutcomeOdd with Outcome by Outcome id: %d not found", id)));
    }
}
