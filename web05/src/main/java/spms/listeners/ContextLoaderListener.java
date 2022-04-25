package spms.listeners;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import spms.dao.MemberDao;

@WebListener
public class ContextLoaderListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// contextInitialized() - 어플리케이션이 실행될 때 호출
		try {
			ServletContext sc = event.getServletContext();
		      
			InitialContext initialContext = new InitialContext();
			// lookup 메서드의 매개변수 값은 서버 자원의 JNDI 이름 앞에 "java:comp/env"를 붙임
			// 반환형은 Object로 형변환을 해줌
			DataSource ds = (DataSource)initialContext.lookup("java:comp/env/jdbc/oracle");
	      
			MemberDao memberDao = new MemberDao();
			memberDao.setDataSource(ds);
	      
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
	}
}
