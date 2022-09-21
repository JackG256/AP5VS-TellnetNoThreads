import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("smtp.utb.cz", 25);
            InputStream inp = s.getInputStream();
            OutputStream outp = s.getOutputStream();
            int znak;
            while (true) {
                if (inp.available() > 0) {
                    znak = inp.read();
                    System.out.print((char) znak);
                }
                if (System.in.available() > 0) {
                    outp.write(System.in.read());
                    outp.flush();
                }
                Thread.sleep(10);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}