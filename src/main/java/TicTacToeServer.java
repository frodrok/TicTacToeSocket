import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TicTacToeServer {

    char[][] board = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};

    public static void main(String[] args) {

        try {
            ServerSocket socket = new ServerSocket(27015);
            Socket clientSocket = socket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String line;

            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }

            out.close();
            in.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}