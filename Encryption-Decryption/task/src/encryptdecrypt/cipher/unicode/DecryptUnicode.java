package encryptdecrypt.cipher.unicode;

import encryptdecrypt.cipher.CipherStrategy;

public class DecryptUnicode implements CipherStrategy {

    @Override
    public final String executeCipher(final int key, final String input) {
        final StringBuilder decryptedText = new StringBuilder();
        for (char letter : input.toCharArray()) {
            final int shiftKey = letter - key;
            char decryptedLetter = (char) shiftKey;
            decryptedText.append(decryptedLetter);
        }
        return decryptedText.toString();
    }
}
