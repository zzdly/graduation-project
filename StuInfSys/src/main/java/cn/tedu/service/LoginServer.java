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
        return ApiResponse.buildSuccessResponse(loginUser);
    }
}
