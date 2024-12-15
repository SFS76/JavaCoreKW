package com.CourseWork.javaCore.service.impl;

import com.CourseWork.javaCore.model.Question;
import com.CourseWork.javaCore.service.QuestionService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionSeviceTest {

    private QuestionService questionService;

    @BeforeEach
    public void clear() {
        questionService = new JavaQuestionSevice();
    }

    @Test
    void add() {
        //ожидается
        Question expectedQuestion = new Question("8", "h");
        //реализация
        Question actualQuestion = questionService.add(expectedQuestion);
        //проверка
        Assertions.assertEquals(expectedQuestion, actualQuestion);
    }

    @Test
    void remove() {
        //ожидается
        Question expectedQuestion = new Question("8", "h");
        questionService.add(expectedQuestion);
        //реализация
        Question actualQuestion = questionService.remove(expectedQuestion);
        //проверка
        Assertions.assertEquals(expectedQuestion, actualQuestion);
    }

    @Test
    void getAll() {
        //ожидается
        Set<Question> questions = new HashSet<>();
            questionService.add("1", "a");
            questionService.add("2", "b");
            questionService.add("3", "c");
            questionService.add("4", "d");
            questionService.add("5", "e");
            questionService.add("6", "f");
            questionService.add("7", "g");
        //реализация
        Collection<Question> actualQuestion = questionService.getAll();
        //проверка
        Assertions.assertEquals(questions, actualQuestion);
    }

    @Test
    void getRandomQuestion() {
        //ожидается
        Set<Question> questions = new HashSet<>();
        questionService.add("1", "a");
        questionService.add("2", "b");
        questionService.add("3", "c");
        questionService.add("4", "d");
        questionService.add("5", "e");
        questionService.add("6", "f");
        questionService.add("7", "g");
        //реализация
        Question actualQuestion = questionService.getRandomQuestion();
        //проверка
        Assertions.assertTrue(questions.contains(actualQuestion));
    }
}