import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TicTacToeServer {

    static char[][] board = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};

    public static void main(String[] args) {

        try {
            ServerSocket socket = new ServerSocket(27015);
            Socket clientSocket = socket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            out.write(boardToString());

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

    static String boardToString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (j < 2) {
                    sb.append(board[i][j] + "|");
                } else {
                    sb.append(board[i][j]);
                }
            }
            sb.append("\n");
            if (i < 2) {
                sb.append("------\n");
            }
        }

        return sb.toString();
    }

}