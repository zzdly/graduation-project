package cn.tedu.service;

import cn.tedu.api.ApiResponse;
import cn.tedu.domain.User;
import cn.tedu.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Service
public class LoginServer {
    @Autowired
    private LoginMapper loginMapper;

    public ApiResponse login(Map map) {
        User loginUser =  loginMapper.login(map);
        System.out.println(loginUser.toString());
        //String acount = loginUser.getAcount();
        //Cookie cookie=new Cookie("acount",acount);
        //设置cookie有效路径
        //cookie.setPath("/");
        //设置cookie是否可以被前端获取
        //cookie.setHttpOnly(false);
        //设置cookie生命时长
        //cookie.setMaxAge(60*60*24*30);
        //4.发送cookie--发送至浏览器
        //response.addCookie(cookie);
        return ApiResponse.buildSuccessResponse(loginUser);
    }
}
