package mzy.ligerui.web;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import sun.rmi.runtime.Log;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import mzy.ligerui.model.StudentModel;
import mzy.ligerui.model.PagingModel;
import mzy.ligerui.util.DbUtil;
import mzy.ligerui.util.JsonUtil;
import mzy.ligerui.util.ResponseUtil;
import mzy.ligerui.dao.StudentDao;

public class StudentListServlet extends HttpServlet {

	public Logger log = Logger.getLogger(StudentListServlet.class);
	
	DbUtil dbUtil = new DbUtil();
	StudentDao studentDao = new StudentDao();

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String stuName = request.getParameter("stuName");
		String searchWhere = request.getParameter("where");
		log.debug(searchWhere);
 		StudentModel student = new StudentModel();
		if (stuName != null) {
			student.setStuName(stuName);
		}

		String page = request.getParameter("page");
		String rows = request.getParameter("pagesize");

		PagingModel pagingModel = new PagingModel(Integer.parseInt(page),
				Integer.parseInt(rows));

		Connection con = null;
		try {
			con = dbUtil.getCon();
			JSONObject result = new JSONObject();
			JSONArray jsonArray = JsonUtil.formatRsToJsonArray(studentDao
					.studentList(con, pagingModel, student));
			int total = studentDao.studentCount(con, student);
			result.put("Rows", jsonArray);
			result.put("Total", total);
			log.debug(result);
			ResponseUtil.write(response, result);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
