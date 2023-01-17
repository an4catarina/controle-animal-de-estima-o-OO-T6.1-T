package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class TelaPrincipal implements ActionListener {
	private static JFrame frame;
	
	TelaPrincipal() {
		frame = new JFrame("My Pet Care");
		frame.setSize(600, 700);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		implementarTemplate();
		painelPets();
		botaoAdicaoTutor();
		textoPet();
		botaoVerpet();
	}
	public void implementarTemplate() {
		
		try {
			BufferedImage img = ImageIO.read(getClass().getResource("/imagens/telageral.jpg"));
			Image dimg = img.getScaledInstance(600, 700, Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(dimg);
			JLabel label = new JLabel();
			label.setIcon(icon);
			frame.getContentPane().add(label, BorderLayout.CENTER);
			frame.setContentPane(label);
			frame.pack();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public void painelPets() {
		JPanel painel = new JPanel();
		Border blackline = BorderFactory.createLineBorder(Color.black);
		painel.setBounds(25, 170, 550, 480);
		painel.setBackground(new Color(211, 211, 211));
		painel.setBorder(blackline);
		painel.setLayout(new BorderLayout());
		frame.add(painel);
	}
	
	public void listaTutores() {
		
	}
	
	public void textoPet() {
		JLabel meusPets = new JLabel("Tutores");
		meusPets.setBounds(300, 15, 250, 150);
		meusPets.setFont(new Font("", Font.BOLD, 30));
		meusPets.setForeground(Color.BLACK);
		frame.add(meusPets);
	}

	public void botaoAdicaoTutor() {
		JButton botao = new JButton("Adicionar tutor");
		botao.setBounds(456, 655, 120, 40);
		botao.setActionCommand("adicionartutor");
		botao.addActionListener(this);
		frame.add(botao);

	}
	
	public static void main(String[] args) {
		new TelaPrincipal();
	}
	
	public void botaoVerpet() { //PROVISÓRIO TEM QUE TIRAR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		JButton botao = new JButton("Ver tutor");
		botao.setActionCommand("verpet");
		botao.addActionListener(this);
		botao.setBounds(500, 12, 70, 30);
		frame.add(botao);	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if ("adicionartutor" == e.getActionCommand()) {
			 new TelaCriarTutor();
	         frame.dispose();
	} else if ("verpet" == e.getActionCommand()) {
		 new TelaPerfilTutor();
         frame.dispose();
}
		
	}

}
