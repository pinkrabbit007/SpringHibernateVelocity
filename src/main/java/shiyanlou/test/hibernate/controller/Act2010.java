package shiyanlou.test.hibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * @date 2015-09-17
 * @author 你们第二个帅的张博
 * 
 */

@Controller
@RequestMapping("act2010.do")
public class Act2010 {
	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET })
	public String login2() {
		return "act/act2010";
	}
}
