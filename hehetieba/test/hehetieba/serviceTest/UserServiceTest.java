package hehetieba.serviceTest;

import java.io.File;

import hehetieba.domain.User;
import hehetieba.service.IUserService;

import org.junit.Test;

public class UserServiceTest extends SpringInit {
	
	@Test
	public void testUserLoad() {
		IUserService iUserService = (IUserService)context.getBean("userService");
		User user = (User)iUserService.getUserById(1);
//		System.out.println(user);
		System.out.println("111");
	}
	
	/**
	 * 判断一个username是否存在
	 */
	@Test
	public void testCheckUsername() {
		IUserService iUserService = (IUserService)context.getBean("userService");
		String username = "zhangsan3";
		boolean flag = iUserService.checkUsername(username);
		System.out.println("flag:"+flag);
		if(flag==true)
			System.out.println("用户名"+username+"已存在");
		else
			System.out.println("用户名"+username+"可以使用");
	}
	
	/**
	 * 判断一个nickname是否存在
	 */
	@Test
	public void testCheckNickname() {
		IUserService iUserService = (IUserService)context.getBean("userService");
		String nickname = "张三3";
		boolean flag = iUserService.checkNickname(nickname);
		System.out.println("flag:"+flag);
		if(flag==true)
			System.out.println(nickname+"已存在");
		else
			System.out.println(nickname+"可以使用");
	}
	
	/**
	 * 测试注册按钮点下后
	 */
	@Test
	public void testRegister() {
		IUserService iUserService = (IUserService)context.getBean("userService");
		String username = "zhangsan2";
		String nickname = "张三2";
		String pwd = "zhangsan2";
		boolean flag = iUserService.register(username, nickname, pwd);
		if(flag==true)
			System.out.println("注册成功");
		else
			System.out.println("注册失败");
	}
	

	
	@Test
	public void testLogin() {
		IUserService iUserService = (IUserService)context.getBean("userService");
		String username= "zhangsan";
		String pwd = "zhangsan";
		boolean flag = iUserService.login(username,pwd);
		System.out.println(flag);
	}
	
	@Test
	public void testChangeMessage() {
		IUserService iUserService = (IUserService)context.getBean("userService");
		String nickname = "zhangsan11";
		String introduction = "zhangsan11";
		Byte gender = (byte) 1;
		String birthday = "1990-0-0";
		iUserService.changeMessage(1, nickname, introduction, gender, birthday);
	}
	
	@Test
	public void testUploadHeadImg() {
		IUserService iUserService = (IUserService)context.getBean("userService");
		File file = new File("C:\\Users\\Administrator\\Desktop\\gbk.txt");
		String ext=".txt";
		iUserService.uploadHeadImg(1, file, ext);
		
	}
}













