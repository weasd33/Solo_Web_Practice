package lesson03.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloWorld implements Servlet {
	ServletConfig config;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// 클라이언트 요청을 처리하는데 필요한 자원을 미리 준비하는 곳
		System.out.println("init() 호출됨");
		this.config = config;
	}
	
	@Override
	public void destroy() {
		// 서블릿 컨테이너가 종료되거나 웹 애플리케이션이 멈출 때
		// 또는 해당 서블릿을 비활성화 시킬 때 호출되고
		// 서비스 수행을 위해 확보했던 자원을 해제한다거나 
		// 데이터를 저장하는 등의 마무리 작업을 하는 곳
		System.out.println("destroy() 호출됨");
	}
	
	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		// 클라이언트가 요청할 때 마다 호출되며
		// 실질적으로 서비스 작업을 수행하는 곳
		System.out.println("service() 호출됨");
	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("getServletConfig() 호출됨");
		return this.config;
	}

	@Override
	public String getServletInfo() {
		System.out.println("getServletInfo() 호출됨");
		return "version=1.0;author=eomjinyoung;copyright=eomjinyoung 2013";
	}
}
