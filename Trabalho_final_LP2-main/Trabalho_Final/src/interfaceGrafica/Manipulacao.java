package interfaceGrafica;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.*;

public class Manipulacao {
    private static Socket s;
    private static DataInputStream in;
    private static DataOutputStream out;
    private static String enviaAtt;
    private static String enviaChat;
    private static String nomeCliente;
    private static String recebeServidor;
    private static Semaphore libera = new Semaphore(1);

    public Manipulacao() {
    }

    public static void iniciarCliente() throws InterruptedException {
        try {
            s = new Socket("localhost", 4444);
            in = new DataInputStream(s.getInputStream());
            out = new DataOutputStream(s.getOutputStream());
            while (true) {
                recebeServidor = in.readUTF();
                System.out.println(recebeServidor);
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public static synchronized void writeAtualizacao(String message) throws IOException, InterruptedException {
    	libera.acquire();
        enviaAtt = message;
        out.writeUTF(getNomeCliente() + " " +  enviaAtt);
        libera.release();
    }
    
    public static synchronized void writeChat(String message) throws IOException, InterruptedException {
    	libera.acquire();
        enviaChat = message;
        out.writeUTF(getNomeCliente() + " " + enviaChat);
        libera.release();
    }

    public static String getRespostaServidor() throws IOException, InterruptedException {
    	
    	return recebeServidor;
    }
    
    public static void colocaNome(String nome) {
    	
    		setNomeCliente(nome);
    	
    }

	public static String getNomeCliente() {
		return nomeCliente;
	}

	public static void setNomeCliente(String nomeCliente) {
		Manipulacao.nomeCliente = nomeCliente;
	}
}
