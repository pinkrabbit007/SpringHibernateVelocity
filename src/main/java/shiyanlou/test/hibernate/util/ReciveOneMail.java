package shiyanlou.test.hibernate.util;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.URLName;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

/**
 * 
 * @date 2015-9-20
 * @author 张俊俏
 * @aim 用于查收邮箱里面的第一封邮件
 * @网址：http://xiangzhengyan.iteye.com/blog/85961
 */

public class ReciveOneMail {
	private MimeMessage mimeMessage = null;

	public ReciveOneMail(MimeMessage mimeMessage) {
		this.mimeMessage = mimeMessage;
	}

	public void setMimeMessage(MimeMessage mimeMessage) {
		this.mimeMessage = mimeMessage;
	}

	/**
	 * 获得邮件主题
	 */
	public String getSubject() throws MessagingException {
		String subject = "";
		try {
			subject = MimeUtility.decodeText(mimeMessage.getSubject());
			if (subject == null)
				subject = "";
		} catch (Exception exce) {
		}
		return subject;
	}

	public static String findTopmailTemper() throws MessagingException {

		Properties props = System.getProperties();
		props.put("mail.smtp.host", "smtp.zju.edu.cn");
		props.put("mail.smtp.auth", "true");
		Session session = Session.getDefaultInstance(props, null);
		URLName urln = new URLName("pop3", "pop3.zju.edu.cn", 110, null,
				"justme", "280050");
		Store store = session.getStore(urln);
		store.connect();
		Folder folder = store.getFolder("INBOX");
		folder.open(Folder.READ_ONLY);
		Message message[] = folder.getMessages();
		System.out.println("Messages's length: " + message.length);
		ReciveOneMail pmm = null;

		System.out.println("======================");
		pmm = new ReciveOneMail((MimeMessage) message[0]);
		System.out.println("Message " + " subject: " + pmm.getSubject());
		String emailTitle = pmm.getSubject();
		System.out.println(emailTitle.substring(11, 15));
		return emailTitle.substring(11, 15).toString();
	}
}
