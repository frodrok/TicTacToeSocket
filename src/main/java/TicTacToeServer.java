import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class TicTacToeServer {

    static char[][] board = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};

    public static void main(String[] args) throws IOException {

        ServerSocket socket = null;
        try {
            socket = new ServerSocket(27015);

            while (true) {
                Socket clientSocket = socket.accept();
                try {
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
                    out.print("watwat\nwatwat\nwatwat");
                } finally {
                    clientSocket.close();
                }
            }

        } finally {
            if (socket != null) {
                socket.close();
            }
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