package id.co.jasindo.mailservices.controller;

import id.co.jasindo.mailservices.EmailCfg;
import id.co.jasindo.mailservices.entity.Mailer;
import id.co.jasindo.mailservices.repos.MailerRepository;
import id.co.jasindo.mailservices.response.GeneralResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(path = "mailer")
public class MailController {
    @Autowired
    MailerRepository mailerRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private EmailCfg emailCfg;

    @GetMapping("/all")
    public GeneralResponse getMails(){
        return new GeneralResponse<>(
            200,
                "success",
                mailerRepository.findAll()
        );
    }
    @GetMapping
    public GeneralResponse getDataByNoDokumen(@RequestParam List<String> noDokumen){
        return new GeneralResponse<>(
                200,
                "success ",
                mailerRepository.findByNoDokumen(noDokumen)
        );
    }
    @PostMapping
    public GeneralResponse addMail(@RequestBody Mailer mail){
        GeneralResponse response = new GeneralResponse();

        Mailer i = new Mailer();
        Date getDate = new Date();
//        String regex = "^(.+)@(.+)$";

            i.setNoDokumen(mail.getNoDokumen());
            i.setSumber(mail.getSumber());
            i.setPengirim(emailCfg.getUsername());
            i.setPenerima(mail.getPenerima());
            i.setBody(mail.getBody());
            i.setSubjek(mail.getSubjek());
            i.setIsAuto(mail.getIsAuto());
            i.setStatus(mail.getStatus());
            i.setCreatedDate(getDate);
            i.setLastUpdate(getDate);

        try {
            if(mail.getIsAuto() == 1) {
                JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
                mailSender.setHost(emailCfg.getHost());
                mailSender.setPort(emailCfg.getPort());
                mailSender.setUsername(emailCfg.getUsername());
                mailSender.setPassword(emailCfg.getPassword());

                SimpleMailMessage msg = new SimpleMailMessage();
                msg.setFrom(emailCfg.getUsername());
                msg.setText(mail.getBody());
                msg.setTo(mail.getPenerima());
                msg.setSubject(mail.getSubjek());

                javaMailSender.send(msg);
            }
        }
        catch (MailException ex) {
            i.setErrorLog(ex.getMessage());
//            System.err.println(ex.getMessage());
        }
        mailerRepository.save(i);

        response.setMessage("success");
        response.setData(i);

        return response;
    }

    @PutMapping
    public GeneralResponse addEmail(@PathVariable int id,@RequestBody Mailer mail) {
        return new GeneralResponse<>(
                200,
                "success",
                mailerRepository.findById(id).map(i -> {
                    Date getDate = new Date();
                    i.setNoDokumen(mail.getNoDokumen());
                    i.setSumber(mail.getSumber());
                    i.setPengirim(mail.getPengirim());
                    i.setPenerima(mail.getPenerima());
                    i.setBody(mail.getBody());
                    i.setIsAuto(mail.getIsAuto());
                    i.setStatus(mail.getStatus());
                    i.setErrorLog(mail.getErrorLog());
                    i.setCreatedDate(getDate);
                    i.setLastUpdate(getDate);
                    return mailerRepository.save(i);
                })
        );
    }
}
