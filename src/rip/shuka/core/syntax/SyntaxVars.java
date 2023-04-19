package rip.shuka.core.syntax;

import rip.shuka.core.syntax.datatypes.Any;
import rip.shuka.core.syntax.datatypes.Boolean;
import rip.shuka.core.syntax.datatypes.Float;
import rip.shuka.core.syntax.datatypes.Integer;
import rip.shuka.core.syntax.datatypes.String;
import rip.shuka.core.syntax.functions.Comments;
import rip.shuka.core.syntax.functions.Daijoubu;
import rip.shuka.core.syntax.functions.Error;
import rip.shuka.core.syntax.functions.Moan;

public class SyntaxVars {
    public static SyntaxElement[] syntaxElements = {
            // Util Functions
            new Comments(),

            // Print Functions
            new Moan(),
            new Daijoubu(),
            new Error()
    };

    public static SyntaxDatatype[] syntaxDatatypes = {
            new Integer(),
            new String(),
            new Float(),
            new Any(),
            new Boolean()
    };
}
