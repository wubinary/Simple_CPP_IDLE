import java.awt.*;
import javax.swing.*;

public class ErrorMessagePanel extends JPanel
{
	Project project;
	JTextArea textArea;
	JScrollPane scrollPane;
	public ErrorMessagePanel(Project project)
	{
		super();
		this.project = project;
		textArea = new JTextArea(7,project.getWidth()/3);
		textArea.append("ERROR MESSAGES :");
		textArea.setEditable(false);
		scrollPane = new JScrollPane(textArea);
		this.add(scrollPane);
		this.setVisible(true);
	}
	public void setErrorMessagePanel(String s)
	{
		textArea.setText(s);
	}
}