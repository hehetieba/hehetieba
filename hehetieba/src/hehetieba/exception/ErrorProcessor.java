package hehetieba.exception;


import java.io.IOException;
import java.io.PrintWriter;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ErrorProcessor extends ActionSupport{
	private Exception exception;

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

	@Override
	public String execute() throws IOException {
//		ActionContext.getContext().getValueStack().push(
//				this.exception.getMessage());
//		return SUCCESS;
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		out.write(this.exception.getMessage());
		System.out.println(this.exception.getMessage());
		return null;
	}
}
