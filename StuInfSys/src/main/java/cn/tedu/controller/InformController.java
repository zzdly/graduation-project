package cn.tedu.controller;

import cn.tedu.api.ApiResponse;
import cn.tedu.service.InformServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/system")
public class InformController {
    @Autowired
    private InformServer informServer;

    @PostMapping("/student/classInform")
    public ApiResponse classInform(@RequestBody Map map){
        return informServer.classInform(map);
    }

    @PostMapping("/student/collegeInform")
    public ApiResponse collegeInform(@RequestBody Map map){
        return informServer.collegeInform(map);
    }

    @PostMapping("/student/examInform")
    public ApiResponse examInform(@RequestBody Map map){
        return informServer.examInform(map);
    }
}
