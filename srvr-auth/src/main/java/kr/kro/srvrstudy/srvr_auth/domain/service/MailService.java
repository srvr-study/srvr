package kr.kro.srvrstudy.srvr_auth.domain.service;


import kr.kro.srvrstudy.srvr_common.exception.ApiFailureException;
import kr.kro.srvrstudy.srvr_common.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.InternetAddressEditor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


@Service
@RequiredArgsConstructor
@Slf4j
public class MailService {

    private final JavaMailSender javaMailSender;

    public void sendCodeMail(String email, String verificationCode) {

        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");

            InternetAddress recipient = new InternetAddress(email);
            helper.setFrom(recipient);
            helper.setSubject("[SRVR] 비밀번호 찾기 메일입니다");
            helper.setText("<p>" + "인증 코드 " + verificationCode + "</p>", true);

            javaMailSender.send(message);
        } catch (Exception e) {
            log.warn("[auth] sendCodeMail : 메일 전송 실패 {}", email);
            throw new ApiFailureException(ErrorCode.FAILED_TO_SEND_MAIL);
        }
    }


}
