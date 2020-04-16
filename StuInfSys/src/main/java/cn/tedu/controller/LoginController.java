package cn.tedu.controller;

import cn.tedu.api.ApiResponse;
import cn.tedu.domain.User;
import cn.tedu.service.LoginServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/system")
public class LoginController {
    @Autowired
    private LoginServer loginServer;

    @PostMapping("/student/login")
    public ApiResponse userLogin(@RequestBody Map map){
        //System.out.println(map.toString());
        return loginServer.login(map);
    }
    
}
