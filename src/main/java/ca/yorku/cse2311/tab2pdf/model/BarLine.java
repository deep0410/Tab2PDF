package ca.yorku.cse2311.tab2pdf.model;

import java.util.LinkedList;
import java.util.List;

/**
 * BarLine
 *
 * Represents one line of a Bar (ie: one of the 6 guitar strings)
 *
 * @author Marco
 * @since 2015-01-12
 */
public class BarLine {

    private List<IMusicalNotation> line = new LinkedList<>();

    public List<IMusicalNotation> getLine() {
        return line;
    }

    public void addMusicalNotation(IMusicalNotation note) {

        line.add(note);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BarLine barLine = (BarLine) o;

        if (line != null ? !line.equals(barLine.line) : barLine.line != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return line != null ? line.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "BarLine{" +
                "line=" + line +
                '}';
    }
}