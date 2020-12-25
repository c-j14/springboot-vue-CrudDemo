package com.psbc.zcy.demo.controller;

import com.alibaba.druid.stat.DruidStatManagerFacade;
import com.psbc.zcy.demo.service.TeacherService;
import com.psbc.zcy.demo.dto.Teacher;
import com.psbc.zcy.demo.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;

@Api(tags = "教师信息管理")
@RestController("/Validate") // @RestController = @Controller + @ResponseBody
public class TeacherController {
    @Autowired //@Autowired是一种注解，可以对成员变量、方法和构造函数进行标注，来完成自动装配的工作
    private TeacherService teacherService;

    //获取 Druid 的监控数据
    @GetMapping("/api/druid-stat")
    @ApiOperation(value = "获取 Druid 的监控数据")
    public Object druidStat(){
        // DruidStatManagerFacade#getDataSourceStatDataList 该方法可以获取所有数据源的监控数据
        // 除此之外 DruidStatManagerFacade 还提供了一些其他方法，我们可以按需选择使用。
        return DruidStatManagerFacade.getInstance().getDataSourceStatDataList();
    }

    // 新增教师信息
    @CrossOrigin // 解决跨域问题
    @PostMapping("/api/teacher/add")
    @ApiOperation(value = "新增一条教师信息",notes = "根据Teacher对象创建用户")
    @ApiImplicitParam(paramType = "body", dataType = "Teacher", name = "teacher", value = "教师对象", required = true)
    public Result add(@RequestBody Teacher teacher) {
        return new Result<>(teacherService.addTeacher(teacher));
    }

    //查询教师信息
    @CrossOrigin
    @PostMapping("/api/teacher/list")
    @ApiOperation(value = "获取教师信息列表",notes = "根据url的q来查询教师信息")
    @ApiImplicitParam(paramType = "query", dataType = "String", name = "q", value = "查询值", required = true, example = "钟昌余")
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
    @ApiOperation(value = "获取教师信息",notes = "根据Teacher对象的tid来查询教师信息")
    public Teacher queryTeacherBytId(@RequestBody Teacher teacher) {
        return teacherService.getTeacherBytId(teacher);
    }

    //修改教师信息
    @CrossOrigin
    @PostMapping("/api/teacher/update_teacher_by_teacher_tid")
    @ApiOperation(value = "修改教师信息",notes = "根据Teacher对象的id来修改教师信息")
    public Result updateTeacherBytId(@Valid @RequestBody Teacher teacher, BindingResult res) {
        System.out.println(teacher);
        if(res.hasErrors()) {
            for (ObjectError error : res.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
                return new Result<>(-1, error.getDefaultMessage());
            }
        }
        return new Result<>(teacherService.modifyTeacher(teacher));
    }

    //通过教师编号tid删除教师信息
    @CrossOrigin
    @PostMapping("/api/teacher/delete_teacher_by_teacher_id")
    @ApiOperation(value = "删除教师信息",notes = "根据Teacher对象的的tid来删除教师信息")
    public void deleteTeacherBytId(@RequestBody Teacher teacher) {
        teacherService.removeTeacher(teacher);
    }

    //通过编号id删除教师信息
    @CrossOrigin
    @DeleteMapping("/api/teacher/delete_teacher_by_id")
    @ApiOperation(value = "删除教师信息",notes = "根据url的id来删除教师信息")
    public Result deleteById(@RequestParam int  id) {
        return new Result<>(teacherService.removeTeacherById(id));
    }

}
