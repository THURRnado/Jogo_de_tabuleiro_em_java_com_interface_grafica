package interfaceGrafica;

import java.awt.EventQueue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.*;

public class Cliente {
	private static Socket s;
	private static DataInputStream in;
	private static DataOutputStream out;
	private static String enviaAtt;
	private static String enviaChat;
	private static int recebeServidor;
	private static String recebeNome;
	private static Semaphore libera = new Semaphore(1);

	private static String cor = "";


	public Cliente() {

	}

	public static void iniciarCliente() throws InterruptedException, UnknownHostException, IOException {

		s = new Socket("localhost", 4444);
		setIn(new DataInputStream(s.getInputStream()));
		out = new DataOutputStream(s.getOutputStream());
		
		recebeNome = in.readUTF();
		
		if (recebeNome.equals("Cor:red") || recebeNome.equals("Cor:blue")) {
			cor = recebeNome.substring(recebeNome.indexOf(":") + 1);
		}
	}

	public static synchronized void writeAtualizacao(String message) throws IOException, InterruptedException {
    	libera.acquire();
        enviaAtt = message;
        out.writeUTF(getCor() + " Atualização: " +  enviaAtt);
        libera.release();
    }
    
    public static synchronized void writeChat(String message) throws IOException, InterruptedException {
    	libera.acquire();
        enviaChat = message;
        out.writeUTF(getCor() + " Mensagem: " + enviaChat);
        libera.release();
    }

    private static String getCor() {
		return cor;
	}

	public static int getRecebeServidor() {
		return recebeServidor;
	}

	public static DataInputStream getIn() {
		return in;
	}
	
	private static void setIn(DataInputStream dataInputStream) {
		// TODO Auto-generated method stub
		
	}
}
