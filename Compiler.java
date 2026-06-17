class Compiler {
    Compiler() {
    }

    public static void compile() {
        if (Java_Files_Found.nof > 0) {
            LOG.t.setText(LOG.n + "Compiling...");
            try {
                Runtime.getRuntime().exec("cmd.exe /c start jic.exe").waitFor();
            } catch (Exception localException) {
            }


            LOG.check();
        } else {
            LOG.setText("Cannot Find Java Files");
        }
    }
}
