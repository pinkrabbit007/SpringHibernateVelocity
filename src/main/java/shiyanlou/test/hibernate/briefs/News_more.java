package shiyanlou.test.hibernate.briefs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @date 2015-11-04
 * @author zb
 * @content 
 */

@Controller
@RequestMapping("news_more.do")
public class News_more {
	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET })
	public String login2() {
		return "news/news_more";
	}
}
