import java.io.File;

class loadCurrentFolder {
    loadCurrentFolder() {
    }

    public static void load() {
        try {
            File localFile = new File("loc.info");
            java.io.FileReader localFileReader = new java.io.FileReader(localFile);
            java.io.BufferedReader localBufferedReader = new java.io.BufferedReader(localFileReader);
            String str = localBufferedReader.readLine();
            localFileReader.close();
            localBufferedReader.close();
            if ((str == null) || (!new File(str).exists())) {
                INFO.currentFolder = System.getProperty("user.dir");
                try {
                    java.io.FileWriter localFileWriter = new java.io.FileWriter(localFile);
                    localFileWriter.write(INFO.currentFolder);
                    localFileWriter.close();

                } catch (Exception localException2) {
                }

            } else if (new File(str).exists()) {
                INFO.currentFolder = str;
            }
        } catch (Exception localException1) {
        }
    }
}
