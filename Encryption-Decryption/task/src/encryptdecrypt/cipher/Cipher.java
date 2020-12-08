package encryptdecrypt.cipher;

public class Cipher {
    private CipherStrategy cipherStrategy;

    public Cipher(CipherStrategy cipherStrategy) {
        this.cipherStrategy = cipherStrategy;
    }

    public String execute(final int key, final String input) {
        return this.cipherStrategy.executeCipher(key, input);
    }
}