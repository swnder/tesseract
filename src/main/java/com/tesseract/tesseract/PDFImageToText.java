package com.tesseract.tesseract;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

public class PDFImageToText {
    
    public static void extractTextFromPDF(String pdfPath) {
        try {
            PDDocument document = PDDocument.load(new File(pdfPath));
            PDFRenderer pdfRenderer = new PDFRenderer(document);
            Tesseract tesseract = new Tesseract();
            tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata"); // Cambiar la ruta según tu configuración
            
            String text = "";
            
            for (int page = 0; page < document.getNumberOfPages(); ++page) {
                BufferedImage bim = pdfRenderer.renderImageWithDPI(page, 300);
                File tempFile = File.createTempFile("pdf-image-", ".png");
                ImageIO.write(bim, "png", tempFile);
                text = tesseract.doOCR(tempFile); // Extrae el texto y lo guarda en la variable text
                // visualizamos el contenido
                System.out.println("Texto extraído de la página " + (page + 1) + ": \n" + text);
                System.out.println(".....PAGINA SIGUIENTE.....\n ");
                             
                
                tempFile.delete(); // Borra el archivo temporal creado
            }
            System.out.println("obtenemos: "+text);
            document.close();
        } catch (IOException | TesseractException e) {
            e.printStackTrace();
        }
    }
}
