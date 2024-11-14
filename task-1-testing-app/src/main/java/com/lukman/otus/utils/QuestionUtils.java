package com.lukman.otus.utils;

import com.lukman.otus.entity.Option;
import com.lukman.otus.entity.Question;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuestionUtils {
    private static final String PATH_TO_QUESTIONS = "src/main/resources/csv/questions.csv";

    public List<String> getRecords() {
        List<String> records = new ArrayList<>();
        Path path = Paths.get(PATH_TO_QUESTIONS);
        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNextLine()) {
                records.add(scanner.nextLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return records;
    }

    public Question getQuestionFromRecord(String record) {
        List<Option> optionList = new ArrayList<>();
        Question question = new Question();

        try (Scanner scanner = new Scanner(record)) {
            scanner.useDelimiter(";");
            question.setId(scanner.nextLong());
            question.setQuestion(scanner.next());

            while (scanner.hasNext()) {
                optionList.add(new Option(scanner.next()));
            }
            question.setOptionList(optionList);
        }

        return question;
    }
}
