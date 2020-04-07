package com.sqh.springboot.service;

import com.sqh.springboot.bean.Student;
import com.sqh.springboot.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Override
    public int add(Student student) {
        return this.studentMapper.insert(student);
    }

    @Override
    public int update(Student student) {
        return this.studentMapper.update(student);
    }

    @Override
    public int deleteByNo(String sno) {
        return this.studentMapper.delete(sno);
    }

    @Override
    public Student queryByNo(String sno) {
        return this.studentMapper.query(sno);
    }
}
