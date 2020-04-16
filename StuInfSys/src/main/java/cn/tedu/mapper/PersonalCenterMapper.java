package cn.tedu.mapper;

import cn.tedu.api.ApiResponse;
import cn.tedu.domain.ClassAndGrade;
import cn.tedu.domain.Student;

import java.util.Map;

public interface PersonalCenterMapper {
    public Student personalInformation(Map map);

    public void updateContactWay(Map map);

    public ClassAndGrade classInformation(Map map);

    public void submitSuggest(Map map);
}
