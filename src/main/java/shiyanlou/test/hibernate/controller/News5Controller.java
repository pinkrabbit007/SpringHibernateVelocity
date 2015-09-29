package shiyanlou.test.hibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @date 2015-09-23
 * @author 你们的大师兄连夜在加班哦
 * 
 */

@Controller
@RequestMapping("news5.do")
public class News5Controller {
	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET })
	public String login2() {
		return "news5";
	}
}
