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
import javax.swing.JRadioButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

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
	private JPanel panel_4;
	private JTextPane textPane;
	private JRadioButton rdbtnAllItems;
	private JRadioButton rdbtnTasksOnly;
	private JRadioButton rdbtnEventsOnly;
	public AgendaView(AgendaModel am) {
		this.am = am;
		am.attachView(this);
		GregorianCalendar gCal = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat sdfh = new SimpleDateFormat("MM/dd/yyyy HH:mm");
//		dateToday = gCal.get(GregorianCalendar.)
		setSize(new Dimension(700, 500));
		setResizable(false);
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
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2) {
					if(table.getSelectedColumn()!=0) {
						System.out.println(sdf.format(dateToday)+" "+table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()-1));
						ArrayList<Occasion> occ = am.importOccasions();
						for(Occasion o: occ) {
							
								
							if(sdfh.format(o.getStartDate().getTime()).equals(sdf.format(dateToday)+" "+table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()-1))) {
								o.setIsDone(true);
								if(rdbtnAllItems.isSelected()) {
									am.exportOccasions(occ);
									am.updateViews(sdf.format(dateToday), "all");
									break;
								}
								else if(rdbtnTasksOnly.isSelected()) {
									am.exportOccasions(occ);
									am.updateViews(sdf.format(dateToday), "task");
									break;
								}
								else if(rdbtnEventsOnly.isSelected()) {
									am.exportOccasions(occ);
									am.updateViews(sdf.format(dateToday), "event");
									break;
								}
							}
							
						}
					}
					
					else {
						System.out.println(sdf.format(dateToday)+" "+table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));
					}
				}
				
			}
		});
		
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
		table.getColumnModel().getColumn(0).setPreferredWidth(275);
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
		
		dateToday = calendar.getDate();
		calendar.setBounds(10, 273, 198, 153);
		getContentPane().add(calendar);
		
		panel_2 = new JPanel();
		panel_2.setBounds(558, 273, 116, 177);
		getContentPane().add(panel_2);
		
		lblTesting = new JLabel("Date:");
		panel_2.add(lblTesting);
		
		txtpnDateselected = new JTextPane();
		panel_2.add(txtpnDateselected);
		txtpnDateselected.setEditable(false);
		txtpnDateselected.setText("dateSelected");
		
		calendar.getDayChooser().getDayPanel().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dateToday = calendar.getDate();
				txtpnDateselected.setText(sdf.format(dateToday));
				if(rdbtnAllItems.isSelected())
					am.updateViews(sdf.format(dateToday), "all");
				else if(rdbtnTasksOnly.isSelected())
					am.updateViews(sdf.format(dateToday), "task");
				else if(rdbtnEventsOnly.isSelected())
					am.updateViews(sdf.format(dateToday), "event");
			}
		});
		txtpnDateselected.setText(sdf.format(calendar.getDate()));
		
		JLabel lblTodoItems = new JLabel("To-do items:");
		panel_2.add(lblTodoItems);
		
		textPane = new JTextPane();
		textPane.setPreferredSize(new Dimension(20, 20));
		textPane.setEditable(false);
		textPane.setName("itemsToday");
		panel_2.add(textPane);
		textPane.setText(Integer.toString(this.toDoCount()));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 426, 198, 35);
		getContentPane().add(panel_3);
		
		JButton btnNewButton = new JButton("Change Date");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dateToday = calendar.getDate();
				txtpnDateselected.setText(sdf.format(dateToday));
				if(rdbtnAllItems.isSelected()) {
					am.updateViews(sdf.format(dateToday), "all");
				}
				else if(rdbtnTasksOnly.isSelected()) {
					am.updateViews(sdf.format(dateToday), "task");
				}
				else if(rdbtnEventsOnly.isSelected()) {
					am.updateViews(sdf.format(dateToday), "event");
					}
			}
		});
		panel_3.add(btnNewButton);
		
		panel_4 = new JPanel();
		panel_4.setBounds(218, 273, 164, 177);
		getContentPane().add(panel_4);
		
		rdbtnAllItems = new JRadioButton("All Items");
		
		rdbtnAllItems.setSelected(true);
		
		rdbtnTasksOnly = new JRadioButton("Tasks Only");
		
		rdbtnEventsOnly = new JRadioButton("Events Only");
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnAllItems, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnTasksOnly, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnEventsOnly, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(7)
					.addComponent(rdbtnAllItems)
					.addGap(3)
					.addComponent(rdbtnTasksOnly)
					.addGap(3)
					.addComponent(rdbtnEventsOnly))
		);
		panel_4.setLayout(gl_panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(392, 273, 156, 177);
		getContentPane().add(panel_5);
		
		JButton btnDeleteOccasion = new JButton("Delete Item");
		btnDeleteOccasion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<Occasion> occ = am.importOccasions();
				for(Occasion o:occ) {
					if(sdfh.format(o.getStartDate().getTime()).equals(sdf.format(dateToday)+" "+table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()-1))) {
						am.removeOccasion(o);
						break;
					}
				}
			}
		});
		
		JButton btnMarkDone = new JButton("Mark Done");
		btnMarkDone.setPreferredSize(new Dimension(89, 23));
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnMarkDone, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnDeleteOccasion, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(34))
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(53)
					.addComponent(btnDeleteOccasion)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnMarkDone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(67))
		);
		panel_5.setLayout(gl_panel_5);
		
		rdbtnAllItems.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				if(!rdbtnAllItems.isSelected()) {
					rdbtnTasksOnly.setSelected(false);
					rdbtnEventsOnly.setSelected(false);
					am.updateViews(sdf.format(dateToday), "all");
//				}
//				else {
//					rdbtnAllItems.setSelected(true);
//				}
			}
		});
		
		rdbtnTasksOnly.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				if(!rdbtnTasksOnly.isSelected()) {
					rdbtnAllItems.setSelected(false);
					rdbtnEventsOnly.setSelected(false);
					am.updateViews(sdf.format(dateToday), "task");
//				}
//				else {
//					rdbtnTasksOnly.setSelected(true);
//				}
			}
		});
		
		rdbtnEventsOnly.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				if(!rdbtnEventsOnly.isSelected()) {
					rdbtnTasksOnly.setSelected(false);
					rdbtnAllItems.setSelected(false);
					am.updateViews(sdf.format(dateToday), "event");
//				}
//				else {
//					rdbtnEventsOnly.setSelected(true);
//				}
			}
		});
		
		
		
	}
	
	public void addToAgendaList(String str) {
		agendaList.addElement(str);
	}
	public void updateView(ArrayList<Occasion> occasionsList) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		
		for(int i = 0; i < /*100*/10; i++){
			System.out.println(); //acts like a clear screen. only temporary
		}
//		System.out.println("DEBUG VIEW START");
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
//		System.out.println("DEBUG VIEW END");
		agendaList.removeAllElements();
		for(Occasion o: occasionsList) { //agendaList
			
			if(o instanceof Task) {
				Task t = (Task)o;
				if(!t.IsDone())	
					agendaList.addElement("<html> <font color=\""+t.getStrColor()+"\""+">"+sdf.format(t.getStartDate().getTime())+" - "+t.getName()+"</font></html>");
				else
					agendaList.addElement("<html> <font color=\""+t.getStrColor()+"\""+"><span style='text-decoration: line-through;'>"+sdf.format(t.getStartDate().getTime())+" - "+t.getName()+"</span></font></html>");
			}else if(o instanceof Event) {
				Event e = (Event)o;
				if(!e.IsDone())
					agendaList.addElement("<html> <font color=\""+e.getStrColor()+"\""+">"+sdf.format(e.getStartDate().getTime())
									+" - "+sdf.format(e.getEndDate().getTime())+" - "+e.getName()+"</font></html>"
									);
				else
					agendaList.addElement("<html> <font color=\""+e.getStrColor()+"\""+"><span style='text-decoration: line-through;'>"+sdf.format(e.getStartDate().getTime())
					+" - "+sdf.format(e.getEndDate().getTime())+" - "+e.getName()+"</span></font></html>"
					);
			}
		}
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
		for(int i = 0; i < table.getRowCount(); i++)
			table.setValueAt("", i, 1);
		for(Occasion o: occasionsList) { //day view
			if(o instanceof Task) {
				Task t = (Task)o;
				String timeStr = timeFormat.format(t.getStartDate().getTime());
				for(int rowNum = 0; rowNum < table.getRowCount(); rowNum++) {
					if(table.getValueAt(rowNum, 0).equals(timeStr)) {
						if(!t.IsDone())
							table.setValueAt("<html> <font color=\""+t.getStrColor()+"\""+">"+t.getName()+"</font></html>", rowNum, 1);
						else
							table.setValueAt("<html> <font color=\""+t.getStrColor()+"\""+"><span style='text-decoration: line-through;'>"+t.getName()+"</span></font></html>", rowNum, 1);
						
					}
				}
			}else if(o instanceof Event) {
				Event e = (Event)o;
				String startTimeStr = timeFormat.format(e.getStartDate().getTime());
				String endTimeStr = timeFormat.format(e.getEndDate().getTime());
				for(int rowNum = 0; rowNum < table.getRowCount();rowNum++) {
					if(table.getValueAt(rowNum, 0).equals(startTimeStr)) {
						if(!e.IsDone())
							table.setValueAt("<html><font color=\""+e.getStrColor()+"\""+">"+e.getName()+" - START"+"</font></html>", rowNum, 1);
						else
							table.setValueAt("<html><font color=\""+e.getStrColor()+"\""+"><span style='text-decoration: line-through;'>"+e.getName()+" - START"+"</span></font></html>", rowNum, 1);
						rowNum++;
						while(!table.getValueAt(rowNum, 0).equals(endTimeStr)) {
							table.setValueAt("<html><font color=\""+e.getStrColor()+"\""+">"+"~"+"</font><html>", rowNum, 1);
							rowNum++;
						}
						if(!e.IsDone())
							table.setValueAt("<html><font color=\""+e.getStrColor()+"\""+">"+e.getName()+" - END"+"</font></html>", rowNum, 1);
						else
							table.setValueAt("<html><font color=\""+e.getStrColor()+"\""+"><span style='text-decoration: line-through;'>"+e.getName()+" - END"+"</span></font></html>", rowNum, 1);
					}
					
				}
			}
		}
		this.countUpdate();
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
	
	public JRadioButton getRdbtnAllItems() {
		return rdbtnAllItems;
	}

	public JRadioButton getRdbtnTasksOnly() {
		return rdbtnTasksOnly;
	}

	public JRadioButton getRdbtnEventsOnly() {
		return rdbtnEventsOnly;
	}
	public String getDateTodayStr() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		return sdf.format(dateToday);
	}
	
	public int toDoCount() {
		int counter = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		if(this.am != null) {
			ArrayList<Occasion> occasions = am.importOccasions();
			if(occasions != null) {
				ArrayList<Occasion> tasks = am.filterType("task", occasions);
				//tasks = am.filterDate(sdf.format(dateToday), tasks);
				for(Occasion o : tasks) {
//					System.out.println(o.getName());
					if(o.IsDone()==false) {
						counter++;
					}
				}
			}
			
		}
//		System.out.println(counter);
		return counter;
	}
	
	public void countUpdate() {
		this.textPane.setText(Integer.toString(this.toDoCount()));
	}
}
