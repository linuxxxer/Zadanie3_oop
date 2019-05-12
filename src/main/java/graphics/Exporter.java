package graphics;

import zad2.sk.stuba.fei.oop.generated.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;

/*
 * Exportovanie petrinetu do XML
 */
public class Exporter {

    public void exporting(Document document, String pathToFile){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Document.class);

            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(document, new File(pathToFile));

        } catch(Exception e){
            e.printStackTrace();
        }
    }

}
