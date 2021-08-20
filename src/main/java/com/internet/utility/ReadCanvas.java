package com.internet.utility;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadCanvas {

    /*The Tessaract Library should be installed on the System in order to run the use Tess4j on MacOS and
    * Some setting needs to be done additionally to add these lib of Tessaract to Tess4j file path
    * cp /usr/local/Cellar/tesseract/4.1.1/lib/libtesseract.4.dylib darwin/libtesseract.dylib
    * */
    ITesseract image;

    public String readImageText(String filePath){
        image = new Tesseract();
        String imageText = null;
        try {
            imageText = image.doOCR(new File(filePath));
            imageText = imageText.split(":")[1].replaceAll("[^a-zA-Z0-9]","");
        } catch (TesseractException e) {
            e.printStackTrace();
        }
        return imageText;
    }

    public String captureCanvasImage(WebElement element){
        File src = element.getScreenshotAs(OutputType.FILE);
        String path = "src/test/resources/screenshots/canvas.png";
        File canvasImage = new File(path);
        try {
            FileHandler.copy(src,canvasImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(path);
        return path;
    }

}
