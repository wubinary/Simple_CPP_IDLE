import javax.swing.*;
import java.util.*;
import java.io.*;

public class projectInstaller extends JFrame
{
	public static void main(String args[])
	{
		String path = "mingw-get-setup.exe";			
		Runtime run = Runtime.getRuntime();   
		/*try 
		{           
			cmd /c dir �O���槹dir�R�O�������R�O���f�C
			cmd /k dir �O���槹dir�R�O�ᤣ�����R�O���f�C
              cmd /c start dir /b�|���}�@�ӷs���f�����dir���O�A�쵡�f�|�����C
               cmd /k start dir �|���}�@�ӷs���f�����dir���O�A�쵡�f���|�����C
			Process process = run.exec("cmd /k start " + path);        
			InputStream in = process.getInputStream();
        } 
		catch (Exception e)
		{            
			e.printStackTrace();   
		}   
		
		*/
		
		path = "set wubinrayIDE=C:\\MinGW\\bin";			
		run = Runtime.getRuntime();   
		try 
		{           
			/*cmd /c dir �O���槹dir�R�O�������R�O���f�C
			cmd /k dir �O���槹dir�R�O�ᤣ�����R�O���f�C
              cmd /c start dir /b�|���}�@�ӷs���f�����dir���O�A�쵡�f�|�����C
               cmd /k start dir �|���}�@�ӷs���f�����dir���O�A�쵡�f���|�����C*/
			Process process = run.exec("cmd /k start " + path);        
			InputStream in = process.getInputStream();
        } 
		catch (Exception e)
		{            
			e.printStackTrace();   
		}   
	}
}