package shiyanlou.test.hibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @date 2015-09-13
 * @author 你们最帅的张俊俏师兄
 * 
 */

@Controller
@RequestMapping("members.do")
public class MembersController {
	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET })
	public String login2() {
		return "members";
	}
}