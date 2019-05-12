package graphics;

import zad2.sk.stuba.fei.oop.generated.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/*
 * Importovanie petrinetu z XML
 */

public class Importer {

    public Document importing(String pathToFile){
        try {
            File file                   =  new File(pathToFile);

            InputStream resource        =  new FileInputStream(file.getAbsolutePath());
            JAXBContext context         =  JAXBContext.newInstance(Document.class);
            Unmarshaller unmarshaller   =  context.createUnmarshaller();

            return (Document) unmarshaller.unmarshal(resource);
        } catch ( JAXBException e){
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}