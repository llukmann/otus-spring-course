package com.lukman.otus.repo.impl;

import com.lukman.otus.entity.Question;
import com.lukman.otus.repo.QuestionRepository;
import com.lukman.otus.utils.QuestionUtils;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class QuestionRepositoryImpl implements QuestionRepository {
    private final QuestionUtils questionUtils;

    @Override
    public List<Question> findAll() {
        List<String> questionStringList = questionUtils.getRecords();
        List<Question> questionList = new ArrayList<>();
        for (String questionString : questionStringList) {
            questionList.add(questionUtils.getQuestionFromRecord(questionString));
        }
        return questionList;
    }

}
