package hehetieba.serviceTest;

import hehetieba.basic.Pager;
import hehetieba.domain.Tieba;
import hehetieba.service.ITiebaService;

import org.junit.Test;

public class TiebaServiceTest extends SpringInit {
	@Test
	public void testUserLoad() {
		ITiebaService iTiebaService = (ITiebaService)context.getBean("tiebaService");
		Integer index = 1;
		Integer size = 1;
		Pager<Tieba> pager = iTiebaService.list(index, size);
		System.out.println(pager);
	}
}
