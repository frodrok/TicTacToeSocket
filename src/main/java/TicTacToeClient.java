import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class TicTacToeClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("85.227.190.15", 27015);
            PrintWriter out = new PrintWriter(socket.getOutputStream());

            out.write("wow");

            out.close();

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}