package com.yicen.myBatisUtils;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {
    private static SqlSession sqlSession;
    static {
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-confirguration.xml");
            sqlSession =  new SqlSessionFactoryBuilder().build(is).openSession();

        } catch (IOException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }
    public static SqlSession  getSqlSession(){
        return sqlSession;
    }

    public static void closeSession(SqlSession session){
        if (null != session){
            session.close();
        }
    }

}
