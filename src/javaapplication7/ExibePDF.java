package javaapplication7;

import javax.swing.*;
import java.io.*;
import com.adobe.acrobat.*;


import java.awt.*;
public class ExibePDF{
	void main(String args){
		InputStream input;
		Viewer viewer;
		JFrame frame = new JFrame("PDF viewer 555555");
		frame.setLayout(new BorderLayout());
		try{
			viewer = new Viewer();
			frame.add(viewer, BorderLayout.CENTER);
			input = new FileInputStream (new File(args));
			if(input != null){
                ByteArrayOutputStream output = new ByteArrayOutputStream();
                // set read buffer size
                byte[] rb = new byte[1024];
                int ch = 0;
                while ((ch = input.read(rb)) != -1){
                    output.write(rb, 0, ch);
                }
                byte[] b = output.toByteArray();
                input.close();
                output.close();
                
                viewer.setDocumentInputStream(new ByteArrayInputStream(b));
			}
                   
                    
			viewer.activate();
                       
                         //viewer.execMenuItem(ViewerCommand.NextPage_K);
                        viewer.execMenuItem(ViewerCommand.FitPage_K);
                        // viewer.execMenuItem(ViewerCommand.PrevPage_K);
                        
                        viewer.setProperty("Default_Page_Layout", "SinglePage");
			viewer.setProperty("Default_Zoom_Type", "FitPage");
			viewer.setProperty("Default_Magnification", "100");
                        viewer.setProperty("Default_page_open","NextPage");
                       System.out.println("Page Count: "+viewer.getPageCount()); 
                       System.out.println("Current Page: "+viewer.getCurrentPage()); 
                       
                      
                     
			frame.setSize(800, 600);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setVisible(true);
                    
                      
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,
                        "can't open file ",
                        "Erro", JOptionPane.ERROR_MESSAGE);
                        System.exit(0);
                        
		}
	}
}