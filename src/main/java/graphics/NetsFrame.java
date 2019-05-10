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

    private final Panel buttonPanel;
    private final NetsCanvas canvas;

    public NetsFrame() throws HeadlessException {
        super("Zadanie 2");

//        Setting up the frame
        setLayout(new BorderLayout());
        setVisible(true);

//        Setting up the panel for the buttons
        buttonPanel = new Panel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setBackground(Color.DARK_GRAY);

//        Setting up the canvas
        canvas = new NetsCanvas(null);
        canvas.setBackground(Color.GRAY);

//        Setting up the buttons
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

        buttonPanel.add(openButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(interactButton);
        buttonPanel.add(addTransButton);
        buttonPanel.add(addPlaceButton);
        buttonPanel.add(addArcButton);
        buttonPanel.add(addResetButton);
        buttonPanel.add(setLabelButton);
        buttonPanel.add(reSetPositionButton);
        buttonPanel.add(removeButton);

        openButton.addActionListener(e -> {
            openButton.performAction(canvas.getPetriNet(), canvas);
            canvas.repaint();
        });

        saveButton.addActionListener(e -> saveButton.performAction(canvas.getPetriNet(), canvas));

        clearButton.addActionListener(e -> {
            if (canvas.getPetriNet() != null) {
                clearButton.performAction(canvas.getPetriNet(), canvas);
                canvas.repaint();
            } else {
                JOptionPane.showMessageDialog(canvas, "      Nothing to clear");
            }
        });


        this.add(buttonPanel, BorderLayout.PAGE_START);
        this.add(canvas, BorderLayout.CENTER);

        setSize(800, 600);

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