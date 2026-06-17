import javax.swing.*;

public class Main extends java.awt.Canvas {
    static javax.swing.JFrame f;
    static JButton open;
    static JButton crn;
    static JButton edi;
    static JButton dele;
    static JButton makej;
    static JButton run;
    static JButton compile;
    static JButton exit;
    public Main() {
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 999999999; i++) {
        }
        icon.load();
        try {
            java.io.File cf = new java.io.File("cf.info");
            cf.createNewFile();
            java.io.FileWriter al = new java.io.FileWriter(cf, false);
            al.write(System.getProperty("user.dir"));
            al.close();
            cf = new java.io.File("info.info");
            cf.createNewFile();
            cf = new java.io.File("loc.info");
            cf.createNewFile();
        } catch (Exception localException) {
        }


        f = new javax.swing.JFrame("BOXES_IDE");
        f.setIconImage(INFO.icon);
        f.setSize(800, 500);
        f.setResizable(false);
        f.setDefaultCloseOperation(3);
        f.setIconImage(INFO.icon);
        f.setLayout(null);
        f.getContentPane().setBackground(new java.awt.Color(239, 228, 176));
        open = new JButton("Open");
        crn = new JButton("New File");
        edi = new JButton("Edit");
        dele = new JButton("Delete");
        makej = new JButton("Make_Jar");
        run = new JButton("Run");
        compile = new JButton("Compile");
        exit = new JButton("Exit");
        open.addActionListener(new open_c());
        crn.addActionListener(new crn_c());
        edi.addActionListener(new edit_c());
        dele.addActionListener(new del_c());
        makej.addActionListener(new mjt_c());
        run.addActionListener(new run_c());
        compile.addActionListener(new com_c());
        exit.addActionListener(new exit_c());
        f.add(open);
        f.add(crn);
        f.add(edi);
        f.add(dele);
        f.add(makej);
        f.add(run);
        f.add(compile);
        f.add(exit);
        f.add(LOG.t);
        f.add(Java_Files_Found.t);
        open.setBounds(20, 50, 100, 30);
        crn.setBounds(20, 100, 100, 30);
        edi.setBounds(20, 150, 100, 30);
        dele.setBounds(20, 200, 100, 30);
        makej.setBounds(20, 250, 100, 30);
        run.setBounds(20, 300, 100, 30);
        compile.setBounds(20, 350, 100, 30);
        exit.setBounds(20, 400, 100, 30);
        LOG.t.setEditable(false);
        LOG.t.setBounds(150, 20, 650, 200);
        LOG.t.setVisible(true);
        Java_Files_Found.t.setEditable(false);
        Java_Files_Found.t.setBounds(150, 260, 650, 200);
        Java_Files_Found.t.setVisible(true);
        open.setVisible(true);
        crn.setVisible(true);
        edi.setVisible(true);
        dele.setVisible(true);
        makej.setVisible(false);
        run.setVisible(false);
        compile.setVisible(true);
        exit.setVisible(true);
        f.setVisible(true);
        new Jdk_Check().check();
        loadCurrentFolder.load();
        Java_Files_Found.check();
    }
}
