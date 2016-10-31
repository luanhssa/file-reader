package app;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class App {

	AppPanel panel;
	
	App() {
		panel = new AppPanel();
	}

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		App app = new App();
		app.start();
	}
	
	public void start() {
		//System.out.println("Hello World");
		JFrame frame = new JFrame("Nome do Aplicativo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setLayout(new BorderLayout());
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.setSize(panel.getPreferredSize());
		frame.setVisible(true);
		frame.setResizable(false);

		frame.pack();
		frame.setVisible(true);
	}
	
	public class AppPanel extends JPanel implements ActionListener {

		JTextArea text;
		JButton button;
		JFileChooser chooser;
		String choosertitle;
		Font fontDefault;
		
		public AppPanel() {
			text = new JTextArea();
			button = new JButton("Browse");
			button.addActionListener(this);
			choosertitle = "Choose a directory";
			text.setPreferredSize(new Dimension(350, 20));
			fontDefault = new Font("Verdana", Font.PLAIN, 12);
			text.setFont(fontDefault);
			add(text, BorderLayout.WEST);
			add(button, BorderLayout.EAST);
		}

		public Dimension getPreferredSize(){
			return new Dimension(450, 30);
		}

		public void actionPerformed(ActionEvent e) {            
			chooser = new JFileChooser(); 
			chooser.setCurrentDirectory(new java.io.File("."));
			chooser.setDialogTitle(choosertitle);
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

			if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
				System.out.println("getCurrentDirectory(): " 
						+  chooser.getCurrentDirectory());
				System.out.println("getSelectedFile() : " 
						+  chooser.getSelectedFile());
				text.setText(chooser.getSelectedFile().getAbsolutePath());
			}
			else {
				System.out.println("No Selection ");
			}
		}
	}
}
