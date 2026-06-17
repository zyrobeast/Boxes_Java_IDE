import javax.swing.*;
import java.io.File;

class Jdk_Check extends java.awt.Canvas implements java.awt.event.ActionListener {
    String loc = "";
    java.awt.FileDialog fd;
    JFrame f;
    javax.swing.JLabel l;
    JButton button;

    Jdk_Check() {
    }

    public void check() {
        try {
            File l = new File("info.info");
            java.io.FileReader filereader = new java.io.FileReader(l);
            java.io.BufferedReader br = new java.io.BufferedReader(filereader);
            loc = br.readLine();
            filereader.close();
            br.close();
        } catch (Exception localException) {
        }


        if ((!new File(loc + "\\javac.exe").exists()) || (!new File(loc + "\\javaws.exe").exists()) || (!new File(loc + "\\javaw.exe").exists()) || (!new File(loc + "\\java.exe").exists())) {
            askJdkLocation();
            Main.f.setVisible(false);
        }
        INFO.loc = loc;
    }

    public void askJdkLocation() {
        f = new JFrame("AS_IDE");
        f.add(this);
        f.setResizable(false);
        f.setLayout(null);
        f.setSize(500, 100);
        f.setLocation(200, 200);
        f.setIconImage(INFO.icon);
        l = new javax.swing.JLabel("Please enter the address of the proper jdk you have.");
        button = new JButton("BROWSE..");
        f.add(l);
        f.add(button);
        l.setBounds(20, 20, 300, 50);
        button.setBounds(330, 30, 100, 30);
        button.addActionListener(this);
        f.setVisible(true);
        l.setVisible(true);
        button.setVisible(true);
    }

    public void actionPerformed(java.awt.event.ActionEvent e) {
        fd = new java.awt.FileDialog(f, "BROWSE", 0);
        fd.setDirectory("C:\\");
        fd.setFile("*.exe");
        fd.setVisible(true);
        loc = fd.getDirectory();
        loc = loc.substring(0, loc.length() - 1);
        File k = new File(loc + "\\javac.exe");
        if (!k.exists())
            Exit.exit();
        k = new File(loc + "\\java.exe");
        if (!k.exists())
            Exit.exit();
        k = new File(loc + "\\javaws.exe");
        if (!k.exists())
            Exit.exit();
        k = new File(loc + "\\javaw.exe");
        if (!k.exists())
            Exit.exit();
        k = new File("info.info");
        k.delete();
        k = new File("info.info");
        try {
            java.io.FileWriter al = new java.io.FileWriter(k, false);
            al.write(loc);
            al.close();
        } catch (Exception localException) {
        }


        f.setVisible(false);
        l.setVisible(false);
        button.setVisible(false);
        Main.f.setVisible(true);
    }
}
