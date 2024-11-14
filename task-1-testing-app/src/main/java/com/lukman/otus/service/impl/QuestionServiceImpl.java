package com.lukman.otus.service.impl;

import com.lukman.otus.entity.Question;
import com.lukman.otus.repo.QuestionRepository;
import com.lukman.otus.service.QuestionService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }
}
