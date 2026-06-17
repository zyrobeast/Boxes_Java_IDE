class icon {
    static String icon = "";

    icon() {
    }

    public static void load() {
        INFO.icon = imagedecoder.getImage("noci.ima");
    }
}
