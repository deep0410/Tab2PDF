package ca.yorku.cse2311.tab2pdf.model;

import com.itextpdf.text.pdf.PdfWriter;

/**
 * Slide
 *
 * Represents a Slide in guitar tab notation
 * A Slide may or may or may not have a starting note
 *
 *
 * @author Brody Atto, Marco Cirillo
 * @since 2015-02-04
 */
public class Slide implements ITabNotation {

    public static final Note EMPTY_NOTE = new Note();

    private final Note start;

    private final Note end;

    public Slide(Note end) {

        this(EMPTY_NOTE, end);
    }

    public Slide(Note start, Note end) {

        this.start = start;
        this.end = end;
    }

    public Note getStart() {

        return start;
    }

    public Note getEnd() {

        return end;
    }

    public void Draw(int staveNumber, int lineNumber, int xCoordinate, PdfWriter writer) {
        //Do Nothing
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Slide slide = (Slide) o;

        if (end != null ? !end.equals(slide.end) : slide.end != null) return false;
        if (start != null ? !start.equals(slide.start) : slide.start != null) return false;

        return true;
    }

    @Override
    public int hashCode() {

        int result = start != null ? start.hashCode() : 0;
        result = 31 * result + (end != null ? end.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {

        return getStart().toString() + "s" + getEnd().toString();
    }
}
