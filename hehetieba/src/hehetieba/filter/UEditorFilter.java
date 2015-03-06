package hehetieba.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

public class UEditorFilter extends StrutsPrepareAndExecuteFilter {
	@Override
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
                chain.doFilter(req, res);
                System.out.println("进入方法了");
            } else {    
                super.doFilter(req, res, chain);    
            }    
        }catch(Exception e){    
            e.printStackTrace();    
        }    
	}
}
