package hehetieba.serviceTest;

import hehetieba.basic.Pager;
import hehetieba.domain.TiebaApply;
import hehetieba.service.ITiebaApplyService;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TiebaApplyServiceTest extends SpringInit {
	@Test
	public void testSaveTiebaApply() {
		ITiebaApplyService iTiebaApplyService = (ITiebaApplyService)context.getBean("tiebaApplyService");
		String tiebaName = "008";
		boolean flag = iTiebaApplyService.saveTiebaApply(tiebaName);
		System.out.println(flag);
		Map<String, String> map = new HashMap<String,String>();
		if(flag==true)
			map.put("message", "已经提交申请");
		else
			map.put("message", "抱歉，该贴吧不能被申请");
		Gson gson = new Gson();
		System.out.println(gson.toJson(map));
	}
	
	@Test
	public void testListAll() {
		ITiebaApplyService iTiebaApplyService = (ITiebaApplyService)context.getBean("tiebaApplyService");
		Integer index = 1;
		Integer size = 10;
		Pager<TiebaApply> pager = iTiebaApplyService.listAll(index, size);
//		tie.getTieTitle().setUser(null);
		//输出 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pager", pager);
		Gson gson = new GsonBuilder()
	    .serializeNulls()
	    .setDateFormat("yyyy-MM-dd' 'HH:mm:ss")
	    .create();
		System.out.println(gson.toJson(map));
	}
	
	@Test
	public void testListHandled() {
		ITiebaApplyService iTiebaApplyService = (ITiebaApplyService)context.getBean("tiebaApplyService");
		Integer index = 1;
		Integer size = 10;
		Pager<TiebaApply> pager = iTiebaApplyService.listHandled(index, size);
//		tie.getTieTitle().setUser(null);
		//输出 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pager", pager);
		Gson gson = new GsonBuilder()
	    .serializeNulls()
	    .setDateFormat("yyyy-MM-dd' 'HH:mm:ss")
	    .create();
		System.out.println(gson.toJson(map));
	}
	
	@Test
	public void testListUnhandled() {
		ITiebaApplyService iTiebaApplyService = (ITiebaApplyService)context.getBean("tiebaApplyService");
		Integer index = 1;
		Integer size = 10;
		Pager<TiebaApply> pager = iTiebaApplyService.listUnhandled(index, size);
//		tie.getTieTitle().setUser(null);
		//输出 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pager", pager);
		Gson gson = new GsonBuilder()
	    .serializeNulls()
	    .setDateFormat("yyyy-MM-dd' 'HH:mm:ss")
	    .create();
		System.out.println(gson.toJson(map));
	}
	
}






















