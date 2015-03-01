package hehetieba.daoTest;

import hehetieba.dao.ITiebaDao;
import hehetieba.dao.IUserDao;
import hehetieba.domain.Tieba;
import hehetieba.domain.User;
import hehetieba.service.ITiebaService;
import hehetieba.serviceTest.SpringInit;

import org.junit.Test;

public class TiebaDaoTest extends SpringInit {
	@Test
	public void testTiebaLoadBySelect() {
		ITiebaDao iTiebaDao = (ITiebaDao)context.getBean("tiebaDao");
		Integer id=1;
		String hql = "select t.id,t.memberCount,t.tieCount from Tieba t where t.id=1";
		Tieba tieba = (Tieba) iTiebaDao.list(hql);
//		System.out.println(tieba.toString());
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("tieba", tieba);
//		Gson gson = new Gson();
//		System.out.println(gson.toJson(map));
	}
}
