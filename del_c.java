import java.awt.event.ActionEvent;

class del_c implements java.awt.event.ActionListener {
    del_c() {
    }

    public void actionPerformed(ActionEvent e) {
        if (Java_Files_Found.nof > 0) {
            new deleteFile().start();
        }
    }
}
