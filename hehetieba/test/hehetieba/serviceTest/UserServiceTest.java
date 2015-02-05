package hehetieba.serviceTest;

import java.io.File;

import hehetieba.domain.User;
import hehetieba.service.IUserService;

import org.junit.Test;

public class UserServiceTest extends SpringInit {
	
	@Test
	public void testUserLoad() {
		IUserService iUserService = (IUserService)context.getBean("userService");
		User user = (User)iUserService.loadUser(1);
//		System.out.println(user);
		System.out.println("111");
	}
	
	@Test
	public void testRegisterSave() {
		IUserService iUserService = (IUserService)context.getBean("userService");
		User user = new User();
		user.setUsername("zhangsan1");
		user.setNickname("张三1");
		user.setGender((byte) 1);
		boolean flag = iUserService.register(user);
		if(flag==true)
			System.out.println("注册成功");
		else
			System.out.println("注册失败");
	}
	
	@Test
	public void testCheckUsername() {
		IUserService iUserService = (IUserService)context.getBean("userService");
		boolean flag = iUserService.checkUsername("zhangsan");
		System.out.println(flag);
	}
	
	@Test
	public void testCheckNickname() {
		IUserService iUserService = (IUserService)context.getBean("userService");
		boolean flag = iUserService.checkNickname("张三");
		System.out.println(flag);
	}
	
	@Test
	public void testLogin() {
		IUserService iUserService = (IUserService)context.getBean("userService");
		boolean flag = iUserService.login("zhangsan","111");
		System.out.println(flag);
	}
	
	@Test
	public void testUploadHeadImg() {
		IUserService iUserService = (IUserService)context.getBean("userService");
		File file = new File("C:\\Users\\Administrator\\Desktop\\gbk.txt");
		String ext=".txt";
		iUserService.uploadHeadImg(1, file, ext);
		
	}
}













