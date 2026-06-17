import javax.swing.*;

class Run extends java.awt.Canvas implements java.awt.event.ActionListener {
    JFrame f;
    javax.swing.JLabel l;
    javax.swing.JTextField t;
    javax.swing.JButton b;
    java.awt.List li;

    Run() {
    }

    public static void run(String k) {
        try {
            java.io.File f = new java.io.File("file.info");
            f.createNewFile();
            java.io.FileWriter fw = new java.io.FileWriter(f);
            fw.write(k);
            fw.close();
            try {
                Runtime.getRuntime().exec("cmd.exe /c start jir.exe").waitFor();
            } catch (Exception localException) {
            }
        } catch (Exception localException1) {
        }
    }

    public void start() {
        l = new javax.swing.JLabel("Enter the file name");
        t = new javax.swing.JTextField();
        b = new javax.swing.JButton("Run");
        f = new JFrame("Run File");
        li = new java.awt.List(5, false);
        java.io.File file = new java.io.File(INFO.currentFolder + "\\");
        java.io.File[] files = file.listFiles();
        for (java.io.File fi : files) {
            if (fi.getName().endsWith(".java")) {
                li.add(fi.getName().substring(0, fi.getName().lastIndexOf(".java")));
            }
        }
        f.setIconImage(INFO.icon);
        f.setLayout(null);
        f.setResizable(false);
        f.setSize(600, 300);
        f.setLocation(200, 200);
        f.add(l);
        f.add(t);
        f.add(b);
        f.add(li);
        li.setBounds(20, 130, 380, 140);
        l.setBounds(20, 30, 400, 50);
        t.setBounds(20, 90, 380, 30);
        b.setBounds(400, 90, 90, 30);
        b.addActionListener(this);
        t.addActionListener(this);
        li.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                t.setText(li.getSelectedItem());
                String h = t.getText();
                String k = t.getText();
                boolean p = true;
                try {
                    for (int i = 0; i < k.length() - 1; i++) {
                        char a = k.charAt(i);
                        if (((a < '0') || (a > '9')) && ((a < 'A') || (a > 'Z')) && ((a < 'a') || (a > 'z')) && (a != '_')) {
                            p = false;
                            break;
                        }
                    }
                    if ((k.charAt(0) >= '0') && (k.charAt(0) <= '9')) {
                        p = false;
                    }
                } catch (Exception dfg) {
                    p = false;
                }
                if (p) {
                    Run.run(k);
                } else {
                    LOG.setText("Cannot find File");
                }
                f.dispose();
            }
        });
        f.setVisible(true);
        l.setVisible(true);
        t.setVisible(true);
        b.setVisible(true);
        li.setVisible(true);
    }

    public void actionPerformed(java.awt.event.ActionEvent e) {
        String k = t.getText();
        boolean p = true;
        try {
            for (int i = 0; i < k.length() - 1; i++) {
                char a = k.charAt(i);
                if (((a < '0') || (a > '9')) && ((a < 'A') || (a > 'Z')) && ((a < 'a') || (a > 'z')) && (a != '_')) {
                    p = false;
                    break;
                }
            }
            if ((k.charAt(0) >= '0') && (k.charAt(0) <= '9')) {
                p = false;
            }
        } catch (Exception dfg) {
            p = false;
        }
        if (p) {
            run(k);
        } else {
            LOG.setText("Cannot find File");
        }
        f.dispose();
    }
}
