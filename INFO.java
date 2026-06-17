import java.io.File;

class INFO {
    static String loc = "";
    static String currentFolder = "";
    static java.awt.Image icon;

    INFO() {
    }

    public static void changeCurrentFolder(String paramString) {
        currentFolder = paramString;
        try {
            File localFile = new File("loc.info");
            localFile.delete();
            localFile = new File("loc.info");
            localFile.createNewFile();
            java.io.FileWriter localFileWriter = new java.io.FileWriter(localFile, false);
            localFileWriter.write(paramString);
            localFileWriter.close();
        } catch (Exception localException) {
        }
    }
}
