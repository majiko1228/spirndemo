package cn.ndky.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Attendance {

    @GetMapping("/attendance/index")
    public String attendance(){
        return "attendance/index";
    }
}
