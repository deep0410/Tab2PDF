package ca.yorku.cse2311.tab2pdf.parser;

import java.text.ParseException;

/**
 * IParser
 *
 * Represents a parser. Each parser can parse only it's specific type of musical notation
 *
 * @author Marco
 * @since 2015-01-13
 */
public interface IParser<T> {

    public T parse(String token) throws ParseException;

    public boolean canParse(String token);
}
