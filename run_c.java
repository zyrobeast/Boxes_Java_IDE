import java.awt.event.ActionEvent;

class run_c implements java.awt.event.ActionListener {
    run_c() {
    }

    public void actionPerformed(ActionEvent e) {
        if (Java_Files_Found.nof > 0) {
            new Run().start();
        }
    }
}
