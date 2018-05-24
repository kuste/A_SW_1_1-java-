import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class DataForm extends JPanel {
	private JLabel namelbl;
	private JLabel citylbl;
	private JLabel maillbl;
	private JTextField nameField;
	private JTextField cityField;
	private JTextField mailField;
	private JButton cnfbtn;
	private DataFormListener dfl;

	public DataForm() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);
		setBorders();
		createFormComp();
		layoutComp();
		activateBtn();
	}

	private void setBorders() {
		Border inner = BorderFactory.createTitledBorder("Input data");
		Border outer = BorderFactory.createEmptyBorder(5, 5, 5, 5);

		setBorder(BorderFactory.createCompoundBorder(outer, inner));
	}

	private void createFormComp() {
		namelbl = new JLabel("Name: ");
		citylbl = new JLabel("City: ");
		maillbl = new JLabel("Mail: ");
		cityField = new JTextField(10);
		mailField = new JTextField(10);
		nameField = new JTextField(10);
		cnfbtn = new JButton("Confirm");

	}

	private void layoutComp() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 0.1;
		/////////////////// first rwo ///////////////////

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		add(namelbl, gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(nameField, gbc);
		////////////////////// second row//////////////////
		gbc.weighty = 0.1;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_END;
		add(citylbl, gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(cityField, gbc);

		////////////////////// third row//////////////////
		gbc.weighty = 0.1;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_END;
		add(maillbl, gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(mailField, gbc);

		////////////////////// last row//////////////////
		gbc.weighty = 2;
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(cnfbtn, gbc);

	}

	private void activateBtn() {
		cnfbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String city = cityField.getText();
				String mail = mailField.getText();
				
				DataFormEvent dfe = new DataFormEvent(this, name, city, mail);
				
				if(dfl!=null) {
					dfl.dataEventOccured(dfe);
				}

			}
		});

		
	}
	public void setDataFormListener(DataFormListener listener) {
		this.dfl = listener;
	}
}
