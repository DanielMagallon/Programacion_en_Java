package C12GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class MultipleListFrame extends JFrame
{
	private JList colorJList; // list to hold color names
	private JList copyJList; // list to copy color names into
	private JButton copyJButton; // button to copy selected names
	private static final String[] colorNames = { "Black", "Blue", "Cyan",
	 "Dark Gray", "Gray", "Green", "Light Gray", "Magenta", "Orange",
	"Pink", "Red", "White", "Yellow" };
	
	public MultipleListFrame()
	 {
	 super( "Multiple Selection Lists" );
	 setLayout( new FlowLayout() ); 
	
	 colorJList = new JList( colorNames ); 
	 colorJList.setVisibleRowCount( 5 ); 
	 colorJList.setSelectionMode(
			 ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	 
	 add( new JScrollPane( colorJList ) ); 
	 copyJButton = new JButton( "Copy >>>" ); 
	 copyJButton.addActionListener(
	 new ActionListener() 
	 {
	public void actionPerformed( ActionEvent event )
	 {
		copyJList.setListData( colorJList.getSelectedValues());
	 }
	 }
	); 

	add( copyJButton ); 
	
	copyJList = new JList(); 
	
	copyJList.setVisibleRowCount(5);
	copyJList.setFixedCellWidth(100);
	copyJList.setFixedCellHeight(15);
	copyJList.setSelectionMode(
			ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	add(new JScrollPane(copyJList));
	
 }
}
