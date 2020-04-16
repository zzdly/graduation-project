package cn.tedu.mapper;

import cn.tedu.api.ApiResponse;
import cn.tedu.domain.User;

import java.util.Map;

public interface LoginMapper {
    public User login(Map map);
}
