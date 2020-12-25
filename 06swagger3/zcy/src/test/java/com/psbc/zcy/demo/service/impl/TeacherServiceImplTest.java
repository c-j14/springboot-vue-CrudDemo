package com.psbc.zcy.demo.service.impl;

import com.psbc.zcy.demo.dto.Teacher;
import com.psbc.zcy.demo.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TeacherServiceImplTest {
    @Autowired
    private TeacherService teacherService;

    @Test
    public void addTeacher() {
        Teacher teacher = new Teacher();
        teacher.setTId("32");
        teacher.setTName("张无忌");
        teacher.setTAge(30);
        teacher.setTAddress("四川成都");
        teacher.setTSex("女");
        teacher.setTSubject("英语");
        teacherService.addTeacher(teacher);
    }

    @Test
    public void getAllTeacher() {
        List<Teacher> teacherList = teacherService.getAllTeacher("");
        log.info("查询所有用户信息结果：{}", teacherList);
    }

    @Test
    public void getTeacherByTeacherId() {
        Teacher teacher1 = new Teacher();
        teacher1.setTId("32");
        Teacher teacher = teacherService.getTeacherBytId(teacher1);
        log.info("查询单个用户信息结果:{}", teacher);
    }

    @Test
    public void modifyTeacher() {
        Teacher teacher = new Teacher();
        teacher.setId(43);
        teacher.setTId("32");
        teacher.setTName("张无忌2");
        teacher.setTAge(30);
        teacher.setTAddress("四川成都");
        teacher.setTSex("女");
        teacher.setTSubject("英语");
        teacherService.modifyTeacher(teacher);
    }

    @Test
    public void removeTeacher() {
        Teacher teacher1 = new Teacher();
        teacher1.setTId("32");
        teacherService.removeTeacher(teacher1);
    }
}
