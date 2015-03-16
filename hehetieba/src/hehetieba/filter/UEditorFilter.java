package hehetieba.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

public class UEditorFilter extends StrutsPrepareAndExecuteFilter {
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) req;    
//        StringBuffer url = request.getRequestURL(); //http://localhost:8080/jqueryWeb/resources/request.jsp
        String url2 = request.getRequestURI(); ///jqueryWeb/resources/request.jsp
//        String url3 = request.getContextPath();///jqueryWeb
//        String url4 = request.getServletPath();///resources/request.jsp
//        String url5 = request.getPathInfo();	///request.jsp
//        System.out.println("getRequestURL："+url);
        System.out.println("getRequestURI："+url2);
//        System.out.println("getContextPath："+url3);
//        System.out.println("getServletPath："+url4);
//        System.out.println("getPathInfo："+url5);
        try{    
            if (url2.endsWith("controller.jsp")) {
//            	System.out.println("使用自定义的过滤器");
                chain.doFilter(req, res);
            } else {
//            	System.out.println("使用默认的过滤器");
                super.doFilter(req, res, chain);    
            }    
        }catch(Exception e){    
            e.printStackTrace();    
        }    
	}
}
