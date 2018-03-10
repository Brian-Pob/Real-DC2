package designchallenge2;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;

public class NewAgendaView extends JFrame {
	public JTabbedPane tabbedPane;
	public JPanel panel;
	public JPanel panel_1;
	public JScrollPane scrollPane;
	public JTable table;
	public JList list;
	public DefaultListModel<String> agendaList;
	private AgendaModel am;
	private AgendaControl ac;
	public NewAgendaView() {
		
		setSize(new Dimension(700, 500));
		setVisible(true);
		getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(184, 0, 490, 262);
		getContentPane().add(tabbedPane);
		
		panel = new JPanel();
		tabbedPane.addTab("Day View", null, panel, null);
		
		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(475, 220));
		panel.add(scrollPane);
		String[] columnTitles = {"Time", "Occasion"};
		DefaultTableModel dtm  = new DefaultTableModel(columnTitles,0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		
		table = new JTable(dtm);
		
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
			DefaultTableModel dtm1 = (DefaultTableModel) table.getModel();
			dtm1.addRow(new String[] {timeString,""});
			start.add(Calendar.MINUTE, 30);
		}while(start.getTime().before(end.getTime()));
		
		table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(350);
		
		scrollPane.setViewportView(table);
		
		panel_1 = new JPanel();
		tabbedPane.addTab("AgendaView", null, panel_1, null);
		
		agendaList = new DefaultListModel<>();
		list = new JList<>(agendaList);
		list.setPreferredSize(new Dimension(400, 220));
		panel_1.add(list);
	}
	
	public void addToAgendaList(String str) {
		agendaList.addElement(str);
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
//	public static void main(String[] args) {
//		NewAgendaView tv2 = new NewAgendaView();
//		tv2.addToAgendaList("Hello World");
//	}
	public void attachModel(AgendaModel am) {
		this.am = am;
	}
	public void attachControl(AgendaControl ac) {
		this.ac = ac;
	}
}
