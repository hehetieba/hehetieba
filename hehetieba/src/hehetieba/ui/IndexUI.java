package hehetieba.ui;

import java.util.Map;
import java.util.Set;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class IndexUI extends ActionSupport implements RequestAware,SessionAware {
	
	private Map<String, Object> request;
    private Map<String, Object> session;
    
	@Override
	public String execute() {
		Set<String> keys = session.keySet();
		for(String key:keys) {
			Object value = session.get(key);
//			System.out.println(key + " : " + value);
			System.out.println(key);
		}
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
}
