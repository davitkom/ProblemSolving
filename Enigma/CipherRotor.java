import java.util.*;

class Encryption {
    public String processCommand(String command) {
        return command;
    }
}

public class CipherRotor extends Encryption {

    public final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public final String ROTOR_I = "EKMFLGDQVZNTOWYHXUSPAIBRCJ";
    public final String ROTOR_II = "AJDKSIRUXBLHWTMCQGZNPYFVOE";
    public final String ROTOR_III = "BDFHJLCPRTXVZNYEIWGAKMUSQO";
    public final String ROTOR_IV = "ESOVPZJAYQUIRHXLNFTGKDCMWB";
    public final String ROTOR_V = "VZBRGITYUPSDNHLXAWMJQOFECK";
    public final String REFLECTOR = "YRUHQSLDPXNGOKMIEBFZCWVJAT";

    private String[] Rotors = new String[3];
    private int[] Offsets = new int[3];
    private int[] DefaultOffsets = new int[3];
    private Map<Character, Character> plugboardMap;

    // Constructor
    public CipherRotor() {
        initializeRotors("I II III");
        initializePlugboard("");
        initializeOffsets("AAA");
    }

    void resetOffsets() {
        for (int i = 0; i < 3; i++) {
            Offsets[i] = DefaultOffsets[i];
        }
    }

    public char encryptWithRotation(char letter) {
        ShiftRightRotor(2);
        return encrypt_new(letter);
    }

    public char encrypt_new(char letter) {
        if (!Character.isLetter(letter)) return letter;
        letter = Character.toUpperCase(letter);

        letter = mapThroughRotorWithOffset(letter, Rotors[2], Offsets[2]);
        letter = mapThroughRotorWithOffset(letter, Rotors[1], Offsets[1]);
        letter = mapThroughRotorWithOffset(letter, Rotors[0], Offsets[0]);

        letter = REFLECTOR.charAt(ALPHABET.indexOf(letter));

        letter = getMappedChar(letter);

        letter = mapThroughRotorWithOffset(letter, inverseRotor(Rotors[0]), Offsets[0]);
        letter = mapThroughRotorWithOffset(letter, inverseRotor(Rotors[1]), Offsets[1]);
        letter = mapThroughRotorWithOffset(letter, inverseRotor(Rotors[2]), Offsets[2]);

        letter = getMappedChar(letter);
        return letter;
    }

    public char encrypt(char letter) {
        letter = mapThroughRotorWithOffset(letter, Rotors[2], Offsets[2]);
        letter = mapThroughRotorWithOffset(letter, Rotors[1], Offsets[1]);
        letter = mapThroughRotorWithOffset(letter, Rotors[0], Offsets[0]);
        return letter;
    }

    public char decrypt(char letter) {
        letter = mapThroughRotorWithOffset(letter, inverseRotor(Rotors[0]), Offsets[0]);
        letter = mapThroughRotorWithOffset(letter, inverseRotor(Rotors[1]), Offsets[1]);
        letter = mapThroughRotorWithOffset(letter, inverseRotor(Rotors[2]), Offsets[2]);
        return letter;
    }

    private char mapThroughRotorWithOffset(char letter, String rotor, int offset) {
        int index = (ALPHABET.indexOf(letter) + offset) % 26;
        char mappedLetter = rotor.charAt(index);
        int newIndex = (ALPHABET.indexOf(mappedLetter) - offset + 26) % 26;
        return ALPHABET.charAt(newIndex);
    }

    private String inverseRotor(String rotor) {
        char[] inverseMapping = new char[26];
        for (int i = 0; i < 26; i++) {
            inverseMapping[rotor.charAt(i) - 'A'] = (char) ('A' + i);
        }
        return new String(inverseMapping);
    }

    public static int letterToOffset(char letter) {
        return letter - 'A';
    }

    public char getMappedChar(char input) {
        return plugboardMap.getOrDefault(input, input);
    }

    private void initializePlugboard(String configuration) {
        plugboardMap = new HashMap<>();
        String[] pairs = configuration.split(" ");
        for (String pair : pairs) {
            if (pair.length() == 2) {
                char first = pair.charAt(0);
                char second = pair.charAt(1);
                plugboardMap.put(first, second);
                plugboardMap.put(second, first);
            }
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            plugboardMap.putIfAbsent(c, c);
        }
    }

    private void initializeOffsets(String offsetString) {
        String cleanedString = offsetString.replaceAll("\\s", "");
        if (cleanedString.length() == 3) {
            Offsets[0] = cleanedString.charAt(0) - 'A';
            Offsets[1] = cleanedString.charAt(1) - 'A';
            Offsets[2] = cleanedString.charAt(2) - 'A';
            System.arraycopy(Offsets, 0, DefaultOffsets, 0, 3);
        }
    }

    private void initializeRotors(String rotor_order) {
        String[] tokens = rotor_order.split("\\s+");
        for (int i = 0; i < 3; i++) {
            switch (tokens[i]) {
                case "I" -> Rotors[i] = ROTOR_I;
                case "II" -> Rotors[i] = ROTOR_II;
                case "III" -> Rotors[i] = ROTOR_III;
                case "IV" -> Rotors[i] = ROTOR_IV;
                case "V" -> Rotors[i] = ROTOR_V;
            }
        }
    }

    private void ShiftRightRotor(int rotorIdx) {
        Offsets[2] = (Offsets[2] + 1) % 26;
        if (Offsets[2] == 0) {
            Offsets[1] = (Offsets[1] + 1) % 26;
            if (Offsets[1] == 0) {
                Offsets[0] = (Offsets[0] + 1) % 26;
            }
        }
    }

    private String processCommandE(String command) {
        StringBuilder outputText = new StringBuilder();
        String shifter = command.substring(command.indexOf("E") + 1, command.indexOf(" "));
        String text = command.substring(command.indexOf(" ") + 1);

        if (shifter.length() != 0) {
            Offsets[2] = shifter.charAt(2) - 'A';
            Offsets[1] = shifter.charAt(1) - 'A';
            Offsets[0] = shifter.charAt(0) - 'A';
        }

        if (command.charAt(0) == '>') {
            for (char c : text.toCharArray()) {
                outputText.append(Character.isLetter(c) ? encrypt(c) : c);
            }
        } else if (command.charAt(0) == '<') {
            for (char c : text.toCharArray()) {
                outputText.append(Character.isLetter(c) ? decrypt(c) : c);
            }
        }
        return outputText.toString();
    }

    @Override
    public String processCommand(String command) {
        StringBuilder outputText = new StringBuilder();
        if (command.startsWith("rotors")) {
            String orders = command.substring(command.indexOf("= ") + 1);
            initializeRotors(orders);
        } else if (command.startsWith("plugboard")) {
            String plg = command.substring(command.indexOf("= ") + 1);
            initializePlugboard(plg);
        } else if (command.startsWith("offset")) {
            String offsets = command.substring(command.indexOf("= ") + 1);
            initializeOffsets(offsets);
        } else if (command.contains("<E") || command.contains(">E")) {
            outputText.append(processCommandE(command));
        } else if (command.length() == 1) {
            char encrypted = encryptWithRotation(command.charAt(0));
            outputText.append(encrypted);
        }
        return outputText.toString();
    }

    public static void main(String[] args) {
        CipherRotor enigma = new CipherRotor();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enigma Cipher Simulator");
        System.out.println("Type a single letter or '>EAAA HELLO' to encrypt.");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.equals("EXIT")) break;
            System.out.println(enigma.processCommand(input));
        }

        scanner.close();
    }
}