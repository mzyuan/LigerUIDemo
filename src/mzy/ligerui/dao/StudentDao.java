package mzy.ligerui.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import mzy.ligerui.model.*;
import mzy.ligerui.util.*;

public class StudentDao {

	//获取数据
	public ResultSet studentList(Connection con,PagingModel pageBean,StudentModel student)throws Exception{
		StringBuffer sb=new StringBuffer("select * from student");
		if(student!=null && StringUtil.isNotEmpty(student.getStuName())){
			sb.append(" and stuname like '%"+student.getStuName()+"%'");
		}
		if(pageBean!=null){
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getRows());
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	//获取数据条数
	public int studentCount(Connection con,StudentModel student)throws Exception{
		StringBuffer sb=new StringBuffer("select count(*) as total from student");
		if(StringUtil.isNotEmpty(student.getStuName())){
			sb.append(" and stuname like '%"+student.getStuName()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt("total");
		}else{
			return 0;
		}
	}
	
}
