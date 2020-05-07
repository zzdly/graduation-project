package cn.tedu.service;

import cn.tedu.api.ApiResponse;
import cn.tedu.mapper.InformMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class InformServer {
    @Autowired
    private InformMapper informMapper;

    public ApiResponse classInform(Map map) {
        List<Map> classInformList=informMapper.classInform(map);
        return ApiResponse.buildSuccessResponse(classInformList);
    }

    public ApiResponse collegeInform(Map map) {
        List<Map> collegeInformList=informMapper.collegeInform(map);
        return ApiResponse.buildSuccessResponse(collegeInformList);
    }

    public ApiResponse examInform(Map map) {
        List<Map> examInformList=informMapper.examInform(map);
        return ApiResponse.buildSuccessResponse(examInformList);
    }
}
