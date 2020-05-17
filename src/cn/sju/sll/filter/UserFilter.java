package cn.sju.sll.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter({ "/UserFilter", "/user/*" })
public class UserFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request =(HttpServletRequest) req;
		HttpServletResponse response =(HttpServletResponse) res;
		if(request.getSession().getAttribute("loginuser") != null) {
			chain.doFilter(req, res);
		}else {
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return;
		}
	}
	
	
    public UserFilter() {
    }

	public void destroy() {
	}


	
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
