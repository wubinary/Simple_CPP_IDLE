import javax.swing.*;
import java.awt.*;
import java.io.*;
public class OpenFile
{
	Project project;
	String pathStr,s;
	public OpenFile(Project project)
	{
		this.project = project;
		GetFilePath getFilePath = new GetFilePath(project);
		System.out.print(project.rout+"\n"+project.cppFileName+"\n"+project.ouputFileName+"\n");
		readFile();
	}
	/*public static void main(String args[])
	{
		OpenFile openFile = new OpenFile(new Project());
	}*/
	public void readFile()
	{
		BufferedReader br;
		try 
		{
			br = new BufferedReader(new FileReader(project.rout+project.cppFileName));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			newPanel();
			while (line != null)
			{
				System.out.print(line+"\n");/////////////////
				project.panel[project.panelCount].textPane.setText(project.panel[project.panelCount].textPane.getText()+line+"\n");
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			String everything = sb.toString();
			project.panelCount++ ;
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			//br.close();
		}	
	}
	public void newPanel()
	{
		project.panel[project.panelCount] = new Panel(project);
		project.panel[project.panelCount].cppFileName = project.cppFileName;
		project.panel[project.panelCount].outputFileName = project.ouputFileName;
		project.panel[project.panelCount].rout = project.rout;	
		project.tabPane.addTab(project.panel[project.panelCount].cppFileName, project.panel[project.panelCount]);
		project.tabPane.setSelectedIndex(project.panelCount);
	}
	
}