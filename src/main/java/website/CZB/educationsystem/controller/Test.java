package website.CZB.educationsystem.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class Test {

    @RequestMapping("/register")
    public String addAdmin(){
        return "asdasdasd";
    }
}
