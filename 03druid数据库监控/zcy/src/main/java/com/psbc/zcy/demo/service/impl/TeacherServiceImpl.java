package com.psbc.zcy.demo.service.impl;

import com.psbc.zcy.demo.dto.Teacher;
import com.psbc.zcy.demo.dao.TeacherDAO;
import com.psbc.zcy.demo.service.TeacherService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDAO teacherDao;

    //@Override检查是否正确的复写了父类中已有的方法
    //标记这是一个复写的方法
    @Override
    public Teacher addTeacher(Teacher teacher) {
        teacherDao.insert(teacher);
        return teacher;
    }

    @Override
    public List<Teacher> getAllTeacher(String q){
        List<Teacher> teachers;
            if (StringUtils.isEmpty(q)){
                teachers=teacherDao.queryAllTeacher();
            }else {
                teachers=teacherDao.queryAllTeacherByQ(q);
            }

        return teachers;
    }

    @Override
    public Teacher getTeacherBytId(Teacher teacher) {
        return teacherDao.queryTeacherBytId(teacher);
    }

    @Override
    public Teacher modifyTeacher(Teacher teacher) {
        teacherDao.updateTeacher(teacher);
        return teacher;
    }

    @Override
    public void removeTeacher(Teacher teacher) {
        teacherDao.deleteTeacher(teacher);
    }

    @Override
    public int removeTeacherById(int Id) {
        teacherDao.deleteTeacherById(Id);
        return Id;
    }

}
