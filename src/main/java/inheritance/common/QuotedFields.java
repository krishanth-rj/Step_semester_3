package inheritance.common;

import java.util.ArrayList;
import java.util.List;

/** Splits whitespace-separated fields while keeping quoted text together. */
public final class QuotedFields {
    private QuotedFields() { }

    public static String[] parse(String line) {
        List<String> fields = new ArrayList<>();
        StringBuilder field = new StringBuilder();
        boolean quoted = false;
        boolean started = false;
        for (int i = 0; i < line.length(); i++) {
            char current = line.charAt(i);
            if (current == '"') {
                quoted = !quoted;
                started = true;
            } else if (Character.isWhitespace(current) && !quoted) {
                if (started) {
                    fields.add(field.toString());
                    field.setLength(0);
                    started = false;
                }
            } else {
                field.append(current);
                started = true;
            }
        }
        if (started) fields.add(field.toString());
        return fields.toArray(new String[0]);
    }
}
