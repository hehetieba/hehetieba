package hehetieba.daoTest;

import hehetieba.dao.IUserDao;
import hehetieba.domain.User;
import hehetieba.serviceTest.SpringInit;

import org.junit.Test;

public class UserDaoTest extends SpringInit {
	@Test
	public void testUserSave() {
		IUserDao iUserDao = (IUserDao)context.getBean("userDao");
		User user = new User();
		user.setGender((byte) 1);
		iUserDao.save(user);
	}
}
