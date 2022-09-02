package kr.kro.srvrstudy.srvr_auth.common.encryption;

import org.passay.CharacterCharacteristicsRule;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.LengthRule;
import org.passay.PasswordData;

import java.util.ArrayList;
import java.util.List;

public class PasswordValidator {

    private static final CharacterCharacteristicsRule characterCharacteristicsRule;

    static {
        List<CharacterRule> rules = new ArrayList<>();

//        rules.add(new LengthRule(8, 16));
        rules.add(new CharacterRule(EnglishCharacterData.Digit, 1));
        rules.add(new CharacterRule(EnglishCharacterData.Alphabetical, 1));
        rules.add(new CharacterRule(EnglishCharacterData.Special, 1));

        characterCharacteristicsRule = new CharacterCharacteristicsRule(rules);
    }

    private PasswordValidator() {
        throw new AssertionError("PasswordValidator can't be initiate");
    }

    public static boolean validPassword(PasswordData passwordData) {
        return characterCharacteristicsRule.validate(passwordData).isValid();
    }
}
