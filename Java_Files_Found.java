import java.io.File;

public class Java_Files_Found {
    static String log;
    static java.awt.TextArea t = new java.awt.TextArea();
    static int nof = 0;
    public Java_Files_Found() {
    }

    public static void check() {
        nof = 0;
        String m = INFO.currentFolder + "\r\nJava_Files_Found\r\n\r\n";
        try {
            File file = new File(INFO.currentFolder + "\\");
            File[] files = file.listFiles();
            for (File f : files) {
                if (f.getName().endsWith(".java")) {
                    m = m + f.getName() + "\r\n";
                    nof += 1;
                }
            }
        } catch (Exception e) {
            LOG.setText("Cannot Find Java Files");
        }
        log = m;
        setText(log);
    }

    public static void setText(String h) {
        log = h;
        t.setEditable(true);
        t.setText(log);
        t.setEditable(false);
    }
}
