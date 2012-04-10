/****************************************************************************************
 *  TestMailHelper.java
 *
 *  Created: Jul 9, 2010
 *
 *  @author DRAND
 *
 *  (C) Copyright MITRE Corporation 2010
 *
 *  The program is provided "as is" without any warranty express or implied, including
 *  the warranty of non-infringement and the implied warranties of merchantibility and
 *  fitness for a particular purpose.  The Copyright owner will not be liable for any
 *  damages suffered by you as a result of using the Program.  In no event will the
 *  Copyright owner be liable for any special, indirect or consequential damages or
 *  lost profits even if the Copyright owner has been advised of the possibility of
 *  their occurrence.
 *
 ***************************************************************************************/
package org.mitre.openid.connect.repository.db;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/org/mitre/openid/connect/repository/db/mail-helper.xml" })
public class TestMailHelper {
	@Resource
	private MailSender helper; 
	
	@Test
	public void testSendMail() throws Exception {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("drand@mitre.org");
		message.setSubject("Password reset message");
		message.setFrom("nospam-unattended@mitre.org");
		message.setText("<a href=\"http://mm152600:8180/login/reset?username=drand&" +
				"confirmation=123124125161612412512512341231231254125\">Click here to reset your Transfusion password.</a>");
		helper.send(message);
	}
}
