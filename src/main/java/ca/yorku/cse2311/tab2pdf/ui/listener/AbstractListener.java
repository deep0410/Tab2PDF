package ca.yorku.cse2311.tab2pdf.ui.listener;

import ca.yorku.cse2311.tab2pdf.ui.MainJFrame;

import java.io.File;
import java.util.logging.Logger;

/**
 * This is a superclass of all event listeners incorporated in the app
 *
 * Created by Glib Sitiugin on 2015-03-06.
 */
public abstract class AbstractListener {

    private static MainJFrame jFrame;

    private static File inputFile;

    private static File outputFile;

    protected final Logger LOGGER = Logger.getLogger(this.getClass().getName());

    /**
     * Constructor
     * @param frame we are working with
     */
    public AbstractListener(MainJFrame frame) {

        jFrame = frame;
        setInputFile(inputFile);
        setOutputFile(outputFile);
    }


    public static File getInputFile() { return inputFile; }

    public static void setInputFile(File file) { inputFile = file; }

    public static File getOutputFile() { return outputFile; }

    public static void setOutputFile(File file) { outputFile = file; }

    protected MainJFrame getJFrame() { return jFrame; }

    public abstract void enableComponents();

}
