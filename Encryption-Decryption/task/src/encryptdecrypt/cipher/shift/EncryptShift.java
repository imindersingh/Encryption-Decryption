package encryptdecrypt.cipher.shift;

import encryptdecrypt.cipher.CipherStrategy;

public class EncryptShift implements CipherStrategy {

    @Override
    public final String executeCipher(final int key, final String input) {
        StringBuilder encryptedText = new StringBuilder();
        char letter;
        for (int i = 0; i < input.toCharArray().length; i++) {
            letter = input.charAt(i);
            if (letter >= UPPERCASE_A && letter <= UPPERCASE_Z) {
                letter = (char) ((letter - UPPERCASE_A + key) % ALPHABET_LENGTH + UPPERCASE_Z);
            } else if (letter >= LOWERCASE_A && letter <= LOWERCASE_Z) {
                letter = (char) ((letter - LOWERCASE_A + key) % ALPHABET_LENGTH + LOWERCASE_A);
            }

            encryptedText.append(letter);
        }
        return encryptedText.toString();
    }
}
