package com.werlsoft.liveftp.gui.panel;
import javax.swing.JTabbedPane;
import java.awt.GridBagLayout;
import javax.swing.JLayeredPane;
import java.awt.GridBagConstraints;

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
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		add(tabbedPane, gbc_tabbedPane);

	}

	@Override
	public String getPanelID() {
		return "EditorTabPanel";
	}

}
