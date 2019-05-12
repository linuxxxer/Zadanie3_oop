package graphics;

import zadanie3part.ModeButton;
import zadanie3part.buttons.Clear;
import zadanie3part.buttons.Open;
import zadanie3part.buttons.Save;
import zadanie3part.listeners.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * Trieda na implementovanie Frame-u.
 * Ma za ulohu zvladat otvorenie JFileChooseru pomocou tlacidla 'openButton'
 * Riadi transformacie
 */
public class NetsFrame extends Frame {

//    inicializacia prvkov okna
    private ModeButton addTransButton;
    private ModeButton addPlaceButton;
    private ModeButton addArcButton;
    private ModeButton addResetButton;
    private ModeButton removeButton;
    private ModeButton interactButton;
    private ModeButton setLabelButton;
    private ModeButton reSetPositionButton;
    private final Save saveButton;
    private final Open openButton;
    private final Clear clearButton;

    private final Panel toolbar;
    private final NetsCanvas canvas;


    public NetsFrame() throws HeadlessException {
        super("Zadanie 3 - Petri Net Editor");

//        Nastavenie framu
        setLayout(new BorderLayout());
        setVisible(true);

//        nastavenie panelu na tlacidla
        toolbar = new Panel(new FlowLayout(FlowLayout.LEFT));
        toolbar.setBackground(Color.DARK_GRAY);

//        Nastavenie canvasu
        canvas = new NetsCanvas(null);
        canvas.setBackground(Color.GRAY);

//        Nastavenie tlacidiel
        addTransButton = new ModeButton(new ImageIcon(Class.class.getResource("/transition.png")), canvas, new TransitionAddListener(canvas));
        addPlaceButton = new ModeButton(new ImageIcon(Class.class.getResource("/place.png")), canvas, new PlaceAddListener(canvas));
        addArcButton = new ModeButton(new ImageIcon(Class.class.getResource("/arc.png")), canvas, new ArcAddListener(canvas));
        addResetButton = new ModeButton(new ImageIcon(Class.class.getResource("/resetarc.png")), canvas, new ResetArcAddListener(canvas));
        removeButton = new ModeButton(new ImageIcon(Class.class.getResource("/remove.png")), canvas, new RemoveObjektListener(canvas));
        interactButton = new ModeButton(new ImageIcon(Class.class.getResource("/interact.png")), canvas, new InteractionListener(canvas));
        setLabelButton = new ModeButton(new ImageIcon(Class.class.getResource("/label.png")), canvas, new SetLabelListener(canvas));
        reSetPositionButton = new ModeButton(new ImageIcon(Class.class.getResource( "/resetposition.png")), canvas, new ResetPositionListener(canvas));
        openButton = new Open();
        saveButton = new Save();
        clearButton = new Clear();

        canvas.setFocusable(false);
        openButton.setFocusable(false);
        saveButton.setFocusable(false);
        clearButton.setFocusable(false);

        toolbar.add(openButton);
        toolbar.add(saveButton);
        toolbar.add(clearButton);
        toolbar.add(interactButton);
        toolbar.add(addTransButton);
        toolbar.add(addPlaceButton);
        toolbar.add(addArcButton);
        toolbar.add(addResetButton);
        toolbar.add(setLabelButton);
        toolbar.add(reSetPositionButton);
        toolbar.add(removeButton);


//        nastavenie listenereov na open, save a clear tlacidla
//        tieto tlacidla nefunguju na principe ModeButton,
//          takze listenery sa nastavuju vzlast
        openButton.addActionListener(e -> {
            openButton.performAction(canvas.getPetriNet(), canvas);
            canvas.repaint();
        });

        saveButton.addActionListener(e -> {
            saveButton.performAction(canvas.getPetriNet(), canvas);
        });

        clearButton.addActionListener(e -> {
            if (canvas.getPetriNet() != null) {
                clearButton.performAction(canvas.getPetriNet(), canvas);
                JOptionPane.showMessageDialog(canvas, "Petri net successfully cleared!");
                canvas.repaint();
            } else {
                JOptionPane.showMessageDialog(canvas, "      Nothing to clear");
            }
        });


        this.add(toolbar, BorderLayout.PAGE_START);
        this.add(canvas, BorderLayout.CENTER);

        setSize(800, 600);

//      nastavovanie keylistenerov
//        CTRL + Q - zatvaranie okna
//        CTRL + S - dialogove okno ulozenia
//        CTRL + O - dialogove okno otvarania
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Q) {
                    int result = JOptionPane.showConfirmDialog(canvas, "Really quit?");
                    if (result == JOptionPane.YES_OPTION) {
                        dispose();
                    }
                }
                if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S) {
                    saveButton.performAction(canvas.getPetriNet(), canvas);
                    canvas.repaint();
                }
                if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_O) {
                    openButton.performAction(canvas.getPetriNet(), canvas);
                    canvas.repaint();
                }
            }
        });

//        window listener na zatvaranie
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int result = JOptionPane.showConfirmDialog(canvas, "Really quit?");
                if (result == JOptionPane.YES_OPTION) {
                    dispose();
                }
            }
        });


    }
}