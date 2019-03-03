package C15Files;

import java.io.File;

import myjava.ScannerRead;

public class FileDesmostration
{
	public static void main(String[] args)
	{
		ScannerRead l = new ScannerRead();
		
		System.out.println("Enter file or directory name: ");
		analyzePath(l.getInputString());
	}

	public static void analyzePath(String path)
	{
		
		File name = new File (path);
		
		if(name.exists()) //if name exists, output information about it
		{
			// display file (or directory) information
			System.out.printf ("%s%s\n%s\n%s\n%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s",
					name.getName(), " exists",
					(name.isFile() ? "is a file" : "is not a file"),
					(name.isDirectory() ? "is a directory" 
							: "is not a directory"),
					(name.isAbsolute() ? "is absolute path" : 
						"is not absolute path"),"Last modified: ",
					name.lastModified(), "Length: ",name.length(),
					"Path ",name.getPath(), "Absolute Path: ",
					name.getAbsolutePath(), "Parent: ",name.getParent());
			
			if(name.isDirectory())
			{
				String[] directory = name.list();
				System.out.println( "\n\nDirectory contents:\n" );
				
				for (String directoryName : directory)
					System.out.println( directoryName );
			}
		}
		else
		{
			System.out.printf( "%s %s", path, "does not exist." );
		}
	}
}
