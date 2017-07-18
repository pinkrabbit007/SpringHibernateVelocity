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
		mav.addObject("lab427temperature", temperature);

		/**
		 * 获取过去24小时的温度
		 */

		Vector<String> primaryresult = null;
		Vector<Float> result = new Vector<Float>();
		try {
			primaryresult = ReciveOneMail.find24hoursTemper();
			for (int i = 0; i < primaryresult.size(); i++) {
				System.out.print(" " + primaryresult.get(i));
				Float num = new Float(primaryresult.get(i));
				// Float num = Float.valueOf(primaryresult.get(i));
				// //好像这句也是对的，那么new一个包装类和这个有啥区别呢？
				result.add(num);
			}

		} catch (MessagingException e) {
			System.out.println("We do not have 144 emails !!");
		}
		mav.addObject("last24hoursT", result);

		mav.addObject("last24hoursT_0", result.get(0));
		mav.addObject("last24hoursT_1", result.get(1));
		mav.addObject("last24hoursT_2", result.get(2));
		mav.addObject("last24hoursT_3", result.get(3));
		mav.addObject("last24hoursT_4", result.get(4));
		mav.addObject("last24hoursT_5", result.get(5));
		mav.addObject("last24hoursT_6", result.get(6));
		mav.addObject("last24hoursT_7", result.get(7));
		mav.addObject("last24hoursT_8", result.get(8));
		mav.addObject("last24hoursT_9", result.get(9));
		mav.addObject("last24hoursT_10", result.get(10));
		mav.addObject("last24hoursT_11", result.get(11));
		mav.addObject("last24hoursT_12", result.get(12));
		mav.addObject("last24hoursT_13", result.get(13));
		mav.addObject("last24hoursT_14", result.get(14));
		mav.addObject("last24hoursT_15", result.get(15));
		mav.addObject("last24hoursT_16", result.get(16));
		mav.addObject("last24hoursT_17", result.get(17));
		mav.addObject("last24hoursT_18", result.get(18));
		mav.addObject("last24hoursT_19", result.get(19));
		mav.addObject("last24hoursT_20", result.get(20));
		mav.addObject("last24hoursT_21", result.get(21));
		mav.addObject("last24hoursT_22", result.get(22));
		mav.addObject("last24hoursT_23", result.get(23));
		
		/**
		 * 获取过去一周的温度
		*/
/**		Vector<String> resultofweek = null;
		try {
			resultofweek = ReciveOneMail.findLastWeekT();
			for (int i = 0; i < resultofweek.size(); i++) {
				System.out.print(" " + resultofweek.get(i));
			}

		} catch (MessagingException e) {
			System.out.println("We do not have 144 emails !!");
		}
		mav.addObject("lastWeekT", resultofweek);

		mav.addObject("lastWeekT_0", resultofweek.get(0));
		mav.addObject("lastWeekT_1", resultofweek.get(1));
		mav.addObject("lastWeekT_2", resultofweek.get(2));
		mav.addObject("lastWeekT_3", resultofweek.get(3));
		mav.addObject("lastWeekT_4", resultofweek.get(4));
		mav.addObject("lastWeekT_5", resultofweek.get(5));
		mav.addObject("lastWeekT_6", resultofweek.get(6));
		*/
		return mav;
	}
}
