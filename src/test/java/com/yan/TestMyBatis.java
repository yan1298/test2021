package com.yan;

import com.yan.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestMyBatis {
    @Test
    public void testInsert() throws IOException {
        String config = "mybatis.xml";

        InputStream in = Resources.getResourceAsStream(config);

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        SqlSessionFactory factory = builder.build(in);

        SqlSession sqlSession = factory.openSession();

        String sqlId = "com.yan.dao.StudentDao.insertStu";
        Student student = new Student(1001, "张飞", "zhangfei@qq.com", 35);

        //标识执行sql插入student中的数据
        int result = sqlSession.insert(sqlId, student);

        //注意：这里添加后，MyBatis默认是没有提交事务的，需要我们手动提交
        if (result == 1) {
            //提交事务
            sqlSession.commit();
            System.out.println("插入成功！");
        } else {
            System.out.println("插入失败！");
        }

        sqlSession.close();
    }
}
