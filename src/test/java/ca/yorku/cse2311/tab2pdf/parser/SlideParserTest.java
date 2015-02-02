package ca.yorku.cse2311.tab2pdf.parser;

import ca.yorku.cse2311.tab2pdf.model.Slide;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SlideParserTest {

    /**
     * None of these lines should parse into a Note
     */
    public static final String[] INVALID_LINES = {
            "|-----1-----1-----1-----1-|-----1-----1-----1-----1-|"
            , "-1-----1-----1-----1-|-----1-----1-----1-----1-|"
            , "12-----1-----1-----1-|-----1-----1-----1-----1-|"
    };

    /**
     * All of these lines should parse into a note
     */
    public static final String[] VALID_LINES = {
            "0s1-----1-----1-----1-|-----1-----1-----1-----1-|"
            , "1s2----1-----1-----1-|-----1-----1-----1-----1-|"
            , "2s3-----1-----1-----1-|-----1-----1-----1-----1-|"
            , "3s4-----1-----1-----1-|-----1-----1-----1-----1-|"
            , "4s5-----1-----1-----1-|-----1-----1-----1-----1-|"
            , "5s6-----1-----1-----1-|-----1-----1-----1-----1-|"
            , "6s7-----1-----1-----1-|-----1-----1-----1-----1-|"
            , "7s8-----1-----1-----1-|-----1-----1-----1-----1-|"
            , "8s9-----1-----1-----1-|-----1-----1-----1-----1-|"
            , "9s10-----1-----1-----1-|-----1-----1-----1-----1-|"
            , "10s0-----1-----1-----1-|-----1-----1-----1-----1-|"
    };

    /**
     * VALID_LINES[i] should equal VALID_NOTES[i].
     * That means that each line in VALID_LINES should equal its corresponding Note in VALID_NOTES
     */
    public static final Slide[] VALID_NOTES = {
            new Slide(0, 1)
            , new Slide(1, 2)
            , new Slide(2, 3)
            , new Slide(3, 4)
            , new Slide(4, 5)
            , new Slide(5, 6)
            , new Slide(6, 7)
            , new Slide(7, 8)
            , new Slide(8, 9)
            , new Slide(9, 10)
            , new Slide(10, 0)
    };


    private SlideParser parser;

    @Before
    public void setUp() {
        parser = new SlideParser();
    }

    @Test
    public void testParseInvalidLines() {

        for (String line : INVALID_LINES) {
            try { // Go through each invalid line, hoping to throw an Exception, since they cannot be parsed

                parser.parse(line);

                fail(); // Fail if we get here, since the lines are invalid, and should produce an Exception

            } catch (ParseException e) {
                /* This Exception should be triggered since we gave the parser invalid lines */
            }
        }
    }

    @Test
    public void testParseValidLines() throws ParseException {

        for (int i = 0; i < VALID_LINES.length; ++i) {  // Go through each valid line,

            String line = VALID_LINES[i];   // grab the current line
            Slide n = parser.parse(line);    // parse it
            assertEquals(VALID_NOTES[i], n);// ensure it equals the Note in the corresponding VALID_NOTES index
        }
    }

    @Test
    public void testCanParseInvalidLines() {

        for (String line : INVALID_LINES) {

            assertFalse(parser.canParse(line)); // NoteParser should not be able to parse any invalid lines
        }
    }

    @Test
    public void testCanParseValidLines() throws ParseException {

        for (String line : VALID_LINES) {

            assertTrue(parser.canParse(line)); // NoteParser should be able to parse all valid lines
        }
    }

}