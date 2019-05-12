package zadanie3part.buttons;

import fromzad1.PetriNet;
import graphics.NetsCanvas;
import zad2.sk.stuba.fei.oop.DrawableTransformer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/*
 * Kliknutim na toto tlacidlo, program vymaze cely Petri Net.
 */

public class Clear extends JButton implements MouseListener, ButtonInterface<Void, PetriNet, NetsCanvas> {


    public Clear(){
        this.setBackground(Color.WHITE);
        this.setIcon(new ImageIcon(Class.class.getResource("/clear.png")));
    }

    @Override
    public Void performAction(PetriNet petriNet, NetsCanvas netsCanvas) {
        int result = JOptionPane.showConfirmDialog(netsCanvas, "Clear everything?");

        if (result == JOptionPane.YES_OPTION) {
            if (petriNet != null) {
                netsCanvas.loadPetriNet(petriNet.clearPetriNet());
                netsCanvas.load(new DrawableTransformer(petriNet).transformPetrinetToDrawable(petriNet));
                netsCanvas.searchTheBiggestID();
                netsCanvas.repaint();
                return null;
            }
        }
        return null;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
