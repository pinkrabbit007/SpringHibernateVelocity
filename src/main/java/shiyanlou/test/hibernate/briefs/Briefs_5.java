package shiyanlou.test.hibernate.briefs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @date 2016-4-12
 * @author zjq
 * @content zzs毕业答辩
 */

@Controller
@RequestMapping("briefs_5.do")
public class Briefs_5 {
	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET })
	public String login2() {
		return "briefs_5";
	}
}
