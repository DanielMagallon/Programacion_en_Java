package Ayuda;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class Compilar
{
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws IOException
	{
		System.setProperty("java.home", "C:/Program Files/Java/jdk1.8.0_151/jre");
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//		int res = compiler.run(null, null, null, "C:/Users/edgar/Desktop/Eje.java");
//		System.out.println(res);
		String sourceFile = "C:/Users/edgar/Desktop/Eje.java";
	    //Obtenemos manejador estandar de ficheros
		StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
 
	    List sourceFileList = new ArrayList();
	    sourceFileList.add(new File(sourceFile));
	    Iterable compilationUnits = fileManager
	        .getJavaFileObjectsFromFiles(sourceFileList);
	    //Obtenemos la tarea de compilaci�n a ejecutar posteriormente
	    CompilationTask task = compiler.getTask(null, fileManager, null, null, null, compilationUnits);
	    //Ejecutamos la tarea
	    boolean result = task.call();
	    if (result) 
	      System.out.println("La compilaci�n ha sido exitosa");
	    else 
	      System.out.println("La compilaci�n ha fallado");
 
	    fileManager.close();
	}
}
