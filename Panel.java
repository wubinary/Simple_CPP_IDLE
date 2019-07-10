import java.awt.*;
import javax.swing.*;

public class Panel extends JPanel
{
	Project project;
	JTextPane textPane;
	JScrollPane scrollPane;
	TextLineNumber lineNumber;
	String rout,cppFileName,outputFileName,returnMessage;
	public Panel(Project project)
	{
		super();
		this.project = project;
		textPane = new JTextPane();//(int)project.getHeight()/23,(int)project.getWidth()/12
		textPane.setFont(project.font);
		textPane.setEditable(true);	
		lineNumber = new TextLineNumber(textPane);
		scrollPane = new JScrollPane(textPane);
		scrollPane.setRowHeaderView(lineNumber);
		this.setLayout(new BorderLayout());
		this.add(scrollPane,BorderLayout.CENTER);
		//this.setSize((int)project.getHeight()/1,(int)project.getWidth()/1);
		this.setVisible(true);
	}
}