import java.awt.image.BufferedImage;
import java.io.BufferedReader;

class imagedecoder {
    imagedecoder() {
    }

    public static java.awt.Image getImage(String paramString) {
        BufferedImage localObject = null;
        try {
            java.io.FileReader localFileReader = new java.io.FileReader(paramString);
            BufferedReader localBufferedReader = new BufferedReader(localFileReader);
            int i = Integer.parseInt(localBufferedReader.readLine());
            int j = Integer.parseInt(localBufferedReader.readLine());
            BufferedImage localBufferedImage = new BufferedImage(j, i, 2);
            for (int k = 0; k < i; k++) {
                for (int m = 0; m < j; m++) {
                    int n = Integer.parseInt(localBufferedReader.readLine());
                    localBufferedImage.setRGB(m, k, n);
                }
            }
            localObject = localBufferedImage;
            localBufferedReader.close();
        } catch (Exception localException) {
            System.exit(0);
        }
        return localObject;
    }
}
