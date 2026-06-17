import javax.swing.*;

class Editer extends java.awt.Canvas implements java.awt.event.ActionListener {
    JFrame f;
    javax.swing.JLabel l;
    javax.swing.JTextField t;
    javax.swing.JButton b;
    java.awt.List li;

    Editer() {
    }

    public void start() {
        Main.run.setVisible(false);
        Main.makej.setVisible(false);
        l = new javax.swing.JLabel("Enter the file name");
        t = new javax.swing.JTextField();
        b = new javax.swing.JButton("Edit");
        f = new JFrame("Edit File");
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
                try {
                    h.charAt(0);
                    if (new java.io.File(INFO.currentFolder + "\\" + h + ".java").exists()) {
                        edit.edit(h);
                        Main.run.setVisible(false);
                    } else {
                        LOG.setText("Cannot find File");
                    }
                } catch (Exception fgh) {
                    LOG.setText("Invalid File name.");
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
        String h = t.getText();
        try {
            h.charAt(0);
            if (new java.io.File(INFO.currentFolder + "\\" + h + ".java").exists()) {
                edit.edit(h);
                Main.run.setVisible(false);
            } else {
                LOG.setText("Cannot find File");
            }
        } catch (Exception fgh) {
            LOG.setText("Invalid File name.");
        }
        f.dispose();
    }
}
