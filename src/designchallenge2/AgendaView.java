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
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import java.awt.SystemColor;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class AgendaView extends JFrame implements Observer{
	public JTabbedPane tabbedPane;
	public JPanel panel;
	public JPanel panel_1;
	public JScrollPane scrollPane;
	public JTable table;
	public JList list;
	public DefaultListModel<String> agendaList;
	private AgendaModel am;
	private AgendaControl ac;
	public JCalendar calendar;
	public JTextPane txtpnDateselected;
	public JLabel lblTesting;
	public JPanel panel_2;
	private Date dateToday;
	public JButton btnChangeDate;
	public AgendaView() {
		GregorianCalendar gCal = new GregorianCalendar();
//		dateToday = gCal.get(GregorianCalendar.)
		setSize(new Dimension(700, 500));
		setVisible(true);
		getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 0, 664, 262);
		getContentPane().add(tabbedPane);
		
		panel = new JPanel();
		tabbedPane.addTab("Day View", null, panel, null);
		
		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(650, 220));
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
			if(start.get(Calendar.HOUR_OF_DAY) <= 9)
				timeString = "0"+timeString;
			if(start.get(Calendar.MINUTE) <= 9)
				timeString = timeString+"0";
			DefaultTableModel dtm1 = (DefaultTableModel) table.getModel();
			dtm1.addRow(new String[] {timeString,""});
			start.add(Calendar.MINUTE, 30);
		}while(start.getTime().before(end.getTime()));
		
		table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
		table.getColumnModel().getColumn(0).setPreferredWidth(350);
		table.getColumnModel().getColumn(1).setPreferredWidth(350);
		
		scrollPane.setViewportView(table);
		
		panel_1 = new JPanel();
		tabbedPane.addTab("AgendaView", null, panel_1, null);
		
		agendaList = new DefaultListModel<>();
		list = new JList<>(agendaList);
		list.setBackground(SystemColor.control);
		list.setPreferredSize(new Dimension(450, 220));
		panel_1.add(list);
		
		calendar = new JCalendar();
		
		
		calendar.setBounds(10, 273, 198, 153);
		getContentPane().add(calendar);
		
		panel_2 = new JPanel();
		panel_2.setBounds(394, 297, 188, 111);
		getContentPane().add(panel_2);
		
		lblTesting = new JLabel("Testing:");
		panel_2.add(lblTesting);
		
		txtpnDateselected = new JTextPane();
		panel_2.add(txtpnDateselected);
		txtpnDateselected.setEditable(false);
		txtpnDateselected.setText("dateSelected");
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		calendar.getDayChooser().getDayPanel().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtpnDateselected.setText(sdf.format(calendar.getDate()));
			}
		});
		txtpnDateselected.setText(sdf.format(calendar.getDate()));
		
		btnChangeDate = new JButton("Change Date");
		btnChangeDate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtpnDateselected.setText(sdf.format(calendar.getDate()));
			}
		});
		btnChangeDate.setBounds(10, 427, 198, 23);
		getContentPane().add(btnChangeDate);
	}
	
	public void addToAgendaList(String str) {
		agendaList.addElement(str);
	}
	public void updateView(ArrayList<Occasion> occasionsList) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		
		for(int i = 0; i < /*100*/10; i++){
			System.out.println(); //acts like a clear screen. only temporary
		}
		for(Occasion o: occasionsList) {//print out
			if(o instanceof Task) {
				Task t = (Task)o;
				System.out.println("TASK | "+t.getName()+" | "+t.getStrColor()+" | "+sdf.format(t.getStartDate().getTime()));
			}else if(o instanceof Event) {
				Event e = (Event)o;
				System.out.println("EVENT | "+e.getName()+" | "+e.getStrColor()+" | "
									+sdf.format(e.getStartDate().getTime())+" | "+sdf.format(e.getEndDate().getTime()));
			}
		}
		agendaList.removeAllElements();
		for(Occasion o: occasionsList) { //agendaList
			
			if(o instanceof Task) {
				Task t = (Task)o;
				agendaList.addElement("<html> <font color=\""+t.getStrColor()+"\""+">"+sdf.format(t.getStartDate().getTime())+" - "+t.getName()+"</font></html>");
			}else if(o instanceof Event) {
				Event e = (Event)o;
				agendaList.addElement("<html> <font color=\""+e.getStrColor()+"\""+">"+sdf.format(e.getStartDate().getTime())
									+" - "+sdf.format(e.getEndDate().getTime())+" - "+e.getName()
									);
			}
		}
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
		
		for(Occasion o: occasionsList) { //day view
			if(o instanceof Task) {
				Task t = (Task)o;
				String timeStr = timeFormat.format(t.getStartDate().getTime());
				for(int rowNum = 0; rowNum < table.getRowCount(); rowNum++) {
					if(table.getValueAt(rowNum, 0).equals(timeStr)) {
						table.setValueAt("<html> <font color=\""+t.getStrColor()+"\""+">"+t.getName()+"</font></html>", rowNum, 1);
						
					}
				}
			}else if(o instanceof Event) {
				Event e = (Event)o;
				String startTimeStr = timeFormat.format(e.getStartDate().getTime());
				String endTimeStr = timeFormat.format(e.getEndDate().getTime());
				for(int rowNum = 0; rowNum < table.getRowCount();rowNum++) {
					if(table.getValueAt(rowNum, 0).equals(startTimeStr)) {
						table.setValueAt("<html><font color=\""+e.getStrColor()+"\""+">"+e.getName()+" - START"+"</font></html>", rowNum, 1);
						rowNum++;
						while(!table.getValueAt(rowNum, 0).equals(endTimeStr)) {
							table.setValueAt("<html><font color=\""+e.getStrColor()+"\""+">"+"~"+"</font><html>", rowNum, 1);
							rowNum++;
						}
						table.setValueAt("<html><font color=\""+e.getStrColor()+"\""+">"+e.getName()+" - END"+"</font></html>", rowNum, 1);
					}
					
				}
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
