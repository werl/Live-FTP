package com.werlsoft.liveftp.gui.panel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextPane;

public class EditorTabPanel extends BasePanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3124070756027636042L;

	/**
	 * Create the panel.
	 */
	public EditorTabPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JTextPane loggerPane = new JTextPane();
		GridBagConstraints gbc_loggerPane = new GridBagConstraints();
		gbc_loggerPane.fill = GridBagConstraints.BOTH;
		gbc_loggerPane.gridx = 0;
		gbc_loggerPane.gridy = 0;
		add(loggerPane, gbc_loggerPane);

	}

	@Override
	public String getPanelID() {
		return "EditorTabPanel";
	}

}
