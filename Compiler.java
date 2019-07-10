import javax.swing.*;
import java.util.*;
import java.io.*;

public class Compiler
{
	String returnMessage,path;
	Runtime run;
	Project project;
	Panel tmpPanel;
	public Compiler(Project project)
	{				
		this.project = project;
		//String path = ".\\安裝包G++\\MinGW64\\bin\\g++ " + rout +"\\"+ cppFileName + " -o "  + rout + "\\" + outputFileName;	
		tmpPanel = (Panel)project.tabPane.getSelectedComponent();
		SaveFile saveFile = new SaveFile(project,tmpPanel);
		path=".\\安裝包G++\\MinGW64\\bin\\g++ " + tmpPanel.rout + tmpPanel.cppFileName + " -o " + tmpPanel.rout + tmpPanel.outputFileName;
		//path="javac";
		sendCompileCommand(path);
	}
	public void sendCompileCommand(String path)
	{
		run = Runtime.getRuntime();   
		try 
		{   
			StringBuilder sb = new StringBuilder();
			String strtmp;
			//Process process = run.exec("cmd /k start " + path);        
			Process process = run.exec(path);        
			BufferedReader	bufferedReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));	
			System.out.print("1");
			while ((strtmp = bufferedReader.readLine()) != null) 
			{
				System.out.print("1");
				sb.append(strtmp + "\n");
				System.out.print(strtmp);
			} 
			returnMessage = sb.toString();
			System.out.print(returnMessage);
			if(this.returnMessage != "  ")
				JOptionPane.showMessageDialog(null,this.returnMessage);
			project.test = 1;
			project.errorMessagePanel.setErrorMessagePanel(this.returnMessage);
        } 
		catch (Exception e)
		{            
			e.printStackTrace();   
		}   
	}
}