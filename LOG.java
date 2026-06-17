import java.io.File;

class LOG {
    static String log = "";
    static String n = "**************************************************LOG*****************************************************\n";
    static java.awt.TextArea t = new java.awt.TextArea(n + "Welcome to BOXES_IDE by AS Softwares And Application\nProgrammed By: Abhisek Singh");
    LOG() {
    }

    public static void check() {
        String m = "";
        try {
            File l = new File("error.txt");
            File kl = new File("e\\error.txt");
            while (!l.renameTo(kl)) {
            }
            l = new File("e\\error.txt");
            new File("e\\").delete();
            java.io.FileReader filereader = new java.io.FileReader(l);
            java.io.BufferedReader br = new java.io.BufferedReader(filereader);
            String loc = br.readLine();
            String loc2 = "";
            do {
                m = m + loc + "\n";
                if (loc != null) {
                    int as = loc.lastIndexOf(".java");
                    if (as >= 0) {
                        String op = loc.substring(0, as + 5);
                        if ((new File(INFO.currentFolder + "\\" + op).exists()) && (!op.equals(loc2))) {
                            int n = Integer.parseInt(loc.substring(as + 6, loc.indexOf(":", as + 7)));
                            new edit().start(op.substring(0, op.lastIndexOf(".java")), n - 1);
                        }
                        loc2 = op;
                    }
                }
            } while ((loc = br.readLine()) != null);
            filereader.close();
            br.close();
            l.delete();
            new File("error.txt").delete();
            new File("e").delete();
        } catch (Exception localException) {
        }


        if (m.equals("null\n")) {
            log = "Compilation Successful";
            Main.run.setVisible(true);
            Main.makej.setVisible(true);
        } else {
            log = m;
        }
        setText(log);
    }

    public static void setText(String h) {
        log = n + h;
        t.setEditable(true);
        t.setText(log);
        t.setEditable(false);
    }
}
