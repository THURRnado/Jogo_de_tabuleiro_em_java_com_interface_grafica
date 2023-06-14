package interfaceGrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


//////////////////////////////////////////////////////////////////////////////



//TALVEZ A GENTE USE




/////////////////////////////////////////////////////////////////////////////////

public class Chat extends JPanel {
    private JTextArea chatTextArea;
    private JTextField messageTextField;
    private boolean chatVisible = true;

    public Chat() {
        setLayout(null);

        // Área de texto para exibir as mensagens do chat
        chatTextArea = new JTextArea();
        chatTextArea.setEditable(false);
        chatTextArea.setLineWrap(true); // Quebra de linha automática
        chatTextArea.setWrapStyleWord(true); // Quebra de linha entre palavras
        JScrollPane scrollPane = new JScrollPane(chatTextArea);
        scrollPane.setBounds(10, 35, 280, 250);
        add(scrollPane);

        // Campo de texto para entrada de mensagens
        messageTextField = new JTextField();
        messageTextField.addActionListener(e -> {
        	try {
        		sendMessage();
        	} catch (IOException | InterruptedException e1) {
        		// TODO Auto-generated catch block
        		e1.printStackTrace();
        	}
        });
        messageTextField.setBounds(10, 295, 280, 23);
        add(messageTextField);
    }

    private synchronized void sendMessage() throws IOException, InterruptedException {
        String message = messageTextField.getText();
        Cliente.writeChat(message);
        // Lógica para enviar a mensagem ao chat

        // Exemplo simples: exibir a mensagem no chatTextArea
        chatTextArea.append(Cliente.getIn().readUTF());
        messageTextField.setText("");
    }

    public void setChatVisible(boolean visible) {
        chatVisible = visible;
        setVisible(visible);
    }

    public boolean isChatVisible() {
        return chatVisible;
    }

    
    public static void showChatInClass() {
    	 SwingUtilities.invokeLater(() -> {

             // Criar a janela do programa
             JFrame frame = new JFrame("Chat Example");
             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             frame.setSize(335, 375);
             frame.setResizable(false);

             JLayeredPane layeredPane = new JLayeredPane();
             layeredPane.setLayout(null);

             // Adicionar o ChatPanel ao layeredPane
             Chat chatPanel = new Chat();
             chatPanel.setBounds(0, 0, 300, 350);
             layeredPane.add(chatPanel, JLayeredPane.PALETTE_LAYER);

             // Criar uma camada superior
             JLayeredPane topLayeredPane = new JLayeredPane();
             topLayeredPane.setLayout(null);
             topLayeredPane.setBounds(0, 0, 400, 400);
             layeredPane.add(topLayeredPane, JLayeredPane.MODAL_LAYER);

             // Adicionar o botão "Recolher Chat" ao topLayeredPane
             JButton toggleButton = new JButton("Recolher Chat");
             toggleButton.setBackground(new Color(251, 146, 60, 255));
             toggleButton.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent e) {
                     boolean chatVisible = !chatPanel.isChatVisible();
                     chatPanel.setChatVisible(chatVisible);
                     if (chatVisible) {
                         toggleButton.setText("Recolher Chat");
                     } else {
                         toggleButton.setText("Exibir Chat");
                     }
                 }
             });
             toggleButton.setBounds(0, 0, 120, 30);
             topLayeredPane.add(toggleButton, JLayeredPane.DEFAULT_LAYER);
             frame.getContentPane().add(layeredPane);
             frame.setVisible(true);
         });
    }
    
    public static void initialize() {
    	showChatInClass();
    }
    
    public static void main(String[] args) {
    	initialize();
    }
    
}
