package cn.tedu.mapper;

import cn.tedu.domain.ClassAndGrade;
import cn.tedu.domain.Student;
import cn.tedu.domain.User;

import java.util.Map;

public interface PersonalCenterMapper {
    public Student personalInformation(Map map);

    public void updateContactWay(Map map);

    public ClassAndGrade classInformation(Map map);

    public void submitSuggest(Map map);

    public User checkAccount(Map map);

    public void updatePassword(Map map);
}
