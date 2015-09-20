package shiyanlou.test.hibernate.controller;

import javax.mail.MessagingException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import shiyanlou.test.hibernate.util.ReciveOneMail;

/**
 * @date 2015-09-18
 * @author 你们最帅的张俊俏师兄
 * 
 */

@Controller
@RequestMapping("jfgl.do")
public class JfglController {
	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView testPage() {

		ModelAndView mav = new ModelAndView("jfgl"); 
		String temperature = null;
		try {
			temperature = ReciveOneMail.findTopmailTemper();
		} catch (MessagingException e) {
			System.out.println("Cannot connect to email-system");
			temperature = "Cannot connect to email-system";
			e.printStackTrace();
		}
		mav.addObject("lab429temperature",temperature);
		return mav;

	}
}
