package r2s.training.utils;

public class Constants {
    public static boolean checkFormatNumber(String number) {
        String reg = "^(\\d{10})$";
        return number.matches(reg);
    }
}
