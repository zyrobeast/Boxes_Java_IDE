import java.awt.event.ActionEvent;

class open_c implements java.awt.event.ActionListener {
    open_c() {
    }

    public void actionPerformed(ActionEvent e) {
        new Open().open();
    }
}
