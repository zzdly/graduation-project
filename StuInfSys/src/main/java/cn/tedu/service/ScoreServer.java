package cn.tedu.service;

import cn.tedu.api.ApiResponse;
import cn.tedu.mapper.ScoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.Map;

@Service
public class ScoreServer {
    @Autowired
    private ScoreMapper scoreMapper;

    public ApiResponse queryScore(Map map) {
        Map params= (Map) map.get("params");
        List<Map> scoreList=scoreMapper.queryScore(params);
        return ApiResponse.buildSuccessResponse(scoreList);
    }

}
