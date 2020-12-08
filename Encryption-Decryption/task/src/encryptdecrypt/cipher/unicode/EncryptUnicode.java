package encryptdecrypt.cipher.unicode;

import encryptdecrypt.cipher.CipherStrategy;

public class EncryptUnicode implements CipherStrategy {

    @Override
    public final String executeCipher(final int key, final String input) {
        final StringBuilder encryptedText = new StringBuilder();
        for (char letter : input.toCharArray()) {
            final int shiftKey = letter + key;
            char encryptedLetter = (char) shiftKey;
            encryptedText.append(encryptedLetter);
        }
        return encryptedText.toString();
    }
}
