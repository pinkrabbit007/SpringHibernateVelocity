package shiyanlou.test.hibernate.util;

import java.util.Properties;
import java.util.Vector;

import javax.mail.Flags;
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
	/*
	 * 2015年9月20找出邮箱第一封邮件的温度值。10月19日增加功能：删除3000封之后的邮件
	 */
	public static String findTopmailTemper() throws MessagingException {

		Properties props = System.getProperties();
		props.put("mail.smtp.host", "smtp.zju.edu.cn");
		props.put("mail.smtp.auth", "true");
		Session session = Session.getDefaultInstance(props, null);
		URLName urln = new URLName("pop3", "pop3.zju.edu.cn", 110, null,
				"justme", "asdf280050");
		Store store = session.getStore(urln);
		store.connect();
		Folder folder = store.getFolder("INBOX");
		folder.open(Folder.READ_WRITE); // 这里要从READ_ONLY改成READ_WRITE才能删除邮件
		Message message[] = folder.getMessages();
		System.out.println("Messages's length: " + message.length);
		ReciveOneMail pmm = null;

		System.out.println("======================");
		pmm = new ReciveOneMail((MimeMessage) message[0]);
		System.out.println("Message " + " subject: " + pmm.getSubject());
		String emailTitle = pmm.getSubject();
		System.out.println(emailTitle.substring(11, 15));
/*
 *  添加删除末尾3000封邮件之后的邮件功能
 */
		if (message.length > 3000) {
			for (int i = 3000; i < message.length; i++) {
				message[i].setFlag(Flags.Flag.DELETED, true);
				if (message[i].isSet(Flags.Flag.DELETED))
					System.out.println("已经删除第" + i + "邮件。。。。。。。。。");
			}
			folder.close(true);// 这步一定要写，不然不能提交修改。只读操作的话，这步可以不写。
		}
		
		
		return emailTitle.substring(11, 15).toString();
	}

	public static Vector<String> find24hoursTemper() throws MessagingException {
		Vector<String> result = new Vector<String>();
		Properties props = System.getProperties();
		props.put("mail.smtp.host", "smtp.zju.edu.cn");
		props.put("mail.smtp.auth", "true");
		Session session = Session.getDefaultInstance(props, null);
		URLName urln = new URLName("pop3", "pop3.zju.edu.cn", 110, null,
				"justme", "asdf280050");
		Store store = session.getStore(urln);
		store.connect();
		Folder folder = store.getFolder("INBOX");
		folder.open(Folder.READ_ONLY);
		Message message[] = folder.getMessages();
		System.out.println("Messages's length: " + message.length);
		ReciveOneMail pmm = null;

		for (int i = 0; i < message.length; i = i + 6) {
			// 由于是10分钟取一个点，那么每个小时之间有6个点。我们取24小时，就有144个点。
			if (i > 143)
				break;
			pmm = new ReciveOneMail((MimeMessage) message[i]);
			String emailTitle = pmm.getSubject();
			String tempresult = emailTitle.substring(11, 15);
			result.addElement(tempresult);
		}
		return result;
	}

/**	public static Vector<String> findLastWeekT() throws MessagingException {
		Vector<String> result = new Vector<String>();
		Properties props = System.getProperties();
		props.put("mail.smtp.host", "smtp.zju.edu.cn");
		props.put("mail.smtp.auth", "true");
		Session session = Session.getDefaultInstance(props, null);
		URLName urln = new URLName("pop3", "pop3.zju.edu.cn", 110, null,
				"justme", "asdf280050");
		Store store = session.getStore(urln);
		store.connect();
		Folder folder = store.getFolder("INBOX");
		folder.open(Folder.READ_ONLY);
		Message message[] = folder.getMessages();
		System.out.println("Messages's length: " + message.length);
		ReciveOneMail pmm = null;

		for (int i = 0; i < message.length; i = i + 144) {
			// 一天144个点，一周1008个点
			if (i > 1007)
				break;
			pmm = new ReciveOneMail((MimeMessage) message[i]);
			String emailTitle = pmm.getSubject();
			String tempresult = emailTitle.substring(11, 15);
			result.addElement(tempresult);
		}
		return result;
		
	}
	*/
}
