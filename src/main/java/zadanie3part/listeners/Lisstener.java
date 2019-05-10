package zadanie3part.listeners;

import graphics.NetsCanvas;

import java.awt.event.MouseAdapter;

public class Lisstener extends MouseAdapter {

    private NetsCanvas canvas;

    public Lisstener(NetsCanvas canvas) {
        this.canvas = canvas;
    }

    public NetsCanvas getCanvas() {
        return this.canvas;
    }
}
