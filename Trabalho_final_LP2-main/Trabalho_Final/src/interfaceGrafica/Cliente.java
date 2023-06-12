package interfaceGrafica;

import java.io.DataInputStream;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 4444);
        DataInputStream in = new DataInputStream(s.getInputStream());
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        // Thread para ler mensagens do servidor
        Thread serverReaderThread = new Thread(() -> {
            try {
                while (true) {
                    String message = in.readUTF();
                    System.out.println(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        serverReaderThread.start();

        // Loop principal para enviar mensagens
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String fromUser = scanner.nextLine();
            out.writeUTF(fromUser);
            if (fromUser.equals("Bye")) break;
        }

        // Encerrando a conexão
        in.close();
        out.close();
        s.close();
    }
}

