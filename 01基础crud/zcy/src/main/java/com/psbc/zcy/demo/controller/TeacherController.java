package com.psbc.zcy.demo.controller;

import com.psbc.zcy.demo.service.TeacherService;
import com.psbc.zcy.demo.dto.Teacher;
import com.psbc.zcy.demo.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;
// @RestController = @Controller + @ResponseBody
@RestController("/Validate")
public class TeacherController {
    @Autowired //@Autowired是一种注解，可以对成员变量、方法和构造函数进行标注，来完成自动装配的工作
    private TeacherService teacherService;

    // 新增教师信息
    @CrossOrigin // 解决跨域问题
    @PostMapping("/api/teacher/add")
    public Result add(@Valid @RequestBody Teacher teacher, BindingResult res) {
        if(res.hasErrors()) {
            for (ObjectError error : res.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
                return new Result<>(-1,error.getDefaultMessage());
            }
        }
        return new Result<>(teacherService.addTeacher(teacher));
    }

    //查询教师信息
    @CrossOrigin
    @PostMapping("/api/teacher/list")
    public Result list(@RequestParam String q) throws Exception {
        // 1.获得所有教师记录
        try {
            List<Teacher> allTeacher = teacherService.getAllTeacher(q);
            return new Result(allTeacher);
        } catch (Exception e) {
            return  new Result(e);
        }
    }

    //通过教师编号查询教师信息
    @CrossOrigin
    @PostMapping("/api/teacher/query_teacher_by_t_id")
    public Teacher queryTeacherBytId(@RequestBody Teacher teacher) {
        return teacherService.getTeacherBytId(teacher);
    }

    //修改教师信息
    @CrossOrigin
    @PostMapping("/api/teacher/update_teacher_by_teacher_tid")
    public Result updateTeacherBytId(@RequestBody Teacher teacher){
        System.out.println(teacher);
        return new Result<>(teacherService.modifyTeacher(teacher));
    }

    //通过教师编号tid删除教师信息
    @CrossOrigin
    @PostMapping("/api/teacher/delete_teacher_by_teacher_id")
    public void deleteTeacherBytId(@RequestBody Teacher teacher) {
        teacherService.removeTeacher(teacher);
    }

    //通过编号id删除教师信息
    @CrossOrigin
    @DeleteMapping("/api/teacher/delete_teacher_by_id")
    public Result deleteById(@RequestParam int  id) {
        return new Result<>(teacherService.removeTeacherById(id));
    }

}
