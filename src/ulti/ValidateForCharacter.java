package ulti;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateForCharacter {
    private static Pattern pattern;
    private static final String NAME_REGEX = "^([A-Z][a-z]*(\s))+[A-Z][a-z]*$";
    private static final String AGE_REGEX = "\\d+$";
    public static boolean validate(String input, String regexPattern){
        switch (regexPattern){
            case "NAME":
                pattern = Pattern.compile(NAME_REGEX);
                break;
            case "AGE":
                pattern = Pattern.compile(AGE_REGEX);
                break;
        }
        Matcher matcher = pattern.matcher(input);
        return !matcher.matches();
    }

}
