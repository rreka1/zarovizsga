package hu.nive.ujratervezes.zarovizsga.digitscounter;

import java.util.Set;
import java.util.TreeSet;

public class DigitsCounter {

    public int getCountOfDigits(String s) {
        if (s == null || s.isEmpty() || s.isBlank()) {
            return 0;
        }
        Set<Character> digits = new TreeSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                digits.add(s.charAt(i));
            }
        }
        return digits.size();
    }
}
