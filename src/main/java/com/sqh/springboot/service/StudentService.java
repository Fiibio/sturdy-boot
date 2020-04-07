package com.sqh.springboot.service;

import com.sqh.springboot.bean.Student;
import org.springframework.stereotype.Component;

@Component
public interface StudentService {
    int add(Student student);
    int update(Student student);
    int deleteByNo(String sno);
    Student queryByNo(String sno);
}
