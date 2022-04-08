package spms.servlets;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

@SuppressWarnings("serial")
public class AppInitServlet extends HttpServlet {

	@Override
	// 서블릿 객체가 실행될 때 한번만 호출
	// 공유 자원 준비
	public void init(ServletConfig config) throws ServletException {
		System.out.println("AppInitServlet 준비…");
		super.init(config); // HttpServlet init() 기능 그대로 수행
		try {
			ServletContext sc = this.getServletContext();
			Class.forName(sc.getInitParameter("driver"));
			Connection conn = DriverManager.getConnection(
						sc.getInitParameter("url"),
						sc.getInitParameter("username"),
						sc.getInitParameter("password"));
			
			// 모든 서블릿들이 사용할 수 있도록 ServletContext(application) 객체에 저장
			sc.setAttribute("conn", conn);
		} catch(Throwable e) {
			throw new ServletException(e);
		}
	}
	
	@Override
	// 서블릿이 언로드 될 때 호출
	// 관리자가 톰캣 서버를 종료 or 웹 애플리케이션 종료 or 해당 서블릿 재로딩
	// 공유 자원 해제
	public void destroy() {
		System.out.println("AppInitServlet 마무리...");
		super.destroy();
		Connection conn = 
				(Connection)this.getServletContext().getAttribute("conn"); // getAttribute의 반환 값 : Object
		try {
			if (conn != null && conn.isClosed() == false) {
				conn.close();
			}
		} catch (Exception e) {}
		
	}
}
