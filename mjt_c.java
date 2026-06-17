import java.awt.event.ActionEvent;

class mjt_c implements java.awt.event.ActionListener {
    mjt_c() {
    }

    public void actionPerformed(ActionEvent e) {
        if (Java_Files_Found.nof > 0) {
            new make_JAR().start();
        }
    }
}
