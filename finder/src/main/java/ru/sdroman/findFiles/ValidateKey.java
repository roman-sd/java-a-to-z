package ru.sdroman.findFiles;

/**
 * Class ValidateKey.
 *
 * @author sdroman
 * @version 0.1
 * @since 13.02.17
 */
public class ValidateKey {

    /**
     * Array of keys.
     */
    private String[] args;

    /**
     * Constructs the new ValidateKey objects.
     *
     * @param args String[]
     */
    public ValidateKey(String[] args) {
        this.args = args;
    }

    /**
     * Check keys.
     *
     * @return boolean
     */
    public boolean valid() {
        boolean isValid = true;
        final int length = 7;
        final int one = 0;
        final int two = 2;
        final int four = 4;
        final int five = 5;
        if (this.args.length != length || "-help".equalsIgnoreCase(this.args[0])) {
            help();
            isValid = false;
        } else {
            if (!"-d".equalsIgnoreCase(this.args[0])
                    || !"-d".equalsIgnoreCase(this.args[one])
                    || !"-n".equalsIgnoreCase(this.args[two])
                    || !"-o".equalsIgnoreCase(this.args[five])
                    || (!"-m".equalsIgnoreCase(this.args[four])
                    && !"-r".equalsIgnoreCase(this.args[four])
                    && !"-f".equalsIgnoreCase(this.args[four]))) {
                System.out.println("no valid key.");
                isValid = false;
            }
        }
        return isValid;
    }

    /**
     * Help.
     */
    private void help() {
        System.out.println(String.format("%s", "Ключи: "));
        System.out.println(String.format("%s\t%32s", "-d", "директория начала поиска."));
        System.out.println(String.format("%s\t%50s", "-n", "имя файл, маска, либо регулярное выражение."));
        System.out.println(String.format("%s\t%78s", "-m", "искать по маске; -f - полное совпадение имени; -r регулярное выражение."));
        System.out.println(String.format("%s\t%33s", "-o", "результат записать в файл."));
        System.out.println(String.format("%s\t%11s", "-help", "справка."));
        System.out.println(String.format("%s\t%51s", "пример:", "java -jar find.jar -d c:/ -n *.txt -m -o log.txt"));
    }
}
