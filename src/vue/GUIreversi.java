package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GUIreversi extends JFrame implements ActionListener {

	private JPanel panel;
	private JButton[][] buttons;
	private int[][] board;

	public GUIreversi() {
		this.board = new int[8][8] ; 
		mockBoard();
		initUI();
		this.setVisible(true);

		
	}
	
	public void mockBoard() {
		for(int i=0; i<8 ;i++) {
			for(int j=0; j<8 ;j++) {
				this.board[i][j] = 0;
			}
		}
		this.board[3][3] = -1;
		this.board[4][4] = -1;
		this.board[3][4] = 1;
		this.board[4][3] =1;
	}
	

	public void initUI() {
		panel = new JPanel();

		panel.setBorder(BorderFactory.createEmptyBorder(2, 2,2, 2));
		panel.setLayout(new GridLayout(8, 8, 5, 5));

		this.buttons = new JButton[8][8];

		for (int i = 0; i < this.board.length; i++) {
			for (int j = 0; j < this.board[i].length; j++) {
				if (this.board[i][j] != 0) {
					this.buttons[i][j] = new JButton();
					if (board[i][j] == -1)
						buttons[i][j].setBackground(Color.BLACK);
					else {
						buttons[i][j].setBackground(Color.WHITE);
					}

					panel.add(this.buttons[i][j]);
				} else {
					this.buttons[i][j] = new JButton();
					this.buttons[i][j].setBackground(new Color(7, 153, 146));

					panel.add(this.buttons[i][j]);
				}
				buttons[i][j].addActionListener(this);

			}
			panel.setVisible(true);
		}

		add(panel);

		setTitle("Othello");
		setSize(600, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GUIreversi q = new GUIreversi();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
