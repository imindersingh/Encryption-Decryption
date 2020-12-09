package encryptdecrypt.utils;

public enum Argument {
    ALGORITHM("-alg"),
    MODE("-mode"),
    KEY("-key"),
    DATA("-data"),
    INPUT("-in"),
    OUT("-out"),
    ENCRYPT("enc"),
    DECRYPT("dec"),
    SHIFT("shift"),
    UNICODE("unicode");

    private String argument;

    Argument(final String argument) {
        this.argument = argument;
    }

    public String get() {
        return argument;
    }
}
