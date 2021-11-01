package com.yan;

import com.yan.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyApp {
    public static void main(String[] args) throws Exception {
        //访问MyBatis，读取student表中的数据
        //1.定义MyBatis主配置文件的名称,从类路径的根开始
        String config = "mybatis.xml";

        //2.读取这个config文件
        InputStream in = Resources.getResourceAsStream(config);

        //3.创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        //4.创建SqlSessionFactory对象
        SqlSessionFactory factory = builder.build(in);

        //5.[重要步骤]从SqlSessionFactory对象中获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //6.[重要步骤]指定要执行的sql语句的标识。
        // sql映射文件中mapper标签的namespace属性值 + "." + 执行数据库操作语句标签的id值
        String sqlId = "com.yan.dao.StudentDao" + "." + "selectStu";

        //7.执行sql语句，通过sqlID找到语句
        List<Student> stuList = sqlSession.selectList(sqlId);

        //8.输出结果
//        stuList.forEach(stu -> System.out.println(stu));
        for (Student stu : stuList) {
            System.out.println(stu);
        }

        //9.关闭连接
        sqlSession.close();
    }
}
