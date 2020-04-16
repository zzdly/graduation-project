package cn.tedu.service;

import cn.tedu.api.ApiResponse;
import cn.tedu.domain.ClassAndGrade;
import cn.tedu.domain.Student;
import cn.tedu.mapper.PersonalCenterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PersonalCenterServer {

    @Autowired
    private PersonalCenterMapper personalCenterMapper;

    public ApiResponse personalInformation(Map map) {
        Student student=personalCenterMapper.personalInformation(map);
        return ApiResponse.buildSuccessResponse(student);
    }

    public ApiResponse updateContactWay(Map map) {
        personalCenterMapper.updateContactWay(map);
        return ApiResponse.buildSuccessMessage("修改成功");
    }

    public ApiResponse classInformation(Map map) {
        ClassAndGrade classAndGrade=personalCenterMapper.classInformation(map);
        System.out.println("班级信息："+classAndGrade.toString());
        return ApiResponse.buildSuccessResponse(classAndGrade);
    }
}
