package contacts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Action {
    ADD("add"),
    REMOVE("remove"),
    EDIT("edit"),
    COUNT("count"),
    LIST("list"),
    EXIT("exit");

    private final String action;


    Action(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public static boolean checkValidityPhoneNumber(String number) {
        return checkValidity(number);
    }

    private static boolean checkValidity(String number) {
        String[] strArr = number.split("[\\s-]");
        boolean checkParentheses = true;
        boolean checkSymbols = true;
        int countParentheses = 0;

        for (int i = 0; i < strArr.length; i++) {
            Pattern p = Pattern.compile("^\\+?\\(\\+?\\w+\\)$", Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(strArr[i]);
            if (m.find()) {
                if (i > 1) {
                    checkParentheses = false;
                } else {
                    countParentheses++;
                }
            } else {
                if (i == 0) {
                    checkSymbols = strArr[i].matches("^\\+?\\w+$");
                } else {
                    checkSymbols = strArr[i].matches("^\\w{2,}$");
                }
                if (!checkSymbols) {
                    break;
                }
            }
        }
        return checkParentheses && countParentheses < 2 && checkSymbols;
    }
}
