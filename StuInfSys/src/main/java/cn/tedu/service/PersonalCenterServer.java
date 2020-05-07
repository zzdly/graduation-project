package cn.tedu.service;

import cn.tedu.api.ApiResponse;
import cn.tedu.domain.ClassAndGrade;
import cn.tedu.domain.Student;
import cn.tedu.domain.User;
import cn.tedu.mapper.PersonalCenterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PersonalCenterServer {

    @Autowired
    private PersonalCenterMapper personalCenterMapper;

    /**
     * 个人基本信息
     * @param map
     * @return
     */
    public ApiResponse personalInformation(Map map) {
        Student student=personalCenterMapper.personalInformation(map);
        return ApiResponse.buildSuccessResponse(student);
    }

    /**
     * 修改联系方式
     * @param map
     * @return
     */
    public ApiResponse updateContactWay(Map map) {
        personalCenterMapper.updateContactWay(map);
        return ApiResponse.buildSuccessMessage("修改成功");
    }

    /**
     * 班级xinxi
     * @param map
     * @return
     */
    public ApiResponse classInformation(Map map) {
        ClassAndGrade classAndGrade=personalCenterMapper.classInformation(map);
        System.out.println("班级信息："+classAndGrade.toString());
        return ApiResponse.buildSuccessResponse(classAndGrade);
    }

    /**
     * 提交班级建议
     * @param map
     * @return
     */
    public ApiResponse submitSuggest(Map map) {
        personalCenterMapper.submitSuggest(map);
        return ApiResponse.buildSuccessMessage("提交成功");
    }

    /**
     * 修改密码
     * @param map
     * @return
     */
    public ApiResponse updatePassword(Map map) {
        //查询账号密码是否正确
        User user =personalCenterMapper.checkAccount(map);
        if (user!=null){
            personalCenterMapper.updatePassword(map);
            return ApiResponse.buildSuccessMessage("密码修改成功");
        }else {
            return ApiResponse.buildErrorMessage("密码修改失败");
        }
    }
}
