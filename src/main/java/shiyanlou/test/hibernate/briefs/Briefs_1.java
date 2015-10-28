package shiyanlou.test.hibernate.briefs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @date 2015-10-28
 * @author zjq
 * @content keith来访新闻报道
 */

@Controller
@RequestMapping("briefs_1.do")
public class Briefs_1 {
	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET })
	public String login2() {
		return "briefs_1";
	}
}
