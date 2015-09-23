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
			System.out.println(temperature.substring(0, 1)
					.equalsIgnoreCase("0"));
			// 问题来了，假如temperature是字符串0，为什么这里temperature.substring(0,1).equals("0")是false？
			if (temperature.equals("0.00")) {
				temperature = "(⊙o⊙)…机房温度传感器挂了";
				System.out.println("(⊙o⊙)…机房温度传感器挂了");
			}
		} catch (MessagingException e) {
			System.out.println("Cannot connect to email-system");
			temperature = "Cannot connect to email-system " + e.toString();
			e.printStackTrace();
		}
		mav.addObject("lab429temperature", temperature);
		return mav;
	}
}
