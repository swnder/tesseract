package com.tesseract.tesseract;

public class TesseractWrapper {

    public static void main(String[] args) {
        String pdfPath = "D:\\RegimenMaquila\\Proyectos\\usandoTesseract\\data\\factura\\204696_FACT_EXP_SERV_404_TELEC.pdf"; // Cambiar la ruta del PDF
        PDFImageToText.extractTextFromPDF(pdfPath);
    }
}

//  String outputImageDir = "D:\\RegimenMaquila\\Proyectos\\usandoTesseract\\data\\img";
