package com;

import com.yanchen.Check;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestIndex {
    @Test
    public void show(){
        System.out.println("show");
    }
    @Check(name = "zhangsan")
    public void calculate(){
        System.out.printf("cal");
    }

    @Test
    public void TestMysql() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://120.77.85.169:3306/test?autoReconnect=true&failOverReadOnly=false&serverTimezone=UTC","root","yanC..1990");
        Statement stm  = conn.createStatement();
        String sql = "select * from test";
        stm.execute(sql);

    }
}
