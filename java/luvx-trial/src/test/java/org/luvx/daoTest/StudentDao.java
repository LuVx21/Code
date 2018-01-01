package org.luvx.daoTest;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.luvx.bean.Student;
import org.luvx.utils.MyBatisUtil;

public class StudentDao {

//    /**
//     * 增加学生
//     */
//    @Test
//    public void add1() throws Exception {
//        SqlSession sqlSession = null;
//        try {
//            sqlSession = MyBatisUtil.getSqlSession();
//            //事务开始(默认)
//            //读取StudentMapper.xml映射文件中的SQL语句
//            int i = sqlSession.insert("org.luvx.bean.Student.add1");
//            System.out.println("本次操作影响了" + i + "行");
//            //事务提交
//            sqlSession.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            //事务回滚
//            sqlSession.rollback();
//            throw e;
//        } finally {
//            MyBatisUtil.closeSqlSession();
//        }
//    }
//
//    /**
//     * 增加学生
//     */
//    @Test
//    public void add2() throws Exception {
//        SqlSession sqlSession = null;
//        Student student = new Student();
//        student.setId(1);
//        student.setName("Ren");
//        student.setSal(Double.valueOf(10000L));
//        try {
//            sqlSession = MyBatisUtil.getSqlSession();
//            //事务开始(默认)
//            //读取StudentMapper.xml映射文件中的SQL语句
//            sqlSession.insert(Student.class.getName() + ".add2", student);
//            //事务提交
//            sqlSession.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            //事务回滚
//            sqlSession.rollback();
//            throw e;
//        } finally {
//            MyBatisUtil.closeSqlSession();
//        }
//    }

}
