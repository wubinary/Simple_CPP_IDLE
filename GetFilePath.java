import javax.swing.*;
import java.awt.*;

public class GetFilePath extends JFrame
{
	Project project;
	String pathStr,s;
	public GetFilePath(Project project)
	{
		this.project = project;
		JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(false);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (chooser.showOpenDialog(getContentPane()) == JFileChooser.APPROVE_OPTION) 
          pathStr = chooser.getSelectedFile().getAbsolutePath();		
		stringDealing();
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