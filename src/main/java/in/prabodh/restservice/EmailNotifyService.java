package in.prabodh.restservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailNotifyService {

    private static final Logger logger = LoggerFactory.getLogger(EmailNotifyService.class);

    @Autowired
    private JavaMailSenderImpl mailSender;


    public boolean sendTxtMail(String from, String[] to, String subject, String message) {
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(from);
            simpleMailMessage.setTo(to);
            simpleMailMessage.setSubject(subject);
            simpleMailMessage.setText(message);

            mailSender.send(simpleMailMessage);
            logger.info("Message has been sent:[{}]", message);
            return true;
        } catch (Exception e) {
            logger.info("Mail sending failed: [{}]", message, e);
            return false;
        }
    }

    /**
     * Send emails with attachments
     *
     * @param to      accept address
     * @param subject theme
     * @param message content of email
     */
    public boolean sendAttchMail(String from, String[] to, String subject, String message, String file) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            //The following method is very important. If you need to add attachments to pass, remember to enable multipart to true
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(message);

            //Add attachments
            FileSystemResource fileSystemResource = new FileSystemResource(new File("/Users/Rama Munjam/Downloads/testMail/testMail/sanctionLetterAttachmentTemplate.pdf"));
            helper.addAttachment("sanctionLetterAttachmentTemplate.pdf", fileSystemResource);
           /*File file1 = new File("/Users/Rama Munjam/Downloads/testMail/testMail/sanctionLetterAttachmentTemplate.pdf");
            PDDocument doc = PDDocument.load(file1);
            PDPage page = doc.getPage(0);

           PDImageXObject pdImage = PDImageXObject.createFromFile("C:\\Users\\Rama Munjam\\Downloads\\testMail\\testMail\\src\\main\\resources\\testimage.jpeg", doc);
            PDPageContentStream contents = new PDPageContentStream(doc, page);
            contents.drawImage(pdImage, 200, 300);
            System.out.println("Image inserted");

            //Closing the PDPageContentStream object
            contents.close();
            PDPage pages=new PDPage();
            //doc.addPage(pages);
            doc.removePage(3);
            //System.out.println("page added sucessfully");
            //Saving the document
            doc.save("/Users/Rama Munjam/Downloads/testMail/testMail/sanctionLetterAttachmentTemplate.pdf");

            //Closing the document
            doc.close();*/

            mailSender.send(mimeMessage);
            logger.info("Attachment message sent: [{}]", message);
            return true;
        } catch (Exception e) {
            logger.info("Attachment email failed to send: [{}]", message, e);
            return false;
        }

    }


   /* public boolean sendHtmlMailWithAttachement(String from, String[] to, String subject, String fileContent, String attachmentFileName, Object message) {
        try {
            FileSystemResource fileSystemResource = new FileSystemResource(new File("/Users/Rama Munjam/Downloads/Student_Manual-_LMS_01.pdf"));
            Document document = Jsoup.parse(f, "UTF-8");

            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(message, "text/html");

            helper.setText(document.html(), true); // Use this or above line.
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setFrom(from);

            mailSender.send(mimeMessage);

        } catch (URISyntaxException | IOException | MessagingException e) {
            e.printStackTrace();
        }
        return true;
    }*/



    public boolean sendHtmlMail(String from, String[] to, String subject, String content) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

            helper.setText(content, true); // Use this or above line.
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setFrom(from);
            mailSender.send(mimeMessage);

        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public boolean sendAttchImageMail(String from, String[] to, String subject, String message, String file) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            //The following method is very important. If you need to add attachments to pass, remember to enable multipart to true
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(message);

            //Add attachments
            FileSystemResource fileSystemResource = new FileSystemResource(new File("C:\\Users\\Rama Munjam\\Downloads\\testMail\\testMail\\src\\main\\resources\\testimage.jpeg"));
            helper.addAttachment("Images/testimage.jpeg", fileSystemResource);
            mailSender.send(mimeMessage);
            logger.info("Attachment message sent: [{}]", message);
            return true;
        } catch (Exception e) {
            logger.info("Attachment email failed to send: [{}]", message, e);
            return false;
        }
    }

}