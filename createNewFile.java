import javax.swing.*;

class createNewFile extends java.awt.Canvas implements java.awt.event.ActionListener {
    JFrame f;
    javax.swing.JLabel l;
    javax.swing.JTextField t;
    javax.swing.JButton b;

    createNewFile() {
    }

    public static void create(String k) {
        java.io.File m = new java.io.File(INFO.currentFolder + "\\" + k + ".java");
        try {
            m.createNewFile();
            java.io.FileWriter fw = new java.io.FileWriter(m);
            String j = "class " + k + "\n{\n        public static void main(String[] args)                    //Execution starts here.\n        {\n                System.out.println(\"Hello World\");                    //Your Code Here.\n        }\n}";
            fw.write(j);
            fw.close();
        } catch (Exception localException) {
        }


        Java_Files_Found.check();
    }

    public void start() {
        Main.run.setVisible(false);
        Main.makej.setVisible(false);
        l = new javax.swing.JLabel("Enter the file name");
        t = new javax.swing.JTextField();
        b = new javax.swing.JButton("Create");
        f = new JFrame("Create New File");
        f.setIconImage(INFO.icon);
        f.setLayout(null);
        f.setResizable(false);
        f.setSize(500, 200);
        f.setLocation(200, 200);
        f.add(l);
        f.add(t);
        f.add(b);
        l.setBounds(20, 30, 400, 50);
        t.setBounds(20, 90, 380, 30);
        b.setBounds(400, 90, 90, 30);
        b.addActionListener(this);
        t.addActionListener(this);
        f.setVisible(true);
        l.setVisible(true);
        t.setVisible(true);
        b.setVisible(true);
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
        if ((p) && (!new java.io.File(INFO.currentFolder + "\\" + k + ".java").exists())) {
            create(k);
            LOG.setText("Created File Successfully");
        } else if ((p) && (new java.io.File(INFO.currentFolder + "\\" + k + ".java").exists())) {
            LOG.setText("File Already Exists");
        } else {
            LOG.setText("Invalid Identifier");
        }
        f.dispose();
    }
}
