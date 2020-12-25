package com.psbc.zcy.demo.service;

import com.psbc.zcy.demo.dto.Teacher;

import java.util.List;

public interface TeacherService {
    /**
     * 新增教师信息
     *
     * @param teacher
     */
    Teacher addTeacher(Teacher teacher);

    /**
     * 获取所有教师信息
     *
     * @return
     */
    List<Teacher> getAllTeacher(String q);

    /**
     * 根据教师ID查询用户信息
     *
     * @param teacher
     * @return
     */
    Teacher getTeacherBytId(Teacher teacher);

    /**
     * 更新教师信息
     *
     * @param teacher
     */
    Teacher modifyTeacher(Teacher teacher);

    /**
     * 删除教师信息
     *
     * @param teacher
     */
    void removeTeacher(Teacher teacher);

    /**
     * 删除教师信息
     *
     * @param Id
     */
    int removeTeacherById(int Id);
}
