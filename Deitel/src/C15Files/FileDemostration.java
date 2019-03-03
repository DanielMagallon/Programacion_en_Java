package C15Files;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FileDemostration extends JFrame
{
	private JTextArea outputArea;
	private JScrollPane scrollPane;
	private JButton openFile;
	
	public FileDemostration()
	{
		super ("Testing class File");
		
		openFile = new JButton("Open File");
		outputArea=new  JTextArea();
		
		scrollPane = new JScrollPane(outputArea);
		
		add(scrollPane, BorderLayout.CENTER);
		add(openFile, BorderLayout.SOUTH);
		
		open();
		setSize(400,400);
		setVisible(true);
		
	}
	
	private void open()
	{
		openFile.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				analyzePath();
				
			}
		});
	}
	
	private File getFileOrDirectory()
	{
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(
				JFileChooser.FILES_AND_DIRECTORIES);
		
		int result = fileChooser.showOpenDialog(this);
		
		if (result==JFileChooser.CANCEL_OPTION)
			System.exit(1);
		
		File fileName = fileChooser.getSelectedFile();
		
		if (fileName == null || fileName.getName().equals(""))
		{
			JOptionPane.showMessageDialog(this, "Invalid Name",
					"Invalid Name",JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
		
		return fileName;
		
	}	
	
	private void analyzePath()
	{
		File name = getFileOrDirectory();
		
		if ( name.exists() ) // if name exists, output information about it
		{
		
		outputArea.setText( String.format(
		 "%s%s\n%s\n%s\n%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s",
		name.getName(), " exists",
		( name.isFile() ? "is a file" : "is not a file" ),
		( name.isDirectory() ? "is a directory" :
		"is not a directory" ),
		( name.isAbsolute() ? "is absolute path" :
		"is not absolute path" ), "Last modified: ",
		name.lastModified(), "Length: ", name.length(),
		"Path: ", name.getPath(), "Absolute path: ",
		name.getAbsolutePath(), "Parent: ", name.getParent() ) );
		
		if ( name.isDirectory() ) // output directory listing
		{
		 String[] directory = name.list();
		 outputArea.append( "\n\nDirectory contents:\n" );
		
		 for ( String directoryName : directory )
		 outputArea.append( directoryName + "\n" );
		} 
		} 
		
		 else 
		 {
			 JOptionPane.showMessageDialog( this, name +
					 " does not exist.", "ERROR", JOptionPane.ERROR_MESSAGE );
		 }
	}
}
