package mailEngine;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import connection.ReadFileProperties;

public class MailSenda {
	public static boolean sendEmail(String receiver, String subject, String context) {
		ReadFileProperties propertiesLibrary = new ReadFileProperties();
		Properties properties1 = propertiesLibrary.readFileProperties();

		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		SMTPAuthenticator auth = new SMTPAuthenticator();

		Session mailSession = Session.getInstance(properties, auth);

		MimeMessage message = new MimeMessage(mailSession);
		try {
			message.setSubject(subject);
			message.setFrom(new InternetAddress(properties1.getProperty("email")));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiver));
			message.setText(context);

			Transport.send(message);
			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
	}
	public static void main(String[] args) {
		System.out.println(sendEmail("lehanhtri287@gmail.com", "testing", "hello motherfucker"));
	}
	
}
