package gus06.entity.gus.appli.entityhistory.gui.history.viewer;

import gus06.framework.*;
import javax.swing.JComponent;
import java.util.Map;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class EntityImpl implements Entity, I, P {

	public String creationDate() {return "20150501";}


	private Service tab;
	private Service persist;
	private Service buildFreqMap;
	private Service regroup4;
	private Service regroup6;
	private Service chartDays;
	private Service chartMonths;
	private Service chartYears;
	private Service timeTable;
	
	private JPanel panel;
	private JLabel labelNumber;
	private JTable tableDays;
	private JTable tableMonths;
	private JTable tableYears;
	private JTable table1;
	
	private Map map;
	
	

	public EntityImpl() throws Exception
	{
		tab = Outside.service(this,"*gus.swing.tabbedpane.holder1");
		persist = Outside.service(this,"gus.swing.tabbedpane.persister.tab");
		buildFreqMap = Outside.service(this,"gus.map.intmap.build.freqmap");
		regroup4 = Outside.service(this,"gus.map.intmap.regroup.subkey4");
		regroup6 = Outside.service(this,"gus.map.intmap.regroup.subkey6");
		chartDays = Outside.service(this,"*gus.appli.entityhistory.gui.chart.days");
		chartMonths = Outside.service(this,"*gus.appli.entityhistory.gui.chart.months");
		chartYears = Outside.service(this,"*gus.appli.entityhistory.gui.chart.years");
		timeTable = Outside.service(this,"*gus.appli.entityhistory.gui.timetable");
		
		
		labelNumber = new JLabel(" ");
		
		tableDays = (JTable) chartDays.i();
		tableMonths = (JTable) chartMonths.i();
		tableYears = (JTable) chartYears.i();
		table1 = (JTable) timeTable.i();
		
		tab.v("GUI_chart#Days",new JScrollPane(tableDays));
		tab.v("GUI_chart#Months",new JScrollPane(tableMonths));
		tab.v("GUI_chart#Years",new JScrollPane(tableYears));
		tab.v("GUI_timetable#Time table",new JScrollPane(table1));
		
		panel = new JPanel(new BorderLayout());
		panel.add((JComponent) tab.i(),BorderLayout.CENTER);
		panel.add(labelNumber,BorderLayout.SOUTH);
		
		persist.v(getClass().getName()+"_tab",tab.i());
	}
	
	
	public Object i() throws Exception
	{return panel;}
	
	
	
	
	public void p(Object obj) throws Exception
	{
		map = (Map) obj;
		
		if(map==null)
		{
			chartDays.p(null);
			chartMonths.p(null);
			chartYears.p(null);
			timeTable.p(null);
			
			labelNumber.setText(" ");
			return;
		}
		
		Map days = (Map) buildFreqMap.t(map);
		Map months = (Map) regroup6.t(days);
		Map years = (Map) regroup4.t(months);
		
		chartDays.p(days);
		chartMonths.p(months);
		chartYears.p(years);
		timeTable.p(days);
		
		labelNumber.setText(" Number: "+map.size());
	}
}
