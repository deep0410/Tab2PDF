package ca.yorku.cse2311.tab2pdf.parser;

import ca.yorku.cse2311.tab2pdf.model.Note;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class NoteParserTest {

    public static final String[] INVALID_LINES = {
            "|-----1-----1-----1-----1-|-----1-----1-----1-----1-|"
            , "-1-----1-----1-----1-|-----1-----1-----1-----1-|"
            , "-----1-----1-----1-|-----1-----1-----1-----1-|"
    };

    public static final String[] VALID_LINES = {
            "1-----1-----1-----1-|-----1-----1-----1-----1-|"
            , "12----1-----1-----1-|-----1-----1-----1-----1-|"
            , "2-----1-----1-----1-|-----1-----1-----1-----1-|"
            , "3-----1-----1-----1-|-----1-----1-----1-----1-|"
            , "4-----1-----1-----1-|-----1-----1-----1-----1-|"
            , "5-----1-----1-----1-|-----1-----1-----1-----1-|"
            , "6-----1-----1-----1-|-----1-----1-----1-----1-|"
            , "7-----1-----1-----1-|-----1-----1-----1-----1-|"
            , "8-----1-----1-----1-|-----1-----1-----1-----1-|"
            , "9-----1-----1-----1-|-----1-----1-----1-----1-|"
            , "0-----1-----1-----1-|-----1-----1-----1-----1-|"
    };

    public static final Note[] VALID_NOTES = {
            new Note("1")
            , new Note("1")
            , new Note("2")
            , new Note("3")
            , new Note("4")
            , new Note("5")
            , new Note("6")
            , new Note("7")
            , new Note("8")
            , new Note("9")
            , new Note("0")
    };

    private NoteParser parser;

    @Before
    public void setUp() {
        parser = new NoteParser();
    }

    @Test
    public void testParseInvalidLines() {

        for (String line : INVALID_LINES) {
            try {

                parser.parse(line);

                fail(); // Fail if we get here, since the lines are invalid, and should produce an Exception

            } catch (ParseException e) {
                /* This Exception should be triggered since we gave the parser invalid lines */
            }
        }
    }

    @Test
    public void testParseValidLines() throws ParseException {

        for (int i = 0; i < VALID_LINES.length; ++i) {

            String line = VALID_LINES[i];


            Note n = parser.parse(line);
            System.out.println(n);
            assertEquals(VALID_NOTES[i], n);

        }
    }

}