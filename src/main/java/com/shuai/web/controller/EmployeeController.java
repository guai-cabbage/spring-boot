package com.shuai.web.controller;

import com.shuai.web.dao.DepartmentDao;
import com.shuai.web.dao.EmployeeDao;
import com.shuai.web.entities.Department;
import com.shuai.web.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 *  @Description： 员工信息管理
 *  @Author: guai
 *  @Date：2020/5/29 16:30
**/
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees=employeeDao.getAll();
        //放在请求域中共享
        model.addAttribute("emps",employees);
        //thymeleaf默认拼串
        return "emp/list";
    }
    //查询部门名，转到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //查出所有部门
        Collection<Department> departments=departmentDao.getDepartments();
        model.addAttribute("depts",departments);
//        来到添加页面
        return "emp/add";
    }
    //添加用户
    //springMVC自动请求参数和入参对象的属性进行一一绑定；要求了请求参数的名字和javaBean入参的对象里面的属性名是一样的
    //
    @PostMapping("/emp")
    public String addEmp(Employee employee) throws Exception {
        //来到员工列表页面
        //redirect:表示重定向到一个地址
        //forward：表示转发到一个地址
        System.out.println("保存的员工信息"+employee);
        //测试
        if(employee.getEmail().length()>5){
            throw new RuntimeException("email error");
        }
        //保存员工信息
        employeeDao.save(employee);

        return "redirect:/emps";
    }
    //来到修改页面，查出员工，在页面回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Employee employee= employeeDao.get(id);
        model.addAttribute("emp",employee);
        model.addAttribute("depts",departmentDao.getDepartments());
        //回到修改页面（add是一个修改添加二和一的界面
        return "emp/add";
    }
    //员工修改
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        System.out.println("修改的员工对象");
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    //员工删除
    @PostMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
