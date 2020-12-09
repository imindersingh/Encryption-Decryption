package encryptdecrypt;

import encryptdecrypt.cipher.Cipher;
import encryptdecrypt.cipher.shift.DecryptShift;
import encryptdecrypt.cipher.shift.EncryptShift;
import encryptdecrypt.cipher.unicode.DecryptUnicode;
import encryptdecrypt.cipher.unicode.EncryptUnicode;
import encryptdecrypt.utils.Argument;
import encryptdecrypt.utils.FileReaderWriter;

import static encryptdecrypt.utils.Argument.ALGORITHM;
import static encryptdecrypt.utils.Argument.DATA;
import static encryptdecrypt.utils.Argument.DECRYPT;
import static encryptdecrypt.utils.Argument.ENCRYPT;
import static encryptdecrypt.utils.Argument.INPUT;
import static encryptdecrypt.utils.Argument.KEY;
import static encryptdecrypt.utils.Argument.MODE;
import static encryptdecrypt.utils.Argument.OUT;
import static encryptdecrypt.utils.Argument.SHIFT;
import static encryptdecrypt.utils.Argument.UNICODE;

public class Main {
    private static String algorithm = Argument.SHIFT.get();
    private static String mode = Argument.ENCRYPT.get();
    private static String inputData = "";
    private static int key;
    private static boolean isOutputFile;
    private static boolean isInputFile;
    private static String outputFilename = "";
    private static String inputFilename = "";

    private static FileReaderWriter fileReaderWriter = new FileReaderWriter();

    public static void main(final String[] args) {

        setArguments(args);

        Cipher cipher;

        if (mode.equalsIgnoreCase(ENCRYPT.get())
                && algorithm.equalsIgnoreCase(SHIFT.get())) {
            cipher = new Cipher(new EncryptShift());
            writeOutput(cipher.execute(key, inputData));
        } else if (mode.equalsIgnoreCase(ENCRYPT.get())
                && algorithm.equalsIgnoreCase(UNICODE.get())) {
            cipher = new Cipher(new EncryptUnicode());
            writeOutput(cipher.execute(key, inputData));
        } else if (mode.equalsIgnoreCase(DECRYPT.get())
                && algorithm.equalsIgnoreCase(SHIFT.get())) {
            cipher = new Cipher(new DecryptShift());
            writeOutput(cipher.execute(key, inputData));
        } else if (mode.equalsIgnoreCase(DECRYPT.get())
                && algorithm.equalsIgnoreCase(UNICODE.get())) {
            cipher = new Cipher(new DecryptUnicode());
            writeOutput(cipher.execute(key, inputData));
        } else {
            throw new RuntimeException("Error: could not recognise mode");
        }
    }

    private static void setArguments(final String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals(MODE.get())) {
                mode = args[i + 1];
            }
            if (args[i].equals(KEY.get())) {
                key = Integer.parseInt(args[i + 1]);
            }
            if (args[i].equals(DATA.get())) {
                inputData = args[i + 1];
            }
            if (args[i].equals(INPUT.get())) {
                isInputFile = true;
                inputFilename = args[i + 1];
            }
            if (args[i].equals(OUT.get())) {
                outputFilename = args[i + 1];
                isOutputFile = true;
            }
            if (args[i].equals(ALGORITHM.get())) {
                algorithm = args[i + 1];
            }
        }

        if (isInputFile) {
            inputData = fileReaderWriter.readFile(inputFilename);
        }
    }

    private static void writeOutput(final String data) {
        if (isOutputFile) {
            fileReaderWriter.writeToFile(outputFilename, data);
        } else {
            System.out.println(data);
        }
    }

}
