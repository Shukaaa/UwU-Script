package rip.shuka.core.syntax;

import rip.shuka.core.syntax.datatypes.*;
import rip.shuka.core.syntax.datatypes.Boolean;
import rip.shuka.core.syntax.datatypes.Float;
import rip.shuka.core.syntax.datatypes.Integer;
import rip.shuka.core.syntax.datatypes.String;
import rip.shuka.core.syntax.functions.*;
import rip.shuka.core.syntax.functions.Error;

public class SyntaxVars {
    public static SyntaxElement[] syntaxElements = {
            // Comments
            new Comments(),

            // Print Functions
            new Moan(),
            new Daijoubu(),
            new Error(),

            // Variable Functions
            new VariablesUwu(),
            new VariablesOwo(),

            // Exit Function
            new Sayonara()
    };

    public static Datatype[] syntaxDatatypes = {
            new Integer(),
            new String(),
            new Float(),
            new Any(),
            new Boolean(),
            new Null()
    };
}
