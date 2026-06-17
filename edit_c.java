import java.awt.event.ActionEvent;

class edit_c implements java.awt.event.ActionListener {
    edit_c() {
    }

    public void actionPerformed(ActionEvent e) {
        if (Java_Files_Found.nof > 0) {
            new Editer().start();
        }
    }
}
