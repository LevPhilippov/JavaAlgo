import java.io.File;

public class FileTest {

    public static void main(String[] args) {
        File destFile = new File("/home/levphilippov/Документы/IdeaProjects");
        showDirs(" ",destFile);
    }

    public static void showDirs(String prefix, File file) {

        if(file.isFile()) {
            System.out.println(prefix + " " + "File: " + file);
            return;
        }

        System.out.println(prefix + "  " + "Dir: " + file);

        File[] files = file.listFiles();

        for (File o:files) {
            showDirs(prefix + " " , o);
        }

    }
}