package com.CourseWork.javaCore.service.impl;

import com.CourseWork.javaCore.exception.FullQuestionsException;
import com.CourseWork.javaCore.model.Question;
import com.CourseWork.javaCore.service.ExaminerService;
import com.CourseWork.javaCore.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        int totalQuestions = questionService.getAll().size();
        if (amount > totalQuestions) {
            throw new FullQuestionsException("Количество запрошенных вопросов "+amount+" превышает общее количество вопросов "+totalQuestions);
        }

        Set<Question> randomQuestion = new HashSet<>();

        while (randomQuestion.size() < amount) {
            randomQuestion.add(questionService.getRandomQuestion());
        }

        return randomQuestion;
    }
}
