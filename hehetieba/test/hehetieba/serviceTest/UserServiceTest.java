package hehetieba.serviceTest;

import hehetieba.domain.User;
import hehetieba.service.IUserService;

import org.junit.Test;

public class UserServiceTest extends SpringInit {
	@Test
	public void testUserSave() {
		IUserService iUserService = (IUserService)context.getBean("userService");
		User user = new User();
		user.setUsername("zhangsan");
		user.setNickname("张三");
		user.setGender((byte) 1);
		iUserService.save(user);
	}
}
