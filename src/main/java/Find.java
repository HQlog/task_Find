import org.jetbrains.annotations.NotNull;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.File;
import java.io.IOException;

public class Find {

    static StringBuilder result = new StringBuilder();



    @Option(name = "-r")
    public boolean r;

    @Option(name = "-d")
    public String directory;

    @Argument (required = true)
    public static String fileName;

     void workWithArguments(String[] args) throws IOException {

        CmdLineParser parser = new CmdLineParser(this);

        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            throw new IllegalArgumentException("kjhgfxgfj");
        }

        if (fileName == null) throw new IOException("YourArgumentsIsEmpty");
        if (directory.isEmpty()) throw new IOException("DirectoryIsIncorrect");







        if (r) findFiles(directory, fileName);
        else findFilesWithoutR(directory, fileName);


    }


    private void findFiles(String directory, String name) {
        File file = new File(directory);
        isDir(file, name);
    }

    private void findFilesWithoutR(String file, String name) {

        File directory = new File(file);

        if (directory.exists()) {
            if (directory.isDirectory()) {

                File[] listFiles = directory.listFiles();

                assert listFiles != null;

                if (listFiles.length == 0) {
                    result.append(directory).append(" не содержит файлов");
                } else for (File f : listFiles) {
                    if (f.getName().equals(name)){
                        result.append("Файл: ").append(directory).append("\\").append(f.getName());
                    return;}
                }
                result.append("Файл не найден");
            }
        } else result.append(directory).append(" не существует");

    }

    private void isDir(@NotNull File directory, String name) {
        if (directory.exists()) {
            if (directory.isDirectory()) {

                File[] listFiles = directory.listFiles();

                assert listFiles != null;

                if (listFiles.length == 0) result.append(directory).append(" не содержит файлов");

                else for (File f : listFiles) {
                    isDir(f, name);
                    if (f.getName().equals(name))
                        result.append("Файл: ").append(directory).append("\\").append(f.getName());
                }
            }
        } else result.append(directory).append(" не существует");
    }

    public static void main(String[] args) throws IOException {
        new Find().workWithArguments(args);
        for (String s : args) {System.out.print(s);}
        System.out.print("\n");
        System.out.print("file = ");
        System.out.println(fileName);

        System.out.println("asdadasd");
        System.out.println(result);
    }

}
