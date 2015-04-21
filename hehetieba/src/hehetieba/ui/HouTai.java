package hehetieba.ui;

import hehetieba.domain.Manager;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class HouTai extends ActionSupport implements RequestAware,SessionAware,ServletResponseAware {
	
	private Map<String, Object> request;
    private Map<String, Object> session;
    HttpServletResponse response = null;
    
	@Override
	public String execute() throws IOException {
		Manager manager = (Manager)session.get("manager");
		if(manager==null)
			response.sendRedirect("houtai");
		return SUCCESS;
	}


	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request=request;
	}


	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}
}
