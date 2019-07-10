import java.io.*;
import java.awt.*;
import javax.swing.*;

public class SaveFile
{
	Project project;
	Panel tmpPanel;
	String pathStr,s;
	public SaveFile(Project project,Panel tmpPanel)
	{
		this.project = project;
		this.tmpPanel = tmpPanel;
		try
		{
			SelectedPaneSave();
		}
		catch(Exception e)
		{
			
		}
	}
	public void SelectedPaneSave()throws IOException
	{		
		if(tmpPanel.cppFileName == "UDEFINED")
		{
			saveMap();
			tmpPanel.cppFileName = project.cppFileName;
			tmpPanel.outputFileName = project.ouputFileName;
			tmpPanel.rout = project.rout;
			project.tabPane.setTitleAt(project.tabPane.getSelectedIndex(),tmpPanel.cppFileName);
			FileWriter fileWriter = new FileWriter(tmpPanel.rout + tmpPanel.cppFileName);
			fileWriter.write(tmpPanel.textPane.getText());
			fileWriter.flush();
			fileWriter.close();
		}
		else
		{
			FileWriter fileWriter = new FileWriter(tmpPanel.rout + tmpPanel.cppFileName);
			fileWriter.write(tmpPanel.textPane.getText());
			fileWriter.flush();
			fileWriter.close();
		}		
	}
	public void saveMap() 
	{
		String sb = "TEST CONTENT";
		JFileChooser chooser = new JFileChooser();
		//chooser.setCurrentDirectory(new File("/home/me/Documents"));
		int retrival = chooser.showSaveDialog(null);
		if (retrival == JFileChooser.APPROVE_OPTION)
		{
			try 
			{
				pathStr = chooser.getSelectedFile().getAbsolutePath();
				stringDealing();
			} 
			catch (Exception ex) 
			{
				ex.printStackTrace();
			}
		}
	}
	public void stringDealing()
	{
		project.rout = stringDoubleSlash();
		project.cppFileName = pathStr.substring(pathStr.lastIndexOf("\\")+1);
		project.ouputFileName = pathStr.substring(pathStr.lastIndexOf("\\")+1,pathStr.lastIndexOf("."));		
	}
	public String stringDoubleSlash()
	{
		int i=1;
		s = pathStr.substring( 0, pathStr.lastIndexOf('\\')+1 );
		s = s.replace("\\","\\\\");	
		return s;
	}
}