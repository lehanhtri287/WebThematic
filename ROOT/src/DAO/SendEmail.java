package DAO;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.text.html.MinimalHTMLWriter;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SendEmail {
	public static void sendEmail(String subject, String context, String receivedEmail) {
		try {
			Email email = new SimpleEmail();

			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("kaitoukid287@gmail.com", "ANHyeuem287"));

			email.setSSLOnConnect(true);
			email.setFrom("kaitoukid287@gmail.com");
			email.setSubject(subject);
			email.setMsg(context);

			email.addTo(receivedEmail);
			email.send();
			System.out.println("Done motherfucker!");
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void sendEmail1(String subject, String context, String receivedEmail) {
		String from = "kaitoukid287@gmail.com";
		String host = "localhost";

		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);

		Session session = Session.getDefaultInstance(properties);
		
		try {
			MimeMessage mimeMessage = new MimeMessage(session);
			mimeMessage.setFrom(new InternetAddress(from));
			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(receivedEmail));
			mimeMessage.setSubject(subject);
			mimeMessage.setText(context);
			
			Transport.send(mimeMessage);
			System.out.println("Done!");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		sendEmail1("test email", "Hello myself", "lehanhtri287@gmail.com");
	}
}
