package com.lukman.otus;

import com.lukman.otus.entity.Option;
import com.lukman.otus.entity.Question;
import com.lukman.otus.service.QuestionService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App {
    public static void main( String[] args ) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        QuestionService service = context.getBean(QuestionService.class);
        List<Question> questionList = service.getAll();
        for (Question question : questionList) {
            System.out.println("Question " + question.getId() + ": " + question.getQuestion());
            System.out.println("Options: ");
            for (Option option : question.getOptionList()) {
                System.out.println(option.getText());
            }
        }
    }
}
