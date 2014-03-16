package program;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kravspesifikasjon.TwitterMelding;

public class GUI extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 128609292020710218L;
	
	JPanel stream;

	public GUI (){	
		super("Twitterstrøm");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		setLayout(new BorderLayout());
		setSize(600, 500);
		
		stream = new JPanel();
		
		
		
		
		setVisible(true);
		
		
	}
	
	public void addTweet(String tweet){
		JLabel nyTweet = new JLabel(tweet);
		add(nyTweet);
		repaint();
	}
	
	public static void main(String[] args) {
		GUI gui = new GUI(); 
		
	}



	
}
