package hehetieba.serviceTest;

import hehetieba.domain.Tieba;
import hehetieba.domain.User;
import hehetieba.service.IUserService;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UserServiceTest extends SpringInit {
	
	@Test
	public void testGetUserById() {
		IUserService iUserService = (IUserService)context.getBean("userService");
		User user = (User)iUserService.getUserById(1);
//		System.out.println(user);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user", user);
		Gson gson = new GsonBuilder()
		.setExclusionStrategies(new ExclusionStrategy() {
	        public boolean shouldSkipClass(Class<?> clazz) {
	        	if(clazz == Set.class)
	        		return true;
	            return false;
	        }
	        public boolean shouldSkipField(FieldAttributes f) {
	            return false;
	        }

	     })
	    /**
	      * Use serializeNulls method if you want To serialize null values 
	      * By default, Gson does not serialize null values
	      */
	    .serializeNulls()
	    .setDateFormat("yyyy-MM-dd' 'HH:mm:ss")
	    .create();
		System.out.println(gson.toJson(map));
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
		String pwd = "zhangsan1";
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
	public void changePwd() {
		IUserService iUserService = (IUserService)context.getBean("userService");
		Integer id = 1;
		String oldPwd = "zhangsan";
		String newPwd = "zhangsan1";
		Boolean flag = iUserService.changePwd(id, oldPwd, newPwd);
		if(flag == true)
			System.out.println("改变密码成功");
		else
			System.out.println("改变密码失败");
	}
	
	@Test
	public void testUploadHeadImg() {
		IUserService iUserService = (IUserService)context.getBean("userService");
		File file = new File("C:\\Users\\Administrator\\Desktop\\gbk.txt");
		String ext=".txt";
		iUserService.uploadHeadImg(1, file, ext);
		
	}
	
	@Test
	public void testCheckTieRead() {
		IUserService iUserService = (IUserService)context.getBean("userService");
		Integer id = 1;
		Boolean flag = iUserService.checkTieRead(id);
		if(flag==true)
			System.out.println("有未读回贴");
		else
			System.out.println("木有未读回贴");
	}
	
	@Test
	public void testCheckReplyRead() {
		IUserService iUserService = (IUserService)context.getBean("userService");
		Integer id = 1;
		Boolean flag = iUserService.checkReplyRead(id);
		if(flag==true)
			System.out.println("有未读回复");
		else
			System.out.println("木有未读回复");
	}
	
	@Test
	public void testCheckApplyResultRead() {
		IUserService iUserService = (IUserService)context.getBean("userService");
		Integer id = 1;
		Boolean flag = iUserService.checkApplyResultRead(id);
		if(flag==true)
			System.out.println("有未读吧主申请反馈");
		else
			System.out.println("木有未读吧主申请反馈");
	}
	
}













