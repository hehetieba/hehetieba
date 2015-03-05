package hehetieba.serviceTest;

import hehetieba.service.ITiebaApplyService;
import hehetieba.service.ITiebaOwnerApplyService;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;

public class TiebaOwnerApplyServiceTest extends SpringInit {
	@Test
	public void testApplyTiebaOwner() {
		ITiebaOwnerApplyService iTiebaOwnerApplyService = (ITiebaOwnerApplyService)context.getBean("tiebaOwnerApplyService");
		Integer userId = 1;
		Integer tiebaId = 1;
		String username = "zhangsan";
		String tiebaName = "hehe";
		Integer result = iTiebaOwnerApplyService.applyTiebaOwner(userId, tiebaId, username, tiebaName);
		System.out.println(result);
		Map<String, String> map = new HashMap<String,String>();
		if(result==0)
			map.put("message", "请先关注该贴吧");
		else if(result==1)
			map.put("message", "你已经提交过申请了，请耐心等待管理员处理");
		else
			map.put("message", "已经成功提交申请，请耐心等待管理员处理");
		Gson gson = new Gson();
		System.out.println(gson.toJson(map));
	}
	
	
}






















