import java.awt.event.ActionEvent;

class com_c implements java.awt.event.ActionListener {
    com_c() {
    }

    public void actionPerformed(ActionEvent e) {
        if (Java_Files_Found.nof > 0) {
            Compiler.compile();
        }
    }
}
