package com.lanqiao.converter;

import com.lanqiao.entity.Student;
import org.springframework.core.convert.converter.Converter;

/**
 * @Auther: zhaomengyi
 * @Date: 2019/8/28 17:20
 * @Description:
 */
public class MyConverter implements Converter<String, Student> {

    public Student convert(String s) {
        Student student = new Student();
        String[] strStu = s.split("-");
        student.setId(Integer.parseInt(strStu[0]));
        student.setName(strStu[1]);
        student.setAge(Integer.parseInt(strStu[2]));
        return student;
    }
}
