package interfaceGrafica;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EndGUI {
	
	JFrame frame;
	JPanel panel;
	JLabel end;

	public EndGUI(String caminho){
		
		frame = new JFrame("End Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0, 0, 1020, 720);
		
		panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		end = new JLabel("");
		end.setIcon(new ImageIcon(EndGUI.class.getResource(caminho)));
		end.setBounds(0, 0, 1020, 720);
		panel.add(end);
		
		
		frame.setVisible(true);
	}
	
}
