package kr.kro.srvrstudy.srvr_auth.domain.service;


import kr.kro.srvrstudy.srvr_common.exception.ApiFailureException;
import kr.kro.srvrstudy.srvr_common.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class MailService {

    private final JavaMailSender javaMailSender;

    public void sendCodeMail(String email, String verificationCode) {

        try {
            final SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject("인증메일입니다.");
            message.setText("<p>" + "인증 코드 " + verificationCode + "</p>");

            javaMailSender.send(message);
        } catch (Exception e) {
            log.warn("[auth] sendCodeMail : 메일 전송 실패 {}", email);
            throw new ApiFailureException(ErrorCode.FAILED_TO_SEND_MAIL);
        }
    }


}
