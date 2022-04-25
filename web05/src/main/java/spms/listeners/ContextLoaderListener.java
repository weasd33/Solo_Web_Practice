package spms.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import spms.dao.MemberDao;
import spms.util.DBConnectionPool;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
	DBConnectionPool connPool;

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// contextInitialized() - 어플리케이션이 실행될 때 호출
		try {
			ServletContext sc = event.getServletContext();

			connPool = new DBConnectionPool(
					sc.getInitParameter("driver"),
					sc.getInitParameter("url"),
					sc.getInitParameter("username"),
					sc.getInitParameter("password"));

			MemberDao memberDao = new MemberDao();
			memberDao.setDbConnectionPool(connPool);

			// DB 연동한 memberDAO를 다른 서블릿에서도 사용하기 위해 set
			// 다른 서블릿에서는 memberDAO를 get해서 재사용해주면 됨
			sc.setAttribute("memberDao", memberDao);

		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// contextDestroyed() - 어플리케이션이 종료될 때 호출되는 메서드
		connPool.closeAll();
	}
}
