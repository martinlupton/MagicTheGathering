package view;

import java.awt.Dimension;
import java.awt.GridLayout;


import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends JFrame{

	private static final long serialVersionUID = 7704761091317274700L;

	public Board(){
		super();
		
		setName("Magic The Gathering");
		setSize(new Dimension(1000, 500));
		setLocationRelativeTo(null);
		
		JPanel menuPane = new JPanel();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(5,1));
		setVisible(true);
		add(new JPanel());
		add(new JPanel());
		add(menuPane);
		
	}
	
}
