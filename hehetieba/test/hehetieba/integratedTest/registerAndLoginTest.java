package hehetieba.integratedTest;

import hehetieba.basic.Pager;
import hehetieba.domain.ApplyOwnerResult;
import hehetieba.service.IApplyOwnerResultService;
import hehetieba.service.IUserService;
import hehetieba.serviceTest.SpringInit;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;

public class registerAndLoginTest extends SpringInit {
	@Test
	public void testRegisterAndLogin() {
		IUserService iUserService = (IUserService)context.getBean("userService");
		String username = "qianqi";
		String nickname = "qianqi";
		String pwd = "qianqi";
		boolean flag = iUserService.register(username, nickname, pwd);
		if(flag==true)
			System.out.println("注册成功");
		else {
			System.out.println("注册失败");
			return;
		}
		flag = iUserService.login(username,pwd);
		if(flag==true)
			System.out.println("登陆成功");
		else
			System.out.println("登录失败");
		System.out.println(flag);
	}
	
	
	
}






















