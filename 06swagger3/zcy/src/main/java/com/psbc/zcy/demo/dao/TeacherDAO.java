package com.psbc.zcy.demo.dao;

import com.psbc.zcy.demo.dto.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

//@mapper后，不需要在spring配置中设置扫描地址，通过mapper.xml里面的namespace属性对
//应相关的mapper类，spring将动态的生成Bean后注入到ServiceImpl中
//@repository则需要在Spring中配置扫描包地址，然后生成dao层的bean，之后被注入到ServiceImpl中
@Mapper
@Repository
public interface TeacherDAO {
    /**
     * 新增教师信息
     *
     * @param teacher
     */
    void insert(Teacher teacher);


    /**
     * 获取所有教师信息
     *
     * @return
     */
    List<Teacher> queryAllTeacher();


    /**
     * 关键字获取所有教师信息
     *
     * @return
     */
    List<Teacher> queryAllTeacherByQ(String q);


    /**
     * 根据教师ID查询教师信息
     *
     * @param teacher
     * @return
     */
    Teacher queryTeacherBytId(Teacher teacher);

    /**
     * 更新教师信息
     *
     * @param teacher
     */
    void updateTeacher(Teacher teacher);

    /**
     * 删除教师信息
     *
     * @param teacher
     */
    void deleteTeacher(Teacher teacher);

    /**
     * 通过tId删除教师信息
     *
     * @param Id
     */
    void deleteTeacherById(int Id);
}
