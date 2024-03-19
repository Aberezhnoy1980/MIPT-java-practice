package ru.aberezhnoy;

public class OwnExceptions {
    public static void main(String[] args) {
        System.out.println(sameLength("Ivanov"));
    }

    public static boolean sameLength(String text) {
        String[] parts = text.split(" ");
        if (parts.length != 2) {
            throw new NameFormatException(text);
        }
        return parts[0].length() == parts[1].length();
    }
}

class NameFormatException extends ArrayIndexOutOfBoundsException {
    public NameFormatException(String text) {
        super("Incorrect name input: " + text);
    }
}
