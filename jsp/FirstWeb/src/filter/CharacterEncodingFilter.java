package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/*@WebFilter(
		urlPatterns = { "/*" }, 
		initParams = { 
				@WebInitParam(name = "encoding", value = "UTF-8")
		})*/
public class CharacterEncodingFilter implements Filter {

	private String encoding;

    public CharacterEncodingFilter() {
        // TODO Auto-generated constructor stub
    }


	public void destroy() {
		System.out.println("죽다!!");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		request.setCharacterEncoding(encoding);

		
		System.out.println("doFilter");
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		encoding = fConfig.getInitParameter("encoding");
		if(encoding == null) {
			encoding = "UTF-8";
		}
		System.out.println("init()");
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
