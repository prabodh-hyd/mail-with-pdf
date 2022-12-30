package in.prabodh.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	@Autowired
	EmailNotifyService emailService;


	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		Logger LOGGER = LogManager.getLogger(GreetingController.class);

		LOGGER.info("Info level log message");
		LOGGER.debug("Debug level log message");
		LOGGER.error("Error level log message");

		String[] toList = new String[]{"ramanaresh.munjam@gmail.com"};
		//support@softspintech.com
		String content = "<!DOCTYPE html>\n" +
				"<html lang=\"en\">\n" +
				"    <head>\n" +
				"        <meta charset=\"UTF-8\">\n" +
				"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
				"        <title>Sanction Letter PDF</title>\n" +
				"        <link rel=\"stylesheet\" href=\"./style/loanAgreementCoine.css\">\n" +
				"        <script src=\"https://code.jquery.com/jquery-3.6.1.min.js\" integrity=\"sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=\" crossorigin=\"anonymous\"></script>\n" +
				"    </head>\n" +
				"    <body>\n" +
				"        <div class=\"userRepay\">\n" +
				"            <p>Dear <i>user_name_variable</i>,</p>\n" +
				"            <p>Your Coine loan application has been Sanctioned.</p>\n" +
				"            <p>Loan ID: <i>loan_app_id</i></p>\n" +
				"\n" +
				"            <p>Please find complete details of your loan at this <a href=\"https://repayment.softlend.in/factstatement.html?loan_app_id=11111\">link</a>.</p>\n" +
				"\n" +
				"            <p><b>Repay your loan in time and <br />get eligibility for higher<br /> amounts</b></p>\n" +
				"            <p>Failure of loan repayment in <br/> time will affect your CIBIL<br/> score.</p>\n" +
				"            <p>Loans are processed by <br/>NBFC Apollo Finvest.</p>\n" +
				"        </div>\n" +
				"    </body>\n" +
				"</html> ";
		emailService.sendTxtMail(
				"support@coine.ai", toList, "test mail", "hello world !!");
		//emailService.sendHtmlMail("support@coine.ai", toList, "html mail",content);
		//emailService.sendHtmlMailWithAttachement("support@coine.ai",toList,"html mail with attachment","Hi..please find the below attachment","sanctionLetterEmailTemplate.html", "hello..");
		emailService.sendAttchMail("support@coine.ai", toList, "test mail with attachment", "Hi..please find the below attachment", "sanctionLetterAttachmentTemplate.pdf");
		//emailService.sendAttchImageMail("support@coine.ai",toList,"testmailimage","Hi.....", "testimage.jpeg");
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@GetMapping("/template")
	public TemplateResponse updateTemplate(@RequestParam(value = "name", defaultValue = "World") String name) {

		docx d = new docx();

		try {
			d.createPDF(null);

		} catch (Exception e) {
			e.printStackTrace();
		}

		TemplateResponse t = new TemplateResponse();
		t.setMessage("Success");

		return t;
	}

	@PutMapping("/createPdf1")
	public Employee  createPdf1(@RequestBody Employee employee){
		docx d1=new docx();

		d1.createPDF(employee);


		return d1.updateEmployee(employee);
	}


}