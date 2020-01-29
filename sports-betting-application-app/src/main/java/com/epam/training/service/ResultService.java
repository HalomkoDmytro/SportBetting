package com.epam.training.service;

import com.epam.training.model.sportevent.Result;

import java.util.List;

public interface ResultService {

    Result getById(int id);

    List<Result> findAll();

    Result save(Result result);

    Result update(Result result);

    void delete(Result result);
}
