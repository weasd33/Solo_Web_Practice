package spms.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/auth/logout")
public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서버에 생성된 세션이 있다면 세션을 반환
		HttpSession session = request.getSession();
		// 반환된 세션을 모두 삭제
		session.invalidate();
		// 세션 삭제 후 login으로 리다이렉트
		response.sendRedirect("login");
	}
}
