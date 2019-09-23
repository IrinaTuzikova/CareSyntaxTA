package ebay.helpers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileReadAndWriteHelper {


    public static String getAbsolutePathByFileName(String path, String fileName) {
        return findFileByPathAndNameRecursively(path, fileName).getAbsolutePath();
    }

    public static File findFileByPathAndNameRecursively(String path, String fileName) {
        File file = new File(path);
        if (fileName.equalsIgnoreCase(file.getName())) return file;
        if (file.isDirectory()) {
            for (String aChild : file.list()) {
                File foundFile = findFileByPathAndNameRecursively(path + File.separator + aChild, fileName);
                if (foundFile != null) return foundFile;
            }
        }
        return null;
    }

    public static void writeUserDetailsToTheFileWithName(String fileName, String infoToWrite) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print("Some String");
        printWriter.printf("Info :: " + infoToWrite);
        printWriter.close();
    }
}
