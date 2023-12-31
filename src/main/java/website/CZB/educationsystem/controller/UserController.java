package website.CZB.educationsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import website.CZB.educationsystem.entities.Device;
import website.CZB.educationsystem.entities.User;
import website.CZB.educationsystem.service.UserService;
import website.CZB.educationsystem.utils.Result;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    private Result result = new Result();
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/userregister")
    public Result userRegister(@RequestBody User user){

        System.out.println("userregister");
        System.out.println(user);
        if(userService.getByUserPhone(user.getUserPhone()) != null){ // 已存在
            result.setInfo("该用户以存在",null);
        }else {
            userService.register(user);
            result.setSuccess("用户注册成功",user);
        }
        return result;
    }
    
    @RequestMapping("/userlogin")
    public Result userLogin(@RequestBody User user, HttpServletRequest request){

        System.out.println("userlogin");
        System.out.println(user);
        System.out.println("------------------------");
        System.out.println(userService.getByUserPhone(user.getUserPhone()));
        User user1=userService.getByUserPhone(user.getUserPhone());
        System.out.println(user1);
        if(user1!=null){//存在该账户
            if(user1.getPassword().equals(user.getPassword())){//密码正确
                request.getSession().setAttribute("User",user);
                result.setSuccess("登录成功！",user1);
            }else{//密码错误
                result.setInfo("用户名或密码错误！",null);
            }
        }else{//不存在该账户
            result.setInfo("该账号不存在！",null);
        }
        return result;
    }

    @RequestMapping("/userforgetPassword")
    public Result userForgetPassword(@RequestBody User user){
        User user1=userService.getByUserPhone(user.getUserPhone());
        System.out.println(user1);
        if(user1!=null){//id重复！
            userService.update(user);
            result.setSuccess("修改密码成功！",user1);
        }else{
            result.setInfo("该账号不存在！",null);
        }
        return result;
    }
    
    @RequestMapping("/userchangeName")
    public Result userChangeName(@RequestBody User user){
        System.out.println(user);
        if(user.getUserName()!=null&&!user.getUserName().equals("")){
            if(userService.getByUserPhone(user.getUserPhone())==null){
                result.setInfo("该账号不存在！无法改名",null);
            }else{
                userService.changeName(user);
                System.out.println(user);
                user = userService.getByUserPhone(user.getUserPhone());
                result.setSuccess("改名成功！",user);
            }
        }else{
            result.setInfo("非法名称",null);
        }
        return result;
    }

    @RequestMapping("/usermyDeviceList")
    public Result myDeviceList(@RequestBody User user){
        if(userService.getByUserPhone(user.getUserPhone())==null){
            result.setInfo("该账号不存在！",null);
        }else{
            List<Device> deviceList= userService.myDeviceList(user.getUserPhone());
            System.out.println(userService.getByUserPhone(user.getUserPhone()));
            result.setSuccess("查询成功！",deviceList);
        }
        return result;
    }


}
