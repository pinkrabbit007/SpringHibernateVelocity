package shiyanlou.test.hibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shiyanlou.test.hibernate.util.SendOneEmail;

/**
 * @date 2015-09-13
 * @author 你们最帅的张俊俏师兄
 * 
 */

@Controller
@RequestMapping("research.do")
public class ResearchController {
	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET })
	public String login2() {
		return "research";
	}
}
