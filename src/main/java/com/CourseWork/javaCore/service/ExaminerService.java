package com.CourseWork.javaCore.service;

import com.CourseWork.javaCore.model.Question;

import java.util.Collection;


public interface ExaminerService {
    Collection<Question> getQuestions(int amount);

}
