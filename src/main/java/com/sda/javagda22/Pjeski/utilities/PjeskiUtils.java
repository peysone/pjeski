package com.sda.javagda22.Pjeski.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PjeskiUtils {
    public static boolean checkEmailOrPassword(String pattern, String pStr) {

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(pStr);
        return m.matches();
    }
}
