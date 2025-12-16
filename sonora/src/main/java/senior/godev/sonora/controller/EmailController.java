package senior.godev.sonora.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import senior.godev.sonora.utils.mail.Email;
import senior.godev.sonora.utils.mail.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public void sendEmail(@RequestBody Email email) {
        emailService.send(email);
    }
}
