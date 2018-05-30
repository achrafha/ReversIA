package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class GUIreversi extends JFrame implements ActionListener {

	private JPanel boardPanel;
	private JPanel main;
	private JComboBox playerOneCombo;
	private JComboBox playerTwoCombo;

	private JButton[][] buttons;
	private int[][] board;

	public GUIreversi() {
		this.board = new int[8][8];
		mockBoard();
		initUI();
		this.setVisible(true);

	}

	public void mockBoard() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				this.board[i][j] = 0;
			}
		}
		this.board[3][3] = -1;
		this.board[4][4] = -1;
		this.board[3][4] = 1;
		this.board[4][3] = 1;
	}

	public void initUI() {
		JPanel main = new JPanel();

		main.setBackground(new Color(34, 49, 63));
		main.setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("ReversIA");

		boardPanel = new JPanel();
		boardPanel.setBackground(new Color(34, 49, 63));
		//boardPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		boardPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
		boardPanel.setLayout(new GridLayout(8, 8, 1, 1));

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

					boardPanel.add(this.buttons[i][j]);
				} else {
					this.buttons[i][j] = new JButton();
					this.buttons[i][j].setBackground(new Color(1, 152, 117));

					boardPanel.add(this.buttons[i][j]);
				}
				buttons[i][j].setBorder(new LineBorder(Color.WHITE));
				buttons[i][j].addActionListener(this);

			}
			boardPanel.setVisible(true);
		}
		boardPanel.setSize(600, 600);
		boardPanel.setMaximumSize(new Dimension(600, 600));
		boardPanel.setMinimumSize(new Dimension(600, 600));
		boardPanel.setPreferredSize(new Dimension(600, 600));

		main.add(boardPanel);

		JPanel configuration = new JPanel();
		TitledBorder confTitle;
		confTitle = BorderFactory.createTitledBorder("Configuration");
		configuration.setBorder(confTitle);
		configuration.setPreferredSize(new Dimension(320, 560));
		configuration.setBackground(Color.WHITE);
		configuration.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.NORTH;

		/* White player label */
		JPanel whiteLabel = new JPanel();
		whiteLabel.setBackground(Color.WHITE);

		whiteLabel.setLayout(new javax.swing.BoxLayout(whiteLabel, javax.swing.BoxLayout.X_AXIS));
		whiteLabel.setBorder(new EmptyBorder(0, 10, 0, 0));// top,left,bottom,right
		JLabel wp = new JLabel("White Player:", SwingConstants.LEFT);
		wp.setVerticalAlignment(JLabel.CENTER);
		whiteLabel.add(wp);
		whiteLabel.setPreferredSize(new Dimension(300, 40));

		/* Black player label */
		JPanel blackLabel = new JPanel();
		blackLabel.setBackground(Color.WHITE);

		blackLabel.setLayout(new javax.swing.BoxLayout(blackLabel, javax.swing.BoxLayout.X_AXIS));
		blackLabel.setBorder(new EmptyBorder(0, 10, 0, 0));// top,left,bottom,right
		JLabel bp = new JLabel("Black Player:", SwingConstants.LEFT);
		bp.setVerticalAlignment(JLabel.CENTER);
		blackLabel.add(bp);
		blackLabel.setPreferredSize(new Dimension(300, 40));

		JPanel WhiteComboBox = new JPanel();
		WhiteComboBox.setBackground(Color.WHITE);

		Object[] elements = new Object[] { "Element 1", "Element 2", "Element 3", "Element 4", "Element 5" };
		playerOneCombo = new JComboBox<Object>(elements);
		playerOneCombo.setPrototypeDisplayValue("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		playerOneCombo.setMaximumSize(playerOneCombo.getPreferredSize());
		WhiteComboBox.add(playerOneCombo);
		WhiteComboBox.setPreferredSize(new Dimension(300, 40));

		JPanel blackComboBox = new JPanel();
		blackComboBox.setBackground(Color.WHITE);

		Object[] elements2 = new Object[] { "Element 1", "Element 2", "Element 3", "Element 4", "Element 5" };
		playerTwoCombo = new JComboBox<Object>(elements2);
		playerTwoCombo.setPrototypeDisplayValue("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		playerTwoCombo.setMaximumSize(playerOneCombo.getPreferredSize());
		blackComboBox.add(playerTwoCombo);
		blackComboBox.setPreferredSize(new Dimension(300, 40));

		JPanel delay = new JPanel();
		delay.setBackground(Color.WHITE);
		GridLayout gridLayout = new GridLayout(0, 3);
		delay.setLayout(gridLayout);
		JLabel delayLabel = new JLabel("Delay");
		delayLabel.setBorder(new EmptyBorder(0, 10, 0, 0));// top,left,bottom,right
		delay.add(delayLabel);
		JSpinner m_numberSpinner;
		SpinnerNumberModel m_numberSpinnerModel;
		Double current = new Double(30);
		Double min = new Double(3);
		Double max = new Double(90);
		Double step = new Double(1);
		m_numberSpinnerModel = new SpinnerNumberModel(current, min, max, step);
		m_numberSpinner = new JSpinner(m_numberSpinnerModel);
		m_numberSpinner.setPreferredSize(new Dimension(20, 20));
		delay.add(m_numberSpinner);
		JLabel seconde = new JLabel("s.");
		seconde.setBorder(new EmptyBorder(0, 10, 0, 0));// top,left,bottom,right
		delay.add(seconde);
		delay.setPreferredSize(new Dimension(300, 30));

		JPanel controlStatus = new JPanel();
		controlStatus.setBackground(Color.WHITE);

		FlowLayout gridLayout2 = new FlowLayout();
		controlStatus.setLayout(gridLayout2);
		JButton b = new JButton("Start");
		b.setBackground(new Color(0, 214, 144));
		b.setPreferredSize(new Dimension(80, 30));
		controlStatus.add(b);
		JButton b1 = new JButton("Pause");
		b1.setPreferredSize(new Dimension(80, 30));
		b1.setBackground(new Color(249, 193, 55));
		controlStatus.add(b1);
		JButton b2 = new JButton("End");
		b2.setBackground(new Color(255, 80, 57));
		b2.setPreferredSize(new Dimension(80, 30));
		controlStatus.add(b2);

		controlStatus.setPreferredSize(new Dimension(300, 40));

		JPanel stats = new JPanel();
		stats.setBackground(Color.WHITE);
		TitledBorder title1;
		title1 = BorderFactory.createTitledBorder("Statistics");
		stats.setBorder(title1);
		stats.setPreferredSize(new Dimension(300, 200));

		JPanel s = new JPanel();
		s.setBackground(Color.WHITE);
		GridLayout experimentLayout = new GridLayout(0, 3);
		experimentLayout.setHgap(40);
		experimentLayout.setVgap(20);
		s.setLayout(experimentLayout);
		s.add(new JLabel(""));
		JLabel labelW = new JLabel("◻");
		JLabel labelB = new JLabel("◼");
		labelW.setFont(new Font("Serif", Font.PLAIN, 16));
		labelB.setFont(new Font("Serif", Font.PLAIN, 16));
		s.add(labelB);
		s.add(labelW);
		s.add(new JLabel("Count"));
		s.add(new JLabel("10"));
		s.add(new JLabel("3"));
		s.add(new JLabel("Turn"));
		JLabel turn = new JLabel("⚫");
		turn.setFont(new Font("Serif", Font.PLAIN, 16));
		turn.setForeground(Color.RED);
		s.add(turn);
		s.add(new JLabel(""));
		s.add(new JLabel("fail"));
		s.add(new JLabel("0"));
		s.add(new JLabel("1"));
		s.add(new JLabel("Time"));
		s.add(new JLabel("1:20"));
		s.add(new JLabel("2:20"));
		stats.add(s);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		configuration.add(whiteLabel, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		configuration.add(WhiteComboBox, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridheight = 1;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		configuration.add(blackLabel, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridheight = 1;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		configuration.add(blackComboBox, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridheight = 1;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		configuration.add(delay, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;

		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridheight = 1;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.VERTICAL;
		configuration.add(controlStatus, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;

		JSeparator sep = new JSeparator(JSeparator.HORIZONTAL);
		sep.setPreferredSize(new Dimension(280, 1));
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridheight = 1;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.VERTICAL;
		configuration.add(sep, gbc);

		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridheight = 1;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.VERTICAL;
		JPanel p = new JPanel();
		p.setBackground(Color.WHITE);

		// p.add(new JLabel("Statistics:"));
		p.setPreferredSize(new Dimension(300, 40));
		configuration.add(p, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;

		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.gridheight = 1;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.PAGE_END; // bottom of space
		gbc.insets = new Insets(30, 0, 0, 0); // top padding

		gbc.fill = GridBagConstraints.VERTICAL;
		configuration.add(stats, gbc);
		main.add(configuration, BorderLayout.WEST);

		JPanel moves = new JPanel();
		moves.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 100)); 

		moves.setBackground(Color.WHITE);

		moves.setPreferredSize(new Dimension(270, 560));
		moves.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		TitledBorder title;
		title = BorderFactory.createTitledBorder("Moves");
		moves.setBorder(title);
		String data[][] = { { "1", "Black", "d3" }, { "2", "White", "d6" }, { "3", "White", "pass" } };
		String column[] = { "N°", "Color", "Move" };
		JTable jt = new JTable(data, column);
		jt.setPreferredScrollableViewportSize(jt.getPreferredSize());
		jt.setFillsViewportHeight(true);
		jt.setPreferredSize(new Dimension(270,560));
		jt.setFocusable(false);
		jt.setRowSelectionAllowed(false);
		jt.setCellSelectionEnabled(false);
		jt.getTableHeader().setReorderingAllowed(false);
		//jt.setBounds(30, 40, 30, 50);
		JScrollPane sp = new JScrollPane(jt);
		moves.add(sp,BorderLayout.CENTER);
		main.add(moves, BorderLayout.EAST);
		
		JPanel pp = new JPanel();
		pp.setBackground(new Color(34, 49, 63));
		main.add(pp, BorderLayout.EAST);

		add(main);
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		main.setVisible(true);

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
