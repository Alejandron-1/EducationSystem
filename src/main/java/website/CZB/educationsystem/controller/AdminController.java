package website.CZB.educationsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import website.CZB.educationsystem.entities.Admin;
import website.CZB.educationsystem.service.AdminService;
import website.CZB.educationsystem.utils.Result;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private AdminService adminService;
    private Result result = new Result();

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;

    }

    @RequestMapping("/register")
    public Result addAdmin(@RequestBody Admin admin){
        System.out.println("register....");
        System.out.println(admin);
        if(adminService.getByAdminPhone(admin.getAdminPhone()) != null){ // 已存在
            result.setInfo("该管理员以存在",null);
        }else{
            adminService.register(admin);
            result.setSuccess("注册成功",null);
        }
        return result;
    }

    @RequestMapping("/login")
    public Result login(@RequestBody Admin admin, HttpServletRequest request){
        // , HttpServletRequest request
        System.out.println("Admin login");
        System.out.println(admin);
        Admin admin1 = adminService.getByAdminPhone(admin.getAdminPhone());
        if(admin1 != null){ //  存在该用户
            if(admin1.getPassword().equals(admin.getPassword())){
                //密码正确
                request.getSession().setAttribute("admin",admin);
                result.setSuccess("登录成功",admin);
                System.out.println("登录成功");
            }else{
                result.setInfo("用户名或密码错误",null);
            }
        }else {
            result.setInfo("不存在该用户",null);
        }
        return result;
    }

    @RequestMapping("/forgetPassword")
    public Result forgetPassword(@RequestBody Admin admin){
        Admin admin1 = adminService.getByAdminPhone(admin.getAdminPhone());
        if(admin1 != null){ //  存在该用户
            adminService.update(admin);
            result.setSuccess("修改密码成功",null);
        }else {
            result.setInfo("不存在该用户",null);
        }
        return result;
    }

    @RequestMapping("/changeName")
    public Result changeName(@RequestBody Admin admin){
        if(admin.getAdminName()!=null && !admin.getAdminName().equals("")){ //
            if(adminService.getByAdminPhone(admin.getAdminPhone()) == null){
                //不存在
                result.setInfo("该账号不存在",null);
            }else {
                adminService.changeName(admin);
                result.setSuccess("更名成功",null);
            }
        }else{
            result.setInfo("非法名称",null);
        }
        return result;
    }
}
