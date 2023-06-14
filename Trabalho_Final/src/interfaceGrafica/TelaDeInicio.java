package interfaceGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class TelaDeInicio {

	private JFrame frmTelaDeInicio;
	private Socket s;
	public DataInputStream in;
	public DataOutputStream out;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					TelaDeInicio window = new TelaDeInicio();
					window.getFrmTelaDeInicio().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaDeInicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrmTelaDeInicio(new JFrame());
		getFrmTelaDeInicio().setIconImage(Toolkit.getDefaultToolkit().getImage(TelaDeInicio.class.getResource("/emojiParaProjetoJava.png")));
		getFrmTelaDeInicio().setTitle("Tela de Inicio");
		getFrmTelaDeInicio().getContentPane().setBackground(new Color(191, 255, 191));
		getFrmTelaDeInicio().setForeground(Color.WHITE);
		getFrmTelaDeInicio().setBackground(Color.WHITE);
		getFrmTelaDeInicio().setBounds(100, 0, 1240, 720);
		getFrmTelaDeInicio().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrmTelaDeInicio().getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gledson Game");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Algerian", Font.PLAIN, 60));
		lblNewLabel.setForeground(new Color(210, 180, 140));
		lblNewLabel.setBounds(341, 108, 542, 78);
		getFrmTelaDeInicio().getContentPane().add(lblNewLabel);
		
		JButton botaoIniciar = new JButton("Iniciar");
		botaoIniciar.setBackground(new Color(210, 180, 140));
		botaoIniciar.setForeground(new Color(139, 69, 19));
		botaoIniciar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botaoIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							TelaDeAddJogador window = new TelaDeAddJogador();
							window.getFrmAdicionarJogador().setVisible(true);
							getFrmTelaDeInicio().dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});

			}
		});

		botaoIniciar.setBounds(416, 355, 391, 87);
		getFrmTelaDeInicio().getContentPane().add(botaoIniciar);
		
		JButton botaoSair = new JButton("Sair");
		botaoSair.setForeground(new Color(139, 69, 19));
		botaoSair.setBackground(new Color(210, 180, 140));
		botaoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		});
		botaoSair.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botaoSair.setBounds(416, 471, 391, 87);
		getFrmTelaDeInicio().getContentPane().add(botaoSair);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(TelaDeInicio.class.getResource("/gatoLP2.png")));
		lblNewLabel_2.setBounds(548, 180, 114, 69);
		frmTelaDeInicio.getContentPane().add(lblNewLabel_2);
	}

	public JFrame getFrmTelaDeInicio() {
		return frmTelaDeInicio;
	}

	public void setFrmTelaDeInicio(JFrame frmTelaDeInicio) {
		this.frmTelaDeInicio = frmTelaDeInicio;
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
