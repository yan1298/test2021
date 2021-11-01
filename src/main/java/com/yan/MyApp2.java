package com.yan;

import com.yan.entity.Student;
import com.yan.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MyApp2 {
    public static void main(String[] args) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        String sqlId = "com.yan.dao.StudentDao" + "." + "selectStu";
        List<Student> stuList = sqlSession.selectList(sqlId);

        for (Student stu : stuList) {
            System.out.println(stu);
        }

        sqlSession.close();
    }
}
