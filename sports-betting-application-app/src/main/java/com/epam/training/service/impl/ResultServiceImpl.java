package com.epam.training.service.impl;

import com.epam.training.dao.ResultDao;
import com.epam.training.exception.notFound.ResultNotFoundException;
import com.epam.training.model.sportevent.Result;
import com.epam.training.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {

    private final ResultDao resultDao;

    @Autowired
    public ResultServiceImpl(ResultDao resultDao) {
        this.resultDao = resultDao;
    }

    @Override
    public Result getById(int id) {
        return resultDao.findById(id)
                .orElseThrow(() -> new ResultNotFoundException(String.format("Result with id %d not found.", id)));
    }

    @Override
    public List<Result> findAll() {
        return resultDao.findAll();
    }

    @Override
    public Result save(Result result) {
        return resultDao.save(result);
    }

    @Override
    public Result update(Result result) {
        return resultDao.save(result);
    }

    @Override
    public void delete(Result result) {
        resultDao.delete(result);
    }
}
