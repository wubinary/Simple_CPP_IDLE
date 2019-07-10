import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Project extends JFrame implements ActionListener
{
	int test;
	static int panelCount = 0;
	static JTabbedPane tabPane;
	static JTextArea textArea,errorArea;
	static JScrollPane errorScrollPane,textScrollpane;	
	static Project project;
	static Panel panel[] = new Panel[10];
	static ErrorMessagePanel errorMessagePanel;
	static Font font = new Font("Serif", Font.BOLD, 20);;
	Compiler compiler;
	Run run;
	String rout,cppFileName,ouputFileName,returnMessage;
	public static void main(String args[])
	{
		project = new Project();		
		project.setSize(500,500);
		project.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);		
		project.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		project.setJMenuBar(new IdeMenu(project));
		project.setLayout(new BorderLayout());
		errorMessagePanel = new ErrorMessagePanel(project);

		project.add(errorMessagePanel,BorderLayout.SOUTH);
		project.add(tabPane,BorderLayout.CENTER);
		//project.add(textScrollpane);
		//project.add(errorScrollPane);			
		project.setVisible(true);
	}
	public Project()
	{
		super("IDE");				
		tabPane = new JTabbedPane();		
		tabPane.setTabPlacement(JTabbedPane.TOP);
	}
	public void actionPerformed(ActionEvent e)
	{		
	}
}