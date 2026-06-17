import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class exit_c
        implements ActionListener {
    exit_c() {
    }

    public void actionPerformed(ActionEvent paramActionEvent) {
        Exit.exit();
    }
}
