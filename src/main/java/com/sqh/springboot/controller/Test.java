package com.sqh.springboot.controller;

import com.sqh.springboot.bean.Student;
import com.sqh.springboot.service.StudentService;
import com.sqh.springboot.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public Student test(String no){
        System.out.println("----- "+studentService.queryByNo(no));
        return studentService.queryByNo(no);

    }
}
