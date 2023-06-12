package interfaceGrafica;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor implements Runnable {

    private static List<Socket> clientes = new ArrayList<>();
    private Socket s;

    public Servidor(Socket ns) {
        s = ns;
    }

    public void run() {
        try {
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            // Adiciona o socket do cliente à lista
            clientes.add(s);

            while (true) {
                String fromClient = in.readUTF();
                System.out.println("cliente: "+ s.getInetAddress().getHostAddress() + " " + fromClient);

                // Envia a mensagem para todos os clientes
                for (Socket cliente : clientes) {
                    DataOutputStream clienteOut = new DataOutputStream(cliente.getOutputStream());
                    clienteOut.writeUTF(fromClient);
                }
                if (fromClient.equals("Bye")) break;
            }
            in.close();
            out.close();
            s.close();
        } catch (IOException  e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            ServerSocket s = new ServerSocket(4444);
            System.out.println("Servidor iniciado");
            while (true) {
                Socket ns = s.accept();
                System.out.println("Cliente " + ns.getInetAddress().getHostAddress() + " conectado");
                new Thread(new Servidor(ns)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



