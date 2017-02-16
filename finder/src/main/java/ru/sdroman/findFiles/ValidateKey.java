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
        Param param = new Param(this.args);

        if (param.getLength() != length || "-help".equalsIgnoreCase(param.getDirKey())) {
            help();
            isValid = false;
        } else {
            if (!"-d".equalsIgnoreCase(param.getDirKey())
                    || !"-n".equalsIgnoreCase(param.getFileNameKey())
                    || !"-o".equalsIgnoreCase(param.getLogKey())
                    || (!"-m".equalsIgnoreCase(param.getFindKey())
                    && !"-r".equalsIgnoreCase(param.getFindKey())
                    && !"-f".equalsIgnoreCase(param.getFindKey()))) {
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
