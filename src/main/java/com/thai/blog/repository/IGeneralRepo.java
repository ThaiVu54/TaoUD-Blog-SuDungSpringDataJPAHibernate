package com.thai.blog.repository;

import java.util.List;

public interface IGeneralRepo <T>{
    List<T> findAll();

    T findById(Long id);

    void save(T model);

    void remove(Long id);
}
