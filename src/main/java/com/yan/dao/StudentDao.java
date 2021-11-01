package com.yan.dao;

import com.yan.entity.Student;

import java.util.List;

public interface StudentDao {

    //查询Student表中所有的数据
    List<Student> selectStu();

    /**
     * 插入方法
     * @param stu   要插入的值
     * @return  返回数据库中修改的记录条数
     */
    int insertStu(Student stu);
}
