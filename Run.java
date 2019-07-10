import javax.swing.*;
import java.util.*;
import java.io.*;

public class Run
{
	static String returnMessage,path;
	Project project;
	Panel tmpPanel;
	public Run(Project project)
	{		
		this.project = project;
		tmpPanel = (Panel)project.tabPane.getSelectedComponent();
		//String path = ".\\¦w¸Ë¥]G++\\MinGW64\\bin\\g++ " + rout +"\\"+ cppFileName + " -o "  + rout + "\\" + outputFileName;			
		path=tmpPanel.rout+tmpPanel.outputFileName+".exe";//".//test.exe ";
		sendRunCommand(path);
	}
	public void sendRunCommand(String path)
	{
		Runtime run = Runtime.getRuntime();   
		try 
		{   
			Process process = run.exec("cmd /k start " + path);        
			InputStream in = process.getInputStream();
        } 
		catch (Exception e)
		{            
			e.printStackTrace();   
		}   
	}
}