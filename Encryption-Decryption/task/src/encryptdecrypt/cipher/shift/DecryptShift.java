package encryptdecrypt.cipher.shift;

import encryptdecrypt.cipher.CipherStrategy;

public class DecryptShift implements CipherStrategy {

    @Override
    public final String executeCipher(final int key, final String input) {
        StringBuilder decryptedText = new StringBuilder();
        char letter;
        for (int i = 0; i < input.toCharArray().length; i++) {
            letter = input.charAt(i);
            if (letter >= UPPERCASE_A && letter <= UPPERCASE_Z) {
                letter = (char) ((letter - UPPERCASE_A + (ALPHABET_LENGTH - key)) % ALPHABET_LENGTH + UPPERCASE_A);
            } else if (letter >= LOWERCASE_A && letter <= LOWERCASE_Z) {
                letter = (char) ((letter - LOWERCASE_A + (ALPHABET_LENGTH - key)) % ALPHABET_LENGTH + LOWERCASE_A);
            }

            decryptedText.append(letter);
        }
        return decryptedText.toString();
    }
}
