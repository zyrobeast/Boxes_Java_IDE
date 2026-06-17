import javax.swing.*;

class edit extends java.awt.Canvas implements java.awt.event.ActionListener, java.awt.event.KeyListener {
    JFrame f;
    JFrame log;
    java.awt.TextArea t;
    java.awt.TextArea ln;
    javax.swing.JButton b;
    javax.swing.JButton showlog;
    javax.swing.JButton run;
    javax.swing.JButton exit;
    String loc = "";
    java.awt.Robot robot;
    String space = "        ";
    String name;

    edit() {
    }

    public static void edit(String k) {
        new edit().start(k);
    }

    public void start(String k) {
        name = k;
        String m = "";
        loc = k;
        f = new JFrame("BOXES_IDE_EDITER--" + INFO.currentFolder + " --" + k + ".java");
        log = new JFrame("BOXES_IDE_EDITER--" + INFO.currentFolder + " --" + k + ".java  LOG");
        t = new java.awt.TextArea();
        b = new javax.swing.JButton("Compile");
        showlog = new javax.swing.JButton("Show Log");
        run = new javax.swing.JButton("Run");
        exit = new javax.swing.JButton("Exit");
        try {
            java.io.FileReader fw = new java.io.FileReader(new java.io.File(INFO.currentFolder + "\\" + k + ".java"));
            java.io.BufferedReader br = new java.io.BufferedReader(fw);
            String li;
            while ((li = br.readLine()) != null) {
                m = m + li + "\n";
            }
            fw.close();
            br.close();
        } catch (Exception localException) {
        }


        t.setEditable(true);
        t.setText(m);
        b.addActionListener(this);
        f.setLayout(null);
        f.getContentPane().setBackground(new java.awt.Color(239, 228, 176));
        f.setIconImage(INFO.icon);
        f.setSize(1050, 700);
        f.setResizable(false);
        f.setDefaultCloseOperation(0);
        f.add(b);
        f.add(run);
        f.add(showlog);
        f.add(t);
        f.add(exit);
        b.setBounds(20, 10, 100, 30);
        showlog.setBounds(150, 10, 100, 30);
        exit.setBounds(280, 10, 100, 30);
        run.setBounds(420, 10, 100, 30);
        t.setBounds(20, 60, 950, 600);
        t.setFont(new java.awt.Font("Sans Serif", 1, 20));
        f.setVisible(true);
        run.setVisible(false);
        t.addKeyListener(this);
        setFocusable(true);
        showlog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent kl) {
                if (showlog.getText().equals("Show Log")) {
                    log.setVisible(true);
                    showlog.setText("Hide Log");
                } else {
                    log.setVisible(false);
                    showlog.setText("Show Log");
                }
            }
        });
        run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent kl) {

                if (new java.io.File(INFO.currentFolder + "\\" + loc + ".java").exists()) {
                    Run.run(name);
                } else {
                    LOG.setText("Cannot Find Java Files");
                    log.dispose();
                    f.dispose();
                }
            }
        });
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent kl) {
                String l = t.getText();
                try {
                    java.io.FileWriter fr = new java.io.FileWriter(new java.io.File(INFO.currentFolder + "\\" + loc + ".java"));
                    fr.write(l);
                    fr.close();
                } catch (Exception frgdfg) {
                    LOG.setText("Cannot Find Java Files");
                    log.dispose();
                    f.dispose();
                }
                log.dispose();
                f.dispose();
            }
        });
        try {
            robot = new java.awt.Robot();
        } catch (Exception localException1) {
        }


        log.setLayout(null);
        log.getContentPane().setBackground(new java.awt.Color(239, 228, 176));
        log.setIconImage(INFO.icon);
        log.setSize(700, 300);
        log.setResizable(false);
        log.setDefaultCloseOperation(0);
        ln = new java.awt.TextArea();
        ln.setEditable(false);
        log.add(ln);
        ln.setBounds(20, 20, 650, 250);
        log.setVisible(false);
    }

    public void start(String k, int sd) {
        name = k;
        String m = "";
        loc = k;
        f = new JFrame("BOXES_IDE_EDITER--" + INFO.currentFolder + " --" + k + ".java");
        log = new JFrame("BOXES_IDE_EDITER--" + INFO.currentFolder + " --" + k + ".java  LOG");
        t = new java.awt.TextArea();
        b = new javax.swing.JButton("Compile");
        showlog = new javax.swing.JButton("Show Log");
        run = new javax.swing.JButton("Run");
        exit = new javax.swing.JButton("Exit");
        try {
            java.io.FileReader fw = new java.io.FileReader(new java.io.File(INFO.currentFolder + "\\" + k + ".java"));
            java.io.BufferedReader br = new java.io.BufferedReader(fw);
            String li;
            while ((li = br.readLine()) != null) {
                m = m + li + "\n";
            }
            fw.close();
            br.close();
        } catch (Exception localException) {
        }


        t.setEditable(true);
        t.setText(m);
        b.addActionListener(this);
        f.setLayout(null);
        f.getContentPane().setBackground(new java.awt.Color(239, 228, 176));
        f.setIconImage(INFO.icon);
        f.setSize(1050, 700);
        f.setResizable(false);
        f.setDefaultCloseOperation(0);
        f.add(b);
        f.add(run);
        f.add(showlog);
        f.add(t);
        f.add(exit);
        b.setBounds(20, 10, 100, 30);
        showlog.setBounds(150, 10, 100, 30);
        exit.setBounds(280, 10, 100, 30);
        run.setBounds(420, 10, 100, 30);
        t.setBounds(20, 60, 950, 600);
        t.setFont(new java.awt.Font("Sans Serif", 1, 20));
        f.setVisible(true);
        run.setVisible(false);
        t.addKeyListener(this);
        setFocusable(true);
        while (!f.isVisible()) {
        }


        try {
            java.awt.Robot robo = new java.awt.Robot();
            robo.mouseMove(f.getX() + 940, f.getY() + 90);
            robo.mousePress(16);
            robo.mouseRelease(16);
            for (int i = 1; i <= sd; i++) {
                robo.keyPress(40);
                robo.keyRelease(40);
            }
        } catch (Exception localException1) {
        }


        showlog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent kl) {
                if (showlog.getText().equals("Show Log")) {
                    log.setVisible(true);
                    showlog.setText("Hide Log");
                } else {
                    log.setVisible(false);
                    showlog.setText("Show Log");
                }
            }
        });
        run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent kl) {

                if (new java.io.File(INFO.currentFolder + "\\" + loc + ".java").exists()) {
                    Run.run(name);
                } else {
                    LOG.setText("Cannot Find Java Files");
                    log.dispose();
                    f.dispose();
                }
            }
        });
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent kl) {
                String l = t.getText();
                try {
                    java.io.FileWriter fr = new java.io.FileWriter(new java.io.File(INFO.currentFolder + "\\" + loc + ".java"));
                    fr.write(l);
                    fr.close();
                } catch (Exception frgdfg) {
                    LOG.setText("Cannot Find Java Files");
                    log.dispose();
                    f.dispose();
                }
                log.dispose();
                f.dispose();
            }
        });
        try {
            robot = new java.awt.Robot();
        } catch (Exception localException2) {
        }


        log.setLayout(null);
        log.getContentPane().setBackground(new java.awt.Color(239, 228, 176));
        log.setIconImage(INFO.icon);
        log.setSize(700, 300);
        log.setResizable(false);
        log.setDefaultCloseOperation(0);
        ln = new java.awt.TextArea();
        ln.setEditable(false);
        log.add(ln);
        ln.setBounds(20, 20, 650, 250);
        log.setVisible(false);
    }

    public void actionPerformed(java.awt.event.ActionEvent e) {
        Java_Files_Found.check();
        ln.setEditable(true);
        ln.setText("Compiling...");
        ln.setEditable(false);
        String l = t.getText();
        try {
            java.io.FileWriter fr = new java.io.FileWriter(new java.io.File(INFO.currentFolder + "\\" + this.loc + ".java"));
            fr.write(l);
            fr.close();
            try {
                new java.io.File("file.info").createNewFile();
                java.io.FileWriter fg = new java.io.FileWriter(new java.io.File("file.info"));
                fg.write(name);
                fg.close();
            } catch (Exception localException1) {
            }


            log.setVisible(true);
            showlog.setText("Hide Log");
            try {
                Runtime.getRuntime().exec("cmd.exe /c start jic_s.exe").waitFor();
            } catch (Exception localException2) {
            }


            String m = "";
            try {
                java.io.File ml = new java.io.File("error.txt");
                java.io.File kl = new java.io.File("e\\error.txt");
                while (!ml.renameTo(kl)) {
                }
                ml = new java.io.File("e\\error.txt");
                java.io.FileReader filereader = new java.io.FileReader(ml);
                java.io.BufferedReader br = new java.io.BufferedReader(filereader);
                String loc = br.readLine();
                do {
                    m = m + loc + "\n";
                } while ((loc = br.readLine()) != null);
                filereader.close();
                br.close();
                ml.delete();
                new java.io.File("error.txt").delete();
            } catch (Exception localException3) {
            }


            if (m.equals("null\n")) {
                ln.setEditable(true);
                ln.setText("Compilation Successful");
                ln.setEditable(false);
                run.setVisible(true);
            } else {
                ln.setEditable(true);
                ln.setText(m);
                ln.setEditable(false);
                run.setVisible(false);
            }
        } catch (Exception frgdfg) {
            LOG.setText("Cannot Find Java Files");
            log.dispose();
            f.dispose();
        }
        new java.io.File("e").delete();
    }

    public void keyPressed(java.awt.event.KeyEvent e) {
        run.setVisible(false);
        if (e.getKeyCode() == 10) {
            int sp = 0;
            String te = t.getText();
            int len = te.length();
            int c = t.getCaretPosition();
            for (int i = 0; i < c; i++)
                if (te.charAt(i) == '{')
                    sp++;
            for (int i = 0; i < c; i++)
                if (te.charAt(i) == '}')
                    sp--;
            String m = "";
            for (int i = 1; i <= sp; i++)
                m = m + space;
            String n = "";
            n = n + te.substring(0, c) + "\n" + m;
            if (c < len)
                n = n + te.substring(c, len);
            t.setText(n);
            robot.keyPress(8);
            robot.keyRelease(8);
            t.setCaretPosition(c + 8 * sp + 1);
        }
        if (e.getKeyChar() == '}') {
            int sp = 0;
            String te = t.getText();
            int len = te.length();
            int c = t.getCaretPosition();
            for (int i = 0; i < c; i++)
                if (te.charAt(i) == '{')
                    sp++;
            for (int i = 0; i < c; i++)
                if (te.charAt(i) == '}')
                    sp--;
            String n = "";
            int cb = te.lastIndexOf('{', c - 1);
            int nl = te.lastIndexOf('\n', c - 1);
            if (nl < cb) {
                if (sp > 0) {
                    n = n + te.substring(0, c) + "}";
                    for (int i = c; i < len; i++)
                        n = n + te.charAt(i);
                    t.setText(n);
                    robot.keyPress(8);
                    robot.keyRelease(8);
                    t.setCaretPosition(c + 1);
                } else if (sp <= 0) {
                    robot.keyPress(8);
                    robot.keyRelease(8);
                    t.setCaretPosition(c);
                }
            } else if (nl > cb) {
                if (sp > 0) {
                    sp--;
                    String m = "";
                    for (int i = 1; i <= sp; i++)
                        m = m + space;
                    n = n + te.substring(0, nl + 1) + m + "}";
                    for (int i = nl + 1; i < len; i++)
                        n = n + te.charAt(i);
                    t.setText(n);
                    robot.keyPress(8);
                    robot.keyRelease(8);
                    t.setCaretPosition(nl + 8 * sp + 2);
                } else if (sp <= 0) {
                    robot.keyPress(8);
                    robot.keyRelease(8);
                    t.setCaretPosition(c);
                }
            }
        }
    }

    public void keyReleased(java.awt.event.KeyEvent e) {
    }

    public void keyTyped(java.awt.event.KeyEvent e) {
    }
}
