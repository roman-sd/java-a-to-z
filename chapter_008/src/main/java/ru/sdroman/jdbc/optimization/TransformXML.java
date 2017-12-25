package ru.sdroman.jdbc.optimization;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

/**
 * @author sdroman
 * @since 12.2017
 */
public class TransformXML {

    /**
     * Converts xml file using xslt.
     *
     * @param inputFile  source xml file
     * @param outputFile result xml
     * @param style      xsl
     */
    public void transformer(String inputFile, String outputFile, String style) {
        File target = new File(style);
        TransformerFactory factory = TransformerFactory.newInstance();
        Source xslt = new StreamSource(target);
        try {
            Transformer transformer = factory.newTransformer(xslt);
            Source xmlSource = new StreamSource(new File(inputFile));
            Result outputTarget = new StreamResult(new File(outputFile));
            transformer.transform(xmlSource, outputTarget);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
