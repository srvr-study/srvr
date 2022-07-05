package kr.kro.srvrstudy.srvr_auth.common.encryption;

import org.apache.tomcat.util.codec.binary.Base64;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class SHA256 {

    private static final String ALGORITHM = "SHA3-256";
    private static MessageDigest md;

    static {
        try {
            md = MessageDigest.getInstance(ALGORITHM);
        } catch (Exception ignored) {

        }
    }

    private SHA256() {
        throw new AssertionError("SHA256 can't be initiated");
    }

    public static String encrypt(String password, String salt) {
        String baseStr = password + salt;
        md.update(baseStr.getBytes(StandardCharsets.UTF_8));
        return Base64.encodeBase64String(md.digest());
    }
}
