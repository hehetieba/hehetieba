package hehetieba.serviceTest;

import hehetieba.basic.Pager;
import hehetieba.domain.ApplyOwnerResult;
import hehetieba.domain.TiebaApply;
import hehetieba.service.IApplyOwnerResultService;
import hehetieba.service.IManagerService;
import hehetieba.service.ITiebaApplyService;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ApplyOwnerResultServiceTest extends SpringInit {
	@Test
	public void testListAll() {
		IApplyOwnerResultService iApplyOwnerResultService = (IApplyOwnerResultService)context.getBean("applyOwnerResultService");
		Integer userId = 1;
		Integer index = 1;
		Integer size = 1;
		Pager<ApplyOwnerResult> pager = iApplyOwnerResultService.listAll(userId, index, size);
		
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("pager", pager);
		Gson gson = new Gson();
		System.out.println(gson.toJson(map));
	}
	
	
	
}






















