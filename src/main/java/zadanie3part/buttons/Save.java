package zadanie3part.buttons;

import fromzad1.PetriNet;
import graphics.NetsCanvas;
import zad2.sk.stuba.fei.oop.DocumentTransformer;
import zad2.sk.stuba.fei.oop.generated.Document;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;

/*
* When clicked on this button, you will be able to set the location and the filename where you want to save.
*/

public class Save extends JButton implements ButtonInterface<Document, PetriNet, NetsCanvas> {

    public Save(){
        this.setBackground(Color.WHITE);
        this.setIcon(new ImageIcon(Class.class.getResource("/save.png")));
    }

    @Override
    public Document performAction(PetriNet petriNet, NetsCanvas netsCanvas) {
        FileNameExtensionFilter filter = new FileNameExtensionFilter("XML file", "XML");
        JFileChooser jf = new JFileChooser();
        jf.setFileFilter(filter);

        int retVal = jf.showSaveDialog(netsCanvas);

        if (retVal == JFileChooser.APPROVE_OPTION){

            DocumentTransformer documentTransformer = new DocumentTransformer();
            return documentTransformer.transformToXML(petriNet, jf.getSelectedFile().getAbsolutePath());
        }
        return null;
    }
}
