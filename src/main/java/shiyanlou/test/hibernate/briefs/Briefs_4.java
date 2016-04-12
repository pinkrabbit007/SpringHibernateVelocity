package shiyanlou.test.hibernate.briefs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @date 2016-04-12
 * @author zjq
 * @content 康玉jacs
 */

@Controller
@RequestMapping("briefs_4.do")
public class Briefs_4 {
	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET })
	public String login2() {
		return "briefs_4";
	}
}
