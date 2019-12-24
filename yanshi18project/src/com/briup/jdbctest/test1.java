package com.briup.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * jdbc的使用
 * @author CuiGX
 *
 */
public class test1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1、注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2、建立连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/yanshi?characterEncoding=utf8&serverTimezone=UTC", "root", "root");
		System.out.println(conn);  //如果能够打印出地址值，证明连接成功
		//3、使用Statement对象
		Statement st = conn.createStatement();
		//4、执行sql语句
		//查询语句
//		String sql = "select * from ysbook";
//		
//		//5、处理结果集  ResultSet
//		ResultSet rs = st.executeQuery(sql);
//		while (rs.next()) {
//			System.out.println(rs.getInt(1));
//			System.out.println(rs.getString(2));
//			System.out.println(rs.getString(3));
//			System.out.println(rs.getString(4));
//			System.out.println("-------------");
//		}
		//新增语句
		String sql = "insert into ysbook values(5,'水浒传','施耐庵','宋朝出版社')";
		st.execute(sql);
		
		//6、关闭资源
		//rs.close();
		st.close();
		conn.close();
		
	}
}
