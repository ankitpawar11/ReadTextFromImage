package tests;

import java.io.File;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class ReadIImage {

	public static void main(String[] args) throws TesseractException {
		ITesseract it = new Tesseract();
		
		it.setDatapath("C:\\myProgram\\tessdata");
		String result = it.doOCR(new File("C:\\Users\\ankit.pawar\\Downloads\\AutomateLead.png"));
       
		System.out.println("This is image text" +result);

	}

}
