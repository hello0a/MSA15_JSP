package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servlet/forward")
public class ForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(
		HttpServletRequest request, 
		HttpServletResponse response
	) throws ServletException, IOException {
		// 요청 정보 전달
		request.setAttribute("msg", "servlet 으로 forward 방식으로 이동하기!");
		
		// (서블릿) forward 방식으로 이동
		// : /(최상위 경로) 기준으로 이동되므로 컨텍스트 패스 사용X 가능
		RequestDispatcher dispatcher = request.getRequestDispatcher("/servlet/forward/detail.jsp");
		dispatcher.forward(request, response);
	}

}
