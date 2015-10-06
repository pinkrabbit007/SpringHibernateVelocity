package shiyanlou.test.hibernate.controller;

import java.util.Vector;

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
		
		/**
		 * 获取过去24小时的温度
		 */
		
		Vector<String> result = null;
		try {
			result = ReciveOneMail.find24hoursTemper();
			for (int i = 0; i < result.size(); i++) {
				System.out.print(" " + result.get(i));
			}

		} catch (MessagingException e) {
			System.out.println("We do not have 144 emails !!");
		}
		mav.addObject("last24hoursT", result);
		
		/**
		 * 获取过去一周的温度
		 */		 
		Vector<String> resultofweek = null;
		try {
			resultofweek = ReciveOneMail.findLastWeekT();
			for (int i = 0; i < resultofweek.size(); i++) {
				System.out.print(" " + resultofweek.get(i));
			}

		} catch (MessagingException e) {
			System.out.println("We do not have 144 emails !!");
		} 
		mav.addObject("lastWeekT", resultofweek);
		return mav;
	}
}
