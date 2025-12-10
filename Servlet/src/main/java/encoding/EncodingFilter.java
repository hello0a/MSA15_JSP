package encoding;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;

@WebFilter(
		urlPatterns = { "/*" }, 
		initParams = { 
				@WebInitParam(name = "encoding", value = "UTF-8")
		})
public class EncodingFilter extends HttpFilter implements Filter {
	String encoding;
	FilterConfig filterConfig;
	// 생성자
    public EncodingFilter() {
        super();
    }
    // 고치화 해야 위의 encoding 값 들어감
    // 필터 초기화 메서드
    public void init(FilterConfig filterConfig) throws ServletException {
    	this.filterConfig = filterConfig;
    	encoding = filterConfig.getInitParameter("encoding");	// UTF-8
    	System.out.println("필터 초기화 - encoding : " + encoding);
    }
	// 필터 작업 메서드
	public void doFilter(
			ServletRequest request, 
			ServletResponse response, 
			FilterChain chain
	) throws IOException, ServletException {
		System.out.println("인코딩 필터 : " + encoding);
		// 인코딩 설정
		// 요청 및 응답 2번 필터
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		response.setContentType("text/plain; charset=" + encoding);
		// 다음 필터를 호출
		chain.doFilter(request, response);
	}
	// 필터 소멸 메서드
	public void destroy() {
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */

}
