package encryptdecrypt.cipher;

public interface CipherStrategy {

    char UPPERCASE_A = 'A';
    char LOWERCASE_A = 'a';
    char LOWERCASE_Z = 'z';
    char UPPERCASE_Z = 'Z';
    int ALPHABET_LENGTH = 26;

    String executeCipher(int key, String input);
}
