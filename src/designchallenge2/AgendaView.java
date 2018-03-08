package designchallenge2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class AgendaView extends JFrame{
	private AgendaModel am;
	private AgendaControl ac;
	private JTable table;
	
	public AgendaView() {
		setSize(new Dimension(450, 518));
		setVisible(true);
		setTitle("Agenda/Day View");
		setName("");
		setResizable(false);
		JScrollPane scrollPane = new JScrollPane();
		
//		System.out.println("DEBUG");
		String[] columnTitles = {"Time", "Occasion"};
		String[][] rowData = {{"0:00",""},{"0:30",""}};
		table = new JTable(new DefaultTableModel(columnTitles, 0));
		
		Calendar start = Calendar.getInstance();
		start.set(Calendar.HOUR_OF_DAY, 0);
		start.set(Calendar.MINUTE, 0);
		Calendar end = Calendar.getInstance();
		end.set(Calendar.HOUR_OF_DAY, 23);
		end.set(Calendar.MINUTE, 59);
		String timeString = "";
		
		do {
			timeString = Integer.toString(start.get(Calendar.HOUR_OF_DAY))+":"+Integer.toString(start.get(Calendar.MINUTE));
//			if(start.get(Calendar.HOUR_OF_DAY) <= 9)
//				timeString = "0"+timeString;
			if(start.get(Calendar.MINUTE) <= 9)
				timeString = timeString+"0";
			DefaultTableModel dtm = (DefaultTableModel) table.getModel();
			dtm.addRow(new String[] {timeString,""});
			start.add(Calendar.MINUTE, 30);
		}while(start.getTime().before(end.getTime()));
		
		table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth((int) (75*4.5));
		table.setValueAt("Thing3", 1, 1);
//		System.out.println("DEBUG");
//		System.out.println("DEBUG"+table.getColumnModel().getColumn(1).getPreferredWidth());
		scrollPane.setViewportView(table);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		);
		getContentPane().setLayout(groupLayout);
	}

	
	
	public void updateView(ArrayList<Occasion> occasionsList) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		
		for(int i = 0; i < 100; i++){
			System.out.println(); //acts like a clear screen. only temporary
		}
		for(Occasion o: occasionsList) {
			if(o instanceof Task) {
				Task t = (Task)o;
				System.out.println("TASK | "+t.getName()+" | "+t.getStrColor()+" | "+sdf.format(t.getEndDate().getTime()));
			}else if(o instanceof Event) {
				Event e = (Event)o;
				System.out.println("EVENT | "+e.getName()+" | "+e.getStrColor()+" | "
									+sdf.format(e.getStartDate().getTime())+" | "+sdf.format(e.getEndDate().getTime()));
			}
		}
	}
	
	public void attachModel(AgendaModel am) {
		this.am = am;
	}
	public void attachControl(AgendaControl ac) {
		this.ac = ac;
	}
}
