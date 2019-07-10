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
			cmd /c dir 是執行完dir命令後關閉命令窗口。
			cmd /k dir 是執行完dir命令後不關閉命令窗口。
              cmd /c start dir /b會打開一個新窗口後執行dir指令，原窗口會關閉。
               cmd /k start dir 會打開一個新窗口後執行dir指令，原窗口不會關閉。
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
			/*cmd /c dir 是執行完dir命令後關閉命令窗口。
			cmd /k dir 是執行完dir命令後不關閉命令窗口。
              cmd /c start dir /b會打開一個新窗口後執行dir指令，原窗口會關閉。
               cmd /k start dir 會打開一個新窗口後執行dir指令，原窗口不會關閉。*/
			Process process = run.exec("cmd /k start " + path);        
			InputStream in = process.getInputStream();
        } 
		catch (Exception e)
		{            
			e.printStackTrace();   
		}   
	}
}