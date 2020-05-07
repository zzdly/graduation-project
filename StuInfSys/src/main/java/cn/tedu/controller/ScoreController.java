package cn.tedu.controller;

import cn.tedu.api.ApiResponse;
import cn.tedu.service.ScoreServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/system")
public class ScoreController {
    @Autowired
    private ScoreServer scoreServer;

    @PostMapping("/student/scoreQuery")
    public ApiResponse queryScore(@RequestBody Map map){
        return scoreServer.queryScore(map);
    }
}
