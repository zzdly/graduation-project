package cn.tedu.controller;

import cn.tedu.api.ApiResponse;
import cn.tedu.service.PersonalCenterServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/system")
public class PersonalCenterController {

    @Autowired
    private PersonalCenterServer personalCenterServer;

    /***
     * 基本信息
     * @param map
     * @return
     */
    @PostMapping("/student/personalInformation")
    public ApiResponse persoanlInformation(@RequestBody Map map){
        return personalCenterServer.personalInformation(map);
    }

    /***
     * 更新联系方式
     * @param map
     * @return
     */
    @PostMapping("/student/updateContactWay")
    public ApiResponse updateContactWay(@RequestBody Map map){
        return personalCenterServer.updateContactWay(map);
    }

    /**
     * 班级信息
     * @param map
     * @return
     */
    @PostMapping("/student/classInformation")
    public ApiResponse classInformation(@RequestBody Map map){
        return personalCenterServer.classInformation(map);
    }

    /**
     * 提交班级建议
     * @param map
     * @return
     */
    @PostMapping("/student/submitSuggest")
    protected ApiResponse submitSuggest(@RequestBody Map map){
        return personalCenterServer.submitSuggest(map);
    }

    /**
     * 修改密码
     * @param map
     * @return
     */
    @PostMapping("/student/updatePassword")
    public ApiResponse updatePassword(@RequestBody Map map){
        return personalCenterServer.updatePassword(map);
    }
}
