package interfaceGrafica;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

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

            
            Map<String, Integer> dicionario = new HashMap<>();
            
            dicionario.put("red Atualização: acertou", 11);
            dicionario.put("red Atualização: errou", 12);
            dicionario.put("blue Atualização: acertou", 21);
            dicionario.put("blue Atualização: errou", 22);
            
            // Adiciona o socket do cliente à lista
            clientes.add(s);
            
            // Atribui a cor ao cliente com base na ordem de chegada
            String corCliente = "";
            if (clientes.size() == 1) {
                corCliente = "red";
                out.writeUTF("Cor:" + corCliente);   
            } else if (clientes.size() == 2) {
                corCliente = "blue";
                out.writeUTF("Cor:" + corCliente);
            } 
            

            while (true) {
                String fromClient = in.readUTF();
				int conversor = dicionario.get(fromClient);
                System.out.println("cliente: "+ s.getInetAddress().getHostAddress() + " " + fromClient);
                System.out.println("Transformei em: " + conversor);

                // Envia a mensagem para todos os clientes
                for (Socket cliente : clientes) {
                    DataOutputStream clienteOut = new DataOutputStream(cliente.getOutputStream());
                    clienteOut.write(conversor);
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



