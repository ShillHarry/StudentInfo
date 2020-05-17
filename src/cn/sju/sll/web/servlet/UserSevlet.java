package cn.sju.sll.web.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sju.sll.dao.UserDao;
import cn.sju.sll.dao.impl.UserDaoImpl;
import cn.sju.sll.domain.User;

@WebServlet("/user/*")
public class UserSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao = new UserDaoImpl();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String uri = request.getRequestURI();
		if(uri.endsWith("/users")) {
			List<User> users = userDao.findAll();
			request.setAttribute("users", users);
			request.getRequestDispatcher("/WEB-INF/user/shows.jsp").forward(request, response);
			return;
		}else if (uri.endsWith("/add")) {
			String method = request.getMethod();
			if ("GET".equalsIgnoreCase(method)) {
				request.getRequestDispatcher("/WEB-INF/user/adduser.jsp").forward(request, response);
				return;
			} else if("POST".equalsIgnoreCase(method)) {
				String ID = request.getParameter("ID");
				String name = request.getParameter("name");
				Boolean sex = Boolean.parseBoolean(request.getParameter("sex"));
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date birthday = new Date();
				try {
					birthday = simpleDateFormat.parse(request.getParameter("birthday"));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				SimpleDateFormat year = new SimpleDateFormat("yyyy");
				String today = year.format(new Date());
				String birth = year.format(birthday);
				int age =Integer.parseInt(today)-Integer.parseInt(birth);
				String phone = request.getParameter("phoneNumber");
				String department = request.getParameter("department");
				String dorm = request.getParameter("dorm");
				User user = new User();
				user.setID(ID);
				user.setAge(age);
				user.setBirthday(birthday);
				user.setSex(sex);
				user.setName(name);
				user.setPhoneNumber(phone);
				user.setDepartment(department);
				user.setDorm(dorm);
				boolean result = userDao.save(user);
				if (result) {
					System.out.println("添加用户成功！");
				}else {
					System.out.println("添加用户失败！");
				}
				response.sendRedirect(request.getContextPath()+"/index.jsp");
				return;
			}
		}else if (uri.endsWith("/update")) {
			String method = request.getMethod();
			if("GET".equalsIgnoreCase(method)) {
				String ID = request.getParameter("ID");
				if(ID != null) {
					User user = userDao.findByID(ID);
					request.setAttribute("user", user);
					request.getRequestDispatcher("/WEB-INF/user/updateuser.jsp").forward(request, response);
					return;
				}else {
					response.sendRedirect(request.getContextPath()+"/index.jsp");
					return;
				}
			}else if ("POST".equalsIgnoreCase(method)) {
				User user = new User();
				user.setID(request.getParameter("ID"));
				user.setName(request.getParameter("name"));
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				try {
					user.setBirthday(simpleDateFormat.parse(request.getParameter("birthday")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				user.setSex(Boolean.parseBoolean(request.getParameter("sex")));
				user.setAge(Integer.parseInt(request.getParameter("age")));
				user.setPhoneNumber(request.getParameter("phoneNumber"));
				user.setDepartment(request.getParameter("department"));
				user.setDorm(request.getParameter("dorm"));
				userDao.update(user);
				response.sendRedirect(request.getContextPath()+"/index.jsp");
				return;
			}
			
		}else if (uri.endsWith("/delete")) {
			String ID = request.getParameter("ID");
			userDao.deleteByID(ID);
			response.sendRedirect(request.getContextPath()+"/index.jsp");
			return;
		}else if (uri.endsWith("/showone")) {
			String ID = request.getParameter("ID");
			User user = userDao.findByID(ID);
			request.setAttribute("user", user);
			request.getRequestDispatcher("/WEB-INF/user/showone.jsp").forward(request, response);
		}
	}

}
