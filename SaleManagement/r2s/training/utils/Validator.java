package r2s.training.utils;

public class Validator {
    public static boolean checkFormatPhone(String phone) {
        String reg = "^(0|\\+84)(\\d{9})$";
        return phone.matches(reg);
    }
}
