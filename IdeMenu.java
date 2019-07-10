import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IdeMenu extends JMenuBar implements ActionListener
{
	static Project project;
	static JMenu menu0,menu1,menu2;
	static JMenuItem menu0item0,menu0item1,menu1item0,menu1item1,menu1item2,menu2item0;
	
	/*
	public static void main(String args[])
	{
		frame = new JFrame("MenuSample Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		IdeMenu menu = new IdeMenu(new Project());
		frame.setJMenuBar(menu);
		frame.setSize(350, 250);
		frame.setVisible(true);
	}*/
	
	public IdeMenu(Project project)
	{		
		this.project = project;
	
		// Menu0
		menu0 = new JMenu("File");		menu0.setMnemonic(KeyEvent.VK_F);   
		// Menu0's Items
		menu0item0 = new JMenuItem("New", KeyEvent.VK_N);	    menu0.add(menu0item0);		menu0item0.addActionListener(this);    menu0item0.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		menu0item1 = new JMenuItem("Open");	      menu0.add(menu0item1);		menu0item1.addActionListener(this);	     menu0item1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
		
		// Menu1
		menu1 = new JMenu("Execute");		menu1.setMnemonic(KeyEvent.VK_E);
		// Menu1's Items
		menu1item0 = new JMenuItem(" compile", KeyEvent.VK_C);    menu1.add(menu1item0);   menu1item0.addActionListener(this);  menu1item0.setIcon(new ImageIcon(".//source//compileIcon.jpg")); menu1item0.setAccelerator(KeyStroke.getKeyStroke("F5"));    
		menu1item1 = new JMenuItem(" run", KeyEvent.VK_R);    menu1.add(menu1item1);   menu1item1.addActionListener(this);	menu1item1.setIcon(new ImageIcon(".//source//runIcon.jpg")); 	menu1item1.setAccelerator(KeyStroke.getKeyStroke("F6"));
		menu1item2 = new JMenuItem(" compile and run", KeyEvent.VK_G);    menu1.add(menu1item2);		menu1item2.addActionListener(this);		menu1item2.setIcon(new ImageIcon(".//source//compileandrunIcon.jpg")); 	menu1item2.setAccelerator(KeyStroke.getKeyStroke("F7"));
		
		// Menu2
		menu2 = new JMenu("Save");
		// Menu2's Items
		menu2item0 = new JMenuItem(" save this file", KeyEvent.VK_S);    menu2.add(menu2item0);   menu2item0.addActionListener(this);  menu2item0.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
		//menu2item0 = new JMenuItem(" save all", KeyEvent.VK_S);    menu1.add(menu1item0);   menu1item0.addActionListener(this); 
		
		this.add(menu0);
		this.add(menu1);
		this.add(menu2);
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == menu0item0)
		{		
			System.out.print("1"); //flag
			project.panel[project.panelCount] = new Panel(project);
			project.panel[project.panelCount].cppFileName = "UDEFINED";
			project.tabPane.addTab(project.panel[project.panelCount].cppFileName, project.panel[project.panelCount]);
			project.tabPane.setSelectedIndex(project.panelCount);
			//project.add(project.panel,BorderLayout.EAST);
			project.panelCount++;
			project.setVisible(true);				
		}
		if(e.getSource() == menu0item1)
		{
			OpenFile openfile = new OpenFile(project);			
		}
		if(e.getSource() == menu1item0)
		{
			project.compiler = new Compiler(project);		
		}
		if(e.getSource() == menu1item1)
		{
			project.run = new Run(project);	
		}
		if(e.getSource() == menu1item2)
		{
			project.compiler = new Compiler(project);		
			project.run = new Run(project);	
		}
        if(e.getSource() == menu2item0)
		{
			Panel tmpPanel = (Panel)project.tabPane.getSelectedComponent();
			SaveFile saveFile = new SaveFile(project,tmpPanel);
		}
    }
}