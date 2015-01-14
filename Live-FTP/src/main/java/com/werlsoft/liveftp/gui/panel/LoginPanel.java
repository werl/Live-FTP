package com.werlsoft.liveftp.gui.panel;

import java.awt.GridBagLayout;

import javax.swing.JTextField;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import com.werlsoft.liveftp.ftp.FTPSession;

public class LoginPanel extends BasePanel implements ActionListener, Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -581089231200934872L;

	public JTextField hostNameBox;
	public JTextField userNameBox;

	private JPasswordField passwordBox;

	private JSpinner portSpinner;

	private JLabel hostNameLable;
	private JLabel portLable;
	private JLabel userNameLable;
	private JLabel passwordLable;

	private JButton loginButton;

	public FTPSession session;

	private Thread thread;

	private int tabCounter;

	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		this.thread = new Thread(this, "tab " + tabCounter);
		this.thread.start();
	}

	@Override
	public void run() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 100, 57, 0, 100, 0, 100, 0 };
		gridBagLayout.rowHeights = new int[] { 44, 34, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 1.0,
				0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		hostNameLable = new JLabel("Host Name");
		GridBagConstraints gbc_hostNameLable = new GridBagConstraints();
		gbc_hostNameLable.gridwidth = 2;
		gbc_hostNameLable.fill = GridBagConstraints.VERTICAL;
		gbc_hostNameLable.insets = new Insets(0, 0, 5, 5);
		gbc_hostNameLable.gridx = 0;
		gbc_hostNameLable.gridy = 0;
		add(hostNameLable, gbc_hostNameLable);

		hostNameBox = new JTextField();
		GridBagConstraints gbc_hostNameBox = new GridBagConstraints();
		gbc_hostNameBox.gridwidth = 2;
		gbc_hostNameBox.fill = GridBagConstraints.BOTH;
		gbc_hostNameBox.insets = new Insets(0, 0, 0, 5);
		gbc_hostNameBox.gridx = 0;
		gbc_hostNameBox.gridy = 1;
		add(hostNameBox, gbc_hostNameBox);
		hostNameBox.setColumns(10);

		portLable = new JLabel("Port");
		GridBagConstraints gbc_portLable = new GridBagConstraints();
		gbc_portLable.fill = GridBagConstraints.VERTICAL;
		gbc_portLable.insets = new Insets(0, 0, 5, 5);
		gbc_portLable.gridx = 2;
		gbc_portLable.gridy = 0;
		add(portLable, gbc_portLable);

		portSpinner = new JSpinner();
		portSpinner.setModel(new SpinnerNumberModel(21, 1, 65535, 1));
		GridBagConstraints gbc_portSpinner = new GridBagConstraints();
		gbc_portSpinner.fill = GridBagConstraints.BOTH;
		gbc_portSpinner.insets = new Insets(0, 0, 0, 5);
		gbc_portSpinner.gridx = 2;
		gbc_portSpinner.gridy = 1;
		add(portSpinner, gbc_portSpinner);

		userNameLable = new JLabel("Username");
		GridBagConstraints gbc_userNameLable = new GridBagConstraints();
		gbc_userNameLable.gridwidth = 2;
		gbc_userNameLable.fill = GridBagConstraints.VERTICAL;
		gbc_userNameLable.insets = new Insets(0, 0, 5, 5);
		gbc_userNameLable.gridx = 3;
		gbc_userNameLable.gridy = 0;
		add(userNameLable, gbc_userNameLable);

		userNameBox = new JTextField();
		GridBagConstraints gbc_userNameBox = new GridBagConstraints();
		gbc_userNameBox.gridwidth = 2;
		gbc_userNameBox.fill = GridBagConstraints.BOTH;
		gbc_userNameBox.insets = new Insets(0, 0, 0, 5);
		gbc_userNameBox.gridx = 3;
		gbc_userNameBox.gridy = 1;
		add(userNameBox, gbc_userNameBox);
		userNameBox.setColumns(10);

		passwordLable = new JLabel("Password");
		GridBagConstraints gbc_passwordLable = new GridBagConstraints();
		gbc_passwordLable.fill = GridBagConstraints.VERTICAL;
		gbc_passwordLable.insets = new Insets(0, 0, 5, 5);
		gbc_passwordLable.gridx = 5;
		gbc_passwordLable.gridy = 0;
		add(passwordLable, gbc_passwordLable);

		passwordBox = new JPasswordField();
		GridBagConstraints gbc_passwordBox = new GridBagConstraints();
		gbc_passwordBox.gridwidth = 2;
		gbc_passwordBox.fill = GridBagConstraints.BOTH;
		gbc_passwordBox.gridx = 5;
		gbc_passwordBox.gridy = 1;
		add(passwordBox, gbc_passwordBox);

		loginButton = new JButton("Login");
		loginButton.setEnabled(true);
		loginButton.addActionListener(this);
		GridBagConstraints gbc_loginButton = new GridBagConstraints();
		gbc_loginButton.insets = new Insets(0, 0, 5, 0);
		gbc_loginButton.fill = GridBagConstraints.BOTH;
		gbc_loginButton.gridx = 6;
		gbc_loginButton.gridy = 0;
		add(loginButton, gbc_loginButton);
		this.updateUI();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().matches("Login")) {
			String hostname = this.hostNameBox.getText();
			int port = (Integer) this.portSpinner.getValue();
			String username = this.userNameBox.getText();
			char[] password = this.passwordBox.getPassword();

			if (hostname.matches("") || username.matches("")
					|| password.length == 0)
				System.out.println("test");
			else {
				this.session = new FTPSession(hostname, port, username,
						password);
				this.session.connect();
			}
		}
	}

	@Override
	public String getPanelID() {
		return "Login";
	}

}
