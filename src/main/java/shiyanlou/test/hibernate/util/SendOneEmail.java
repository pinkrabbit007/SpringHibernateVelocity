package shiyanlou.test.hibernate.util;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.URLName;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * 
 * @author zjq
 * @aim 实现java发送邮件，
 * @date 2015-9-19
 * 
 */
public class SendOneEmail {

	public static void sendMail() {

		// 创建邮件发送类 JavaMailSender
		// 用于发送基本的文本邮件信息（不能包括附件，及图片）
		JavaMailSender sender = new JavaMailSenderImpl();

		// 设置邮件服务主机
		((JavaMailSenderImpl) sender).setHost("smtp.zju.edu.cn");
		// 发送者邮箱的用户名
		((JavaMailSenderImpl) sender).setUsername("justme");
		// 发送者邮箱的密码
		((JavaMailSenderImpl) sender).setPassword("280050");

		// 配置文件，用于实例化java.mail.session
		Properties pro = System.getProperties();
		pro.put("mail.smtp.auth", "true");
		pro.put("mail.smtp.socketFactory.port", "25");
		pro.put("mail.smtp.socketFactory.fallback", "false");

		// 登录SMTP服务器,需要获得授权，网易163邮箱新近注册的邮箱均不能授权。
		// 通过文件获取信息
		((JavaMailSenderImpl) sender).setJavaMailProperties(pro);

		System.out.println("在email函数里了");

		// 创建基本邮件信息
		MailMessage mailMessage = new SimpleMailMessage();

		// 发送者地址，必须填写正确的邮件格式，否者会发送失败
		mailMessage.setFrom("justme@zju.edu.cn");
		// 邮件主题
		mailMessage.setSubject("测试q1能否发邮件");
		// 邮件内容，简单的邮件信息只能添加文本信息
		mailMessage.setText("测试q1能否发邮件");
		// 邮件接收者的邮箱地址
		mailMessage.setTo("350024806@qq.com");

		// 发送邮件，参数可以是数组
		// sender.send(SimpleMailMessage[])
		sender.send((SimpleMailMessage) mailMessage);

	}

	
}
