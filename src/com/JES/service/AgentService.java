package com.JES.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.JES.dao.AccountDAO;
import com.JES.dao.AgentDAO;
import com.JES.dao.AgentNoteDAO;
import com.JES.dao.AgentupstudentDAO;
import com.JES.dao.CourseDAO;
import com.JES.dao.ReportDAO;
import com.JES.dao.SelectionDAO;
import com.JES.dao.StudentDAO;
import com.JES.model.Agent;
import com.JES.model.AgentNote;
import com.JES.model.Agentupstudent;
import com.JES.model.Course;
import com.JES.model.Manager;
import com.JES.model.Report;
import com.JES.model.Selection;
import com.JES.model.Student;

public class AgentService {
	private AgentDAO agentDAO;
	private AgentupstudentDAO agentupstudentDAO;
	private StudentDAO studentDAO;
	private AgentNoteDAO agentnoteDAO;
	private AccountDAO accountDAO;
	private CourseDAO courseDAO;
	private SelectionDAO selectionDAO;
	private ReportDAO reportDAO;
	
	
	public ReportDAO getReportDAO() {
		return reportDAO;
	}

	public void setReportDAO(ReportDAO reportDAO) {
		this.reportDAO = reportDAO;
	}

	public SelectionDAO getSelectionDAO() {
		return selectionDAO;
	}

	public void setSelectionDAO(SelectionDAO selectionDAO) {
		this.selectionDAO = selectionDAO;
	}

	public CourseDAO getCourseDAO() {
		return courseDAO;
	}

	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	public AgentNoteDAO getAgentnoteDAO() {
		return agentnoteDAO;
	}

	public void setAgentnoteDAO(AgentNoteDAO agentnoteDAO) {
		this.agentnoteDAO = agentnoteDAO;
	}

	public AgentDAO getAgentDAO() {
		return agentDAO;
	}

	public void setAgentDAO(AgentDAO agentDAO) {
		this.agentDAO = agentDAO;
	}

	public AgentupstudentDAO getAgentupstudentDAO() {
		return agentupstudentDAO;
	}

