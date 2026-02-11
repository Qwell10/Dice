package service;

public class Validation {

    public boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isWithinRange(int input) {
        return input > 0 && input <= 6;
    }
}
