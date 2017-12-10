import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

public class MailTest {

	@Autowired private JavaMailSenderImpl mailSender;

	@Test
	public void sendMail() {

		final MimeMessagePreparator preparator = new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {

				final MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

				helper.setFrom("lsylsy289@gmail.com");
				helper.setTo("lsylsy289@naver.com");
				helper.setSubject("테스트!!");
				helper.setText("오늘은 좋은 날 입니다. 활짝 웃어봐요~", true);
			}
		};

		mailSender.send(preparator);
	}
}
