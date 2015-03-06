package hehetieba.serviceTest;

import hehetieba.basic.Pager;
import hehetieba.domain.TiebaApply;
import hehetieba.service.IManagerService;
import hehetieba.service.ITiebaApplyService;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
	
	
}






















