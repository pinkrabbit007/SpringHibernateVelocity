package shiyanlou.test.hibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @date 2015-09-18
 * @author 你们最帅的张俊俏师兄
 * 
 */

@Controller
@RequestMapping("jfgl.do")
public class JfglController {
	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET })
	public String login2() {
		return "jfgl";
	}
}
