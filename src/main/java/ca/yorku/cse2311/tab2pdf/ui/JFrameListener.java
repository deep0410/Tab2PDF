package ca.yorku.cse2311.tab2pdf.ui;

import javax.swing.*;
import java.io.File;
import java.util.logging.Logger;

/**
 * This is a superclass of all event listeners incorporated in the app
 *
 * Created by Glib Sitiugin on 2015-03-06.
 */
public class JFrameListener {

    private static MainJFrame jFrame;

    private static JTextPane editor = EditorPanel.EDITOR;

    private static File inputFile;

    private static File outputFile;

    private static JLabel symbolsNumber = new JLabel("0");

    //TODO: log all events
    protected final Logger LOGGER = Logger.getLogger(this.getClass().getName());

    /**
     * Constructor
     * @param frame we are working with
     */
    public JFrameListener(MainJFrame frame) {

        jFrame = frame;
        setInputFile(inputFile);
        setOutputFile(outputFile);
        setInputEditor(editor);
    }


    public static File getInputFile() { return inputFile; }

    public static void setInputFile(File file) { inputFile = file; }

    public static File getOutputFile() { return outputFile; }

    public static void setOutputFile(File file) { outputFile = file; }

    protected MainJFrame getJFrame() { return jFrame; }

    protected JTextPane getEditor() { return editor; }

    protected void setInputEditor(JTextPane inputEditor) { editor = inputEditor; }

    /*public int getSymbolsNumber() {

        return getEditor().getText().length();
    }

    public static void setSymbolsNumber(int number) {

        symbolsNumber.setText(String.valueOf(number));
    }*/

}