	public void setAgentupstudentDAO(AgentupstudentDAO agentupstudentDAO) {
		this.agentupstudentDAO = agentupstudentDAO;
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public AccountDAO getAccountDAO() {
		return accountDAO;
	}

	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	@SuppressWarnings("unchecked")
	public List<Student> searchStudents(String type, String value) {
		if(value.equals("")||value==null) 
			return (List<Student>) studentDAO.findAll();
		List<Student> slist = new ArrayList<Student>();
		switch (type) {
		case "学员UID":
			Student student = studentDAO.findById(value);
			if (student != null)
				slist.add(student);
			return slist;
		case "真实姓名":
			return (List<Student>) studentDAO.findByName(value);
		case "手机号":
			return (List<Student>) studentDAO.findByPhone(value);
		case "QQ":
			return (List<Student>) studentDAO.findByQq(value);
		case "学号":
			return (List<Student>) studentDAO.findByStuid(value);
		}
		return null;
	}
	
	/*public List<Student> showAllStudents(){
		return (List<Student>) studentDAO.findAll();
	}
*/
	public boolean addStudent(Student student) {
		Student stu = studentDAO.findById(student.getUid());
		if (stu == null) {
			studentDAO.save(student);
			return true;
		} else
			return false;
	}

	public boolean upPhoto(FileInputStream input,Integer length,
			Agentupstudent upstudent,Student student){
		byte[] bFile = new byte[length];
		try {
			input.read(bFile);
			input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date intime = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String sDate = sdf.format(intime);
		student.setIntime(sDate);
		student.setMark(1);   //设置转化指数
		student.setMid("001"); //设置代理商ID
		student.setMsign("001");
		student.setSfrom("");
		student.setSign("非正式学员");
		upstudent.setPhoto(bFile);
		agentupstudentDAO.save(upstudent);
		studentDAO.save(student);
		return true;
	}

	public boolean agentNote(String note) {
		AgentNote agentnote = new AgentNote();
		Date nDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sDate = sdf.format(nDate);
		String noteid = UUID.randomUUID().toString();
		agentnote.setNote(note);
		agentnote.setNotetime(sDate);
		agentnote.setAgentid("代理商");// getSession
		agentnote.setNoteid(noteid);
		agentnoteDAO.save(agentnote);
		return true;
	}

	public void shoeView(String qq) {
		HttpServletResponse response = null;
		ServletOutputStream out = null;
		Agentupstudent agentupstudent = new Agentupstudent();
		try {
			response = ServletActionContext.getResponse();
			response.setContentType("multipart/form-data");
			out = response.getOutputStream();
			agentupstudent = agentupstudentDAO.findById(qq);
			out.write(agentupstudent.getPhoto()); // 换成你自己的图片byte[] 数据就行.
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public boolean isLoginSuccess(Agent agent) {
		List resultList = agentDAO.findByAname(agent.getAname());

		if (resultList.size() != 0) {
			Agent result = (Agent) resultList.get(0);

			if (agent.getAname().equals(result.getAname())
					&& agent.getPassword().equals(result.getPassword())) {
				return true;
			}
		}

		return false;
	}

	public boolean isExistAgent(Agent agent) {
		List results = agentDAO.findByAname(agent.getAname());

		if (results.size() != 0) {

			Agent a = (Agent) results.get(0);
			if (agent.getUid().equals(a.getUid())) {
				return false;
			}

			return true;
		}

		return false;
	}
	
	public boolean cheakQq(String qq){
		List<Student> student =studentDAO.findByQq(qq);
		if(student.size()!=0)
			return true;
		else return false;
	}
	
	public List<Course> allcourse(){
		return (List<Course>)courseDAO.findAll();
	}
	
	public boolean billUp(String uid,String phone,String weixin,String sign,Integer bill,Integer mark,String class_){
		Student student=(Student)studentDAO.findById(uid);
		Selection selection=new Selection();
		Date nDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sDate = sdf.format(nDate);
		String id=UUID.randomUUID().toString();
		student.setPhone(phone);
		student.setMark(mark);
		student.setSign(sign);
		student.setWeixin(weixin);
		studentDAO.merge(student);
		selection.setUid(student.getUid());
		selection.setBill(bill);
		selection.setSelecttime(sDate);
		selection.setCname(class_);
		selection.setId(id);
		
		//报表
		
		selectionDAO.save(selection);
		return true;
	}
	
	
	public List<Report> MyCpReports(String type,String value,String mid){
		List<Report> reportList=new ArrayList<Report>();
		List<String> reportIdList=new ArrayList<String>();
		Integer len;
		if(value.equals("")||value==null) {
			reportIdList.addAll((List<String>)agentDAO.findReportIdByMannager(mid));
			len=reportIdList.size();
			for(int i=0;i<len;i++){
				reportList.add(reportDAO.findById(reportIdList.get(i).toString()));
			}
			return reportList;
		}
		else switch (type) {
		case "班主任姓名":
			reportIdList.addAll((List<String>)agentDAO.findReportIdByName(value, mid));
			len=reportIdList.size();
			for(int i=0;i<len;i++){
				reportList.add(reportDAO.findById(reportIdList.get(i).toString()));
			}
			return reportList;
		case "班主任QQ":
			reportIdList.addAll((List<String>)agentDAO.findReportIdByQq(value, mid));
			len=reportIdList.size();
			for(int i=0;i<len;i++){
				reportList.add(reportDAO.findById(reportIdList.get(i).toString()));
			}
			return reportList;
		case "班主任手机号":
			reportIdList.addAll((List<String>)agentDAO.findReportIdByPhone(value, mid));
			len=reportIdList.size();
			for(int i=0;i<len;i++){
				reportList.add(reportDAO.findById(reportIdList.get(i).toString()));
			}
			return reportList;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public String studentmsout() throws Exception {
		List<Student> studentList = new ArrayList<Student>();
		studentList = studentDAO.findAll();

		/*
		 * 设置表头：对Excel每列取名(必须根据你取的数据编写)
		 */
		String[] tableHeader = { "UID", "学号", "姓名", "手机号", "QQ", "微信", "来源",
				"状态", "录入时间", "学员转化指数" };
		/*
		 * 下面的都可以拷贝不用编写
		 */
		short cellNumber = (short) tableHeader.length;// 表的列数
		HSSFWorkbook workbook = new HSSFWorkbook(); // 创建一个excel
		HSSFCell cell = null; // Excel的列
		HSSFRow row = null; // Excel的行
		HSSFCellStyle style = workbook.createCellStyle(); // 设置表头的类型
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		HSSFCellStyle style1 = workbook.createCellStyle(); // 设置数据类型
		style1.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		HSSFFont font = workbook.createFont(); // 设置字体
		HSSFSheet sheet = workbook.createSheet("sheet1"); // 创建一个sheet
		HSSFHeader header = sheet.getHeader();// 设置sheet的头
		try {
			/**
			 * 根据是否取出数据，设置header信息
			 *
			 */
			if (studentList.size() < 1) {
				header.setCenter("无学员信息");
			} else {
				header.setCenter("我的学员信息");
				row = sheet.createRow(0);
				row.setHeight((short) 400);
				for (int k = 0; k < cellNumber; k++) {
					cell = row.createCell((short) k);// 创建第0行第k列
					cell.setCellValue(new HSSFRichTextString(tableHeader[k]));// 设置第0行第k列的值
					sheet.setColumnWidth((short) k, (short) 8000);// 设置列的宽度
					font.setColor(HSSFFont.COLOR_NORMAL); // 设置单元格字体的颜色.
					font.setFontHeight((short) 350); // 设置单元字体高度
					style1.setFont(font);// 设置字体风格
					cell.setCellStyle(style1);
				}
				/*
				 * // 给excel填充数据这里需要编写
				 */
				for (int i = 0; i < studentList.size(); i++) {
					Student student = (Student) studentList.get(i);// 获取student对象
					row = sheet.createRow((short) (i + 1));// 创建第i+1行
					row.setHeight((short) 400);// 设置行高

					if (student.getUid() != null) {
						cell = row.createCell((short) 0);// 创建第i+1行第0列
						cell.setCellValue(new HSSFRichTextString(student
								.getUid()));// 设置第i+1行第0列的值
						cell.setCellStyle(style);// 设置风格
					}
					if (student.getStuid() != null) {
						cell = row.createCell((short) 1); // 创建第i+1行第1列

						cell.setCellValue(new HSSFRichTextString(student
								.getStuid()));// 设置第i+1行第1列的值

						cell.setCellStyle(style); // 设置风格
					}
					// 由于下面的和上面的基本相同，就不加注释了
					if (student.getName() != null) {
						cell = row.createCell((short) 2);
						cell.setCellValue(new HSSFRichTextString(student
								.getName()));
						cell.setCellStyle(style);
					}
					if (student.getPhone() != null) {
						cell = row.createCell((short) 3);
						cell.setCellValue(new HSSFRichTextString(student
								.getPhone()));
						cell.setCellStyle(style);
					}
					if (student.getQq() != null) {
						cell = row.createCell((short) 4);
						cell.setCellValue(new HSSFRichTextString(student
								.getQq()));
						cell.setCellStyle(style);
					}
					if (student.getWeixin() != null) {
						cell = row.createCell((short) 5);
						cell.setCellValue(new HSSFRichTextString(student
								.getWeixin()));
						cell.setCellStyle(style);
					}
					if (student.getSfrom() != null) {
						cell = row.createCell((short) 6);
						cell.setCellValue(new HSSFRichTextString(student
								.getSfrom()));
						cell.setCellStyle(style);
					}
					if (student.getSign() != null) {
						cell = row.createCell((short) 7);
						cell.setCellValue(new HSSFRichTextString(student
								.getSign()));
						cell.setCellStyle(style);
					}
					if (student.getIntime() != null) {
						cell = row.createCell((short) 8);
						cell.setCellValue(new HSSFRichTextString(student
								.getIntime()));
						cell.setCellStyle(style);
					}
					if (student.getMark() != null) {
						cell = row.createCell((short) 9);
						cell.setCellValue(new HSSFRichTextString(student
								.getMark().toString()));
						cell.setCellStyle(style);
					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * 下面的可以不用编写，直接拷贝
		 */
		HttpServletResponse response = null;// 创建一个HttpServletResponse对象
		OutputStream out = null;// 创建一个输出流对象
		try {
			response = ServletActionContext.getResponse();// 初始化HttpServletResponse对象
			out = response.getOutputStream();//
			response.setHeader("Content-disposition", "attachment; filename="
					+ "student" + ".xls");// filename是下载的xls的名，建议最好用英文
			response.setContentType("application/msexcel;charset=UTF-8");// 设置类型
			response.setHeader("Pragma", "No-cache");// 设置头
			response.setHeader("Cache-Control", "no-cache");// 设置头
			response.setDateHeader("Expires", 0);// 设置日期头
			workbook.write(out);
			out.flush();
			workbook.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {

				if (out != null) {
					out.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		return null;
	}

}
