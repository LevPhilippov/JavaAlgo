import java.io.File;

public class FileTest {

    public static void main(String[] args) {
        File destFile = new File("C:\\Users\\filip\\IdeaProjects");
        showDirs(" ",destFile);
    }

    public static void showDirs(String prefix, File file) {
        if(file.isFile()) {
            System.out.println(prefix + " " + "File: " + file.getName());
            return;
        }
        System.out.println(prefix + "  " + "Dir: " + file.getName());
        File[] files = file.listFiles();
        for (File f:files) {
            showDirs(prefix + " " , f);
        }
    }
}