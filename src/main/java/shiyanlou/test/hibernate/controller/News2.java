package shiyanlou.test.hibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @date 2015-09-14
 * @author 你们最帅的张俊俏师兄
 *
 */

@Controller
@RequestMapping("news2.do")
public class News2 {
	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET })
	public String login2() {
		return "news2";
	}
}