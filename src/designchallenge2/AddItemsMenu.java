package designchallenge2;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class AddItemsMenu extends JFrame{
	private JTextField itemNameInput;
	public AddItemsMenu() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		itemNameInput = new JTextField();
		GridBagConstraints gbc_itemNameInput = new GridBagConstraints();
		gbc_itemNameInput.gridwidth = 3;
		gbc_itemNameInput.insets = new Insets(0, 0, 5, 5);
		gbc_itemNameInput.fill = GridBagConstraints.HORIZONTAL;
		gbc_itemNameInput.gridx = 2;
		gbc_itemNameInput.gridy = 2;
		getContentPane().add(itemNameInput, gbc_itemNameInput);
		itemNameInput.setColumns(10);
		
		JButton btnAddItem = new JButton("Add Item");
		GridBagConstraints gbc_btnAddItem = new GridBagConstraints();
		gbc_btnAddItem.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddItem.gridx = 12;
		gbc_btnAddItem.gridy = 2;
		getContentPane().add(btnAddItem, gbc_btnAddItem);
		
		JLabel startLabel = new JLabel("Start Date & Time");
		GridBagConstraints gbc_startLabel = new GridBagConstraints();
		gbc_startLabel.insets = new Insets(0, 0, 5, 5);
		gbc_startLabel.gridx = 0;
		gbc_startLabel.gridy = 4;
		getContentPane().add(startLabel, gbc_startLabel);
		
		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 4;
		getContentPane().add(comboBox, gbc_comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 4;
		gbc_comboBox_1.gridy = 4;
		getContentPane().add(comboBox_1, gbc_comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.gridx = 6;
		gbc_comboBox_2.gridy = 4;
		getContentPane().add(comboBox_2, gbc_comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		GridBagConstraints gbc_comboBox_3 = new GridBagConstraints();
		gbc_comboBox_3.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_3.gridx = 8;
		gbc_comboBox_3.gridy = 4;
		getContentPane().add(comboBox_3, gbc_comboBox_3);
		
		JLabel endLabel = new JLabel("End Date & Time");
		GridBagConstraints gbc_endLabel = new GridBagConstraints();
		gbc_endLabel.insets = new Insets(0, 0, 0, 5);
		gbc_endLabel.gridx = 0;
		gbc_endLabel.gridy = 6;
		getContentPane().add(endLabel, gbc_endLabel);
		
		JComboBox comboBox_4 = new JComboBox();
		GridBagConstraints gbc_comboBox_4 = new GridBagConstraints();
		gbc_comboBox_4.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_4.gridx = 2;
		gbc_comboBox_4.gridy = 6;
		getContentPane().add(comboBox_4, gbc_comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		GridBagConstraints gbc_comboBox_5 = new GridBagConstraints();
		gbc_comboBox_5.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_5.gridx = 4;
		gbc_comboBox_5.gridy = 6;
		getContentPane().add(comboBox_5, gbc_comboBox_5);
		
		JComboBox comboBox_6 = new JComboBox();
		GridBagConstraints gbc_comboBox_6 = new GridBagConstraints();
		gbc_comboBox_6.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_6.gridx = 6;
		gbc_comboBox_6.gridy = 6;
		getContentPane().add(comboBox_6, gbc_comboBox_6);
		
		JComboBox comboBox_7 = new JComboBox();
		GridBagConstraints gbc_comboBox_7 = new GridBagConstraints();
		gbc_comboBox_7.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_7.gridx = 8;
		gbc_comboBox_7.gridy = 6;
		getContentPane().add(comboBox_7, gbc_comboBox_7);
		JFrame jf = new JFrame();
	}
}
