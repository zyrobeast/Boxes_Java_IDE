import java.io.File;

class make_JAR extends java.awt.Canvas implements java.awt.event.ActionListener {
    javax.swing.JFrame f;
    javax.swing.JLabel l;
    javax.swing.JLabel l2;
    javax.swing.JTextField t;
    javax.swing.JTextField t2;
    javax.swing.JButton b;

    make_JAR() {
    }

    public static void make_Jar(String jarname, String mainclass) {
        if (new File(INFO.currentFolder + "\\" + mainclass + ".java").exists()) {
            LOG.setText("Creating Jar File..");
            try {
                File cf = new File("jarname.info");
                cf.createNewFile();
                java.io.FileWriter al = new java.io.FileWriter(cf, false);
                al.write(jarname);
                al.close();
            } catch (Exception localException) {
            }


            try {
                File cf = new File("main.info");
                cf.createNewFile();
                java.io.FileWriter al = new java.io.FileWriter(cf, false);
                al.write(mainclass);
                al.close();
            } catch (Exception localException1) {
            }


            try {
                Runtime.getRuntime().exec("cmd.exe /c start jij.exe").waitFor();
            } catch (Exception localException2) {
            }


            File l = new File(INFO.currentFolder + "\\" + jarname + ".jar");
            File kl = new File(INFO.currentFolder + "\\e\\" + jarname + ".jar");
            while (!l.renameTo(kl)) {
            }
            l = new File(INFO.currentFolder + "\\" + jarname + ".jar");
            kl = new File(INFO.currentFolder + "\\e\\" + jarname + ".jar");
            while (!kl.renameTo(l)) {
            }
            kl.delete();
            new File(INFO.currentFolder + "\\e").delete();
            new File("e").delete();
            LOG.setText("Created Jar Sucessfully");
        } else {
            LOG.setText("Cannot Find Main Class");
        }
    }

    public void start() {
        l = new javax.swing.JLabel("Enter the jar file name");
        t = new javax.swing.JTextField();
        l2 = new javax.swing.JLabel("Enter the main file name");
        t2 = new javax.swing.JTextField();
        b = new javax.swing.JButton("Create");
        f = new javax.swing.JFrame("Create Jar File");
        f.setIconImage(INFO.icon);
        f.setLayout(null);
        f.setResizable(false);
        f.setSize(500, 400);
        f.setLocation(200, 200);
        f.add(l);
        f.add(t);
        f.add(l2);
        f.add(t2);
        f.add(b);
        l.setBounds(20, 30, 400, 50);
        t.setBounds(20, 90, 380, 30);
        l2.setBounds(20, 150, 400, 50);
        t2.setBounds(20, 210, 380, 30);
        b.setBounds(200, 250, 90, 30);
        b.addActionListener(this);
        f.setVisible(true);
        l.setVisible(true);
        t.setVisible(true);
        l2.setVisible(true);
        t2.setVisible(true);
        b.setVisible(true);
    }

    public void actionPerformed(java.awt.event.ActionEvent e) {
        String k = t.getText();
        String k2 = t2.getText();
        boolean p = true;
        try {
            for (int i = 0; i < k.length() - 1; i++) {
                char a = k.charAt(i);
                if (((a < '0') || (a > '9')) && ((a < 'A') || (a > 'Z')) && ((a < 'a') || (a > 'z')) && (a != '_')) {
                    p = false;
                    break;
                }
            }
            if ((k.charAt(0) >= '0') && (k.charAt(0) <= '9'))
                p = false;
            for (int i = 0; i < k2.length() - 1; i++) {
                char a = k2.charAt(i);
                if (((a < '0') || (a > '9')) && ((a < 'A') || (a > 'Z')) && ((a < 'a') || (a > 'z')) && (a != '_')) {
                    p = false;
                    break;
                }
            }
            if ((k2.charAt(0) >= '0') && (k2.charAt(0) <= '9')) {
                p = false;
            }
        } catch (Exception juidfg) {
            p = false;
        }
        if (p) {
            make_Jar(t.getText(), t2.getText());
        } else {
            LOG.setText("Invalid Identifier");
        }
        f.dispose();
    }
}
