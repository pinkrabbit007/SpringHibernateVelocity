package shiyanlou.test.hibernate.test;

import shiyanlou.test.hibernate.entity.User;
import shiyanlou.test.hibernate.service.UserService;

public class Test1 {

	public static void main(String[] args) throws Exception {
		UserService userService = new UserService();
		User user1 = new User();
		userService.insertUser();
/*		 user1.setUsername("jiabaoyu");
		user1.setPassword("0000");
		user1.setPhonenum("13735593161");
		user1.setIDcard("330726198907280050");
		userService.insertUser(user1);  
		if(userService.searchUsergrantedbySQL("贾宝玉"))
			System.out.println("YES");
		else 
			System.out.println("NO");   */
	}

}
