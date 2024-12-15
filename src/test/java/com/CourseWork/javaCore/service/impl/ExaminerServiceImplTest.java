package com.CourseWork.javaCore.service.impl;

import com.CourseWork.javaCore.exception.FullQuestionsException;
import com.CourseWork.javaCore.model.Question;
import com.CourseWork.javaCore.service.QuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    void getRandomQuestions() {
        //ожидается
        int amount = 3;
        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            questions.add(new Question("question"+i, "answer"+i));
        }
        Mockito.when(questionService.getAll()).thenReturn(questions);

        Mockito.when(questionService.getRandomQuestion()).thenReturn(
                questions.get(0), questions.get(0),
                questions.get(1), questions.get(1),
                questions.get(1), questions.get(2)
        );

        //реализация
        Collection<Question> randomQuestions = examinerService.getQuestions(amount);
        //проверка
        Assertions.assertEquals(randomQuestions.size(), amount);
        Assertions.assertTrue(randomQuestions.containsAll(questions));
        verify(questionService, times(6)).getRandomQuestion();
    }

    @Test
    void trowIsNotAmountQuestions() {
        //ожидается
        int amount = 3;
        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < amount / 2; i++) {
            questions.add(new Question("question"+i, "answer"+i));
        }
        Mockito.when(questionService.getAll()).thenReturn(questions);

        //реализация
        //проверка
        Assertions.assertThrows(FullQuestionsException.class, () -> examinerService.getQuestions(amount));
    }
}