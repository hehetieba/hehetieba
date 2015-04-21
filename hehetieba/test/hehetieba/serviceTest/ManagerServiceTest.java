package hehetieba.serviceTest;

import hehetieba.service.IManagerService;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;

public class ManagerServiceTest extends SpringInit {
	@Test
	public void testUpdateTiabaApplyReadToHave_All() {
		IManagerService iManagerService = (IManagerService)context.getBean("managerService");
		Integer count = iManagerService.updateTiabaApplyReadToHave_All();
		System.out.println(count);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("message", count);
		Gson gson = new Gson();
		System.out.println(gson.toJson(map));
	}
	
	@Test
	public void testUpdateTiabaApplyReadToNon_All() {
		IManagerService iManagerService = (IManagerService)context.getBean("managerService");
		Integer count = iManagerService.updateTiabaApplyReadToNon_All();
		System.out.println(count);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("message", count);
		Gson gson = new Gson();
		System.out.println(gson.toJson(map));
	}
	
	@Test
	public void testLogin() {
		IManagerService iManagerService = (IManagerService)context.getBean("managerService");
		String managername = "admin";
		String pwd = "admin11";
		boolean flag = iManagerService.login(managername, pwd);
		System.out.println(flag);
		Map<String, Object> map = new HashMap<String,Object>();
		if(flag==true)
			map.put("msg", "登陆成功");
		else
			map.put("msg", "账号或者密码错误");
		Gson gson = new Gson();
		System.out.println(gson.toJson(map));
	}
	
	@Test
	public void testChangePwd() {
		IManagerService iManagerService = (IManagerService)context.getBean("managerService");
		String oldPwd = "admin11";
		String newPwd = "admin";
		boolean flag = iManagerService.changePwd(oldPwd, newPwd);
		System.out.println(flag);
		Map<String, Object> map = new HashMap<String,Object>();
		if(flag==true)
			map.put("msg", "修改成功");
		else
			map.put("msg", "修改失败");
		Gson gson = new Gson();
		System.out.println(gson.toJson(map));
	}
	
	@Test
	public void testCheckTiebaApplyRead() {
		IManagerService iManagerService = (IManagerService)context.getBean("managerService");
		boolean flag = iManagerService.checkTiebaApplyRead();
		System.out.println(flag);
		Map<String, Object> map = new HashMap<String,Object>();
		if(flag==true)
			map.put("msg", "有贴吧申请消息");
		else
			map.put("msg", "没有贴吧申请消息");
		Gson gson = new Gson();
		System.out.println(gson.toJson(map));
	}
	
	@Test
	public void testCheckTiebaOwnerApplyRead() {
		IManagerService iManagerService = (IManagerService)context.getBean("managerService");
		boolean flag = iManagerService.checkTiebaOwnerApplyRead();
		System.out.println(flag);
		Map<String, Object> map = new HashMap<String,Object>();
		if(flag==true)
			map.put("msg", "有贴吧吧主申请消息");
		else
			map.put("msg", "没有贴吧吧主申请消息");
		Gson gson = new Gson();
		System.out.println(gson.toJson(map));
	}
	
}























