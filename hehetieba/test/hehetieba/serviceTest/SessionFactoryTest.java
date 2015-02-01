package hehetieba.serviceTest;

import hehetieba.service.IUserService;
import hehetieba.service.impl.UserService;

import org.junit.Test;

public class SessionFactoryTest extends SpringInit {
	@Test
	public void testSessionFactory() {
		IUserService iUserService = (IUserService)context.getBean("userService");
		System.out.println(iUserService);
	}
}
