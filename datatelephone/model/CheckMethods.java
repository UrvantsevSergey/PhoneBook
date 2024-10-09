package datatelephone.model;

public class CheckMethods {
    public boolean checkString (String str) {
        String[] st = str.split("");
        for (String s : st) {
            if (!Character.isLetter(s.charAt(0))) {
                return false;
            }
        }
        return true;
    }
}
