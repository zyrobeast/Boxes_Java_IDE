import javax.swing.*;

class Open extends javax.swing.JFrame {
    Open() {
    }

    public void open() {
        Main.run.setVisible(false);
        Main.makej.setVisible(false);
        setIconImage(INFO.icon);
        JFileChooser d = new JFileChooser("Open");
        d.setCurrentDirectory(new java.io.File("C:\\"));
        d.setFileSelectionMode(1);
        d.setAcceptAllFileFilterUsed(false);
        d.setFileView(new javax.swing.filechooser.FileView() {
            public javax.swing.Icon getIcon(java.io.File f) {
                return javax.swing.filechooser.FileSystemView.getFileSystemView().getSystemIcon(f);
            }
        });
        if (d.showOpenDialog(this) == 0) {
            String kk = d.getSelectedFile().getAbsolutePath();
            INFO.changeCurrentFolder(kk);
            Java_Files_Found.check();
        }
    }
}
