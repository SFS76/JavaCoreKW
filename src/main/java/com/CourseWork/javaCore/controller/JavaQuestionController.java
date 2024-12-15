package com.CourseWork.javaCore.controller;

import com.CourseWork.javaCore.model.Question;
import com.CourseWork.javaCore.service.QuestionService;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("*/exam/java")
public class JavaQuestionController {

    @PostConstruct
    private void initQuestions() {
        add("1", "a");
        add("2", "b");
        add("3", "c");
        add("4", "d");
        add("5", "e");
        add("6", "f");
        add("7", "g");
    }

    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("add")
    public Question add(String question, String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping("remove")
    public Question remove(String question, String answer) {
        return questionService.remove(new Question(question, answer));
    }

    @GetMapping
    public Collection<Question> getAll() {
        return questionService.getAll();
    }
}
