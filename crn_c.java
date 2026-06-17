import java.awt.event.ActionEvent;

class crn_c implements java.awt.event.ActionListener {
    crn_c() {
    }

    public void actionPerformed(ActionEvent e) {

        if (new java.io.File(INFO.currentFolder + "\\").exists()) {
            new createNewFile().start();
        } else {
            LOG.setText("Some problem ocurred while reading the current folder.\nPlease try changing the current folder");
        }
    }
}
