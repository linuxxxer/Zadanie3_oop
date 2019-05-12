package zadanie3part.buttons;

import fromzad1.PetriNet;
import graphics.NetsCanvas;
import zad2.sk.stuba.fei.oop.DrawableTransformer;
import zad2.sk.stuba.fei.oop.PetriNetTransformer;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;

/*
 * Kliknutim na tlacidla sa otvori dialogove okno otvarania XML suboru.
 * Po vybrati sa subor nacita
 */

public class Open extends JButton implements ButtonInterface<Void, PetriNet, NetsCanvas>{

    public Open(){
        this.setBackground(Color.WHITE);
        this.setIcon(new ImageIcon(Class.class.getResource("/open.png")));
    }

    @Override
    public Void performAction(PetriNet petriNet, NetsCanvas canvas){
        FileNameExtensionFilter filter = new FileNameExtensionFilter("XML file", "XML");
        JFileChooser jf = new JFileChooser();
        jf.setFileFilter(filter);
        int returnVal = jf.showOpenDialog(canvas);
        if (returnVal == JFileChooser.APPROVE_OPTION) {

            PetriNetTransformer petriNetTransformer = new PetriNetTransformer();
            petriNet = petriNetTransformer.transformFromXML(jf.getSelectedFile().getAbsolutePath());

            DrawableTransformer drawableTransformer = new DrawableTransformer(petriNet);
            canvas.load(drawableTransformer.transformFromXML(jf.getSelectedFile().getAbsolutePath()));

            canvas.loadPetriNet(petriNet);
            canvas.load(new DrawableTransformer(petriNet).transformPetrinetToDrawable(petriNet));
            canvas.searchTheBiggestID();
        }
        return null;
    }
}
