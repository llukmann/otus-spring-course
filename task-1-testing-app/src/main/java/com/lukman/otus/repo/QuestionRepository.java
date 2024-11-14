package com.lukman.otus.repo;

import com.lukman.otus.entity.Question;

import java.util.List;

public interface QuestionRepository {
    List<Question> findAll();
}
