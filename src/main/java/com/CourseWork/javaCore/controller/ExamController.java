package com.CourseWork.javaCore.controller;

import com.CourseWork.javaCore.model.Question;
import com.CourseWork.javaCore.service.ExaminerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService1) {
        this.examinerService = examinerService1;
    }

    @GetMapping ("/exam/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {
        return  examinerService.getQuestions(amount);
    }
}
