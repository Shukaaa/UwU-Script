package rip.shuka.core.interpreter;

import rip.shuka.core.utils.ErrorUtil;
import rip.shuka.core.logic.datatypes.Datatype;
import rip.shuka.core.logic.datatypes.DatatypeObject;
import rip.shuka.core.logic.parameter.Parameter;

import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static rip.shuka.core.interpreter.Interpreter.interpretLine;

public class InterpreterForParameter {
    public static DatatypeObject[] interpretParameter(String given_parameter, Parameter[] parameters, int lineNumber, int position, String func) {
        String[] given_parameters = splitGivenParameter(given_parameter);
        int required_parameter = getRequiredParameters(parameters);

        for (String parameter : given_parameters) {
            if (Objects.equals(parameter, "")) {
                if (required_parameter == 0) {
                    return new DatatypeObject[0];
                } else {
                    ErrorUtil.callError("The function <" + func + "> on line " + lineNumber + " and position " + position + " has an empty parameter.");
                }
            }
        }

        if (given_parameters.length != parameters.length) {
            ErrorUtil.callError("The function <" + func + "> has " + parameters.length + " parameters but " + given_parameters.length + " were given.");
        }

        DatatypeObject[] interpretedParameters = new DatatypeObject[given_parameters.length];

        for (int i = 0; i < given_parameters.length; i++) {
            DatatypeObject interpretedParameter = InterpreterForDatatype.interpretDatatype(given_parameters[i], lineNumber);

            if (interpretedParameter == null) {
                interpretedParameter = interpretLine(given_parameters[i], lineNumber)[0];
            }

            if (!interpretedParameter.isValidDatatype(parameters[i].getTypes())) {
                StringBuilder allowedDatatypes = new StringBuilder();

                for (Datatype datatype : parameters[i].getTypes()) {
                    allowedDatatypes.append(datatype.getName()).append(", ");
                }

                allowedDatatypes = new StringBuilder(allowedDatatypes.substring(0, allowedDatatypes.length() - 2));

                ErrorUtil.callError(
                        "The parameter <" + given_parameters[i] + "> at line " + lineNumber + " and position " + position + " is not a valid datatype. " +
                                "Valid datatypes are: '" + allowedDatatypes + "' but you tried to use " + interpretedParameter.datatype().getName() + ".");
            }

            interpretedParameters[i] = interpretedParameter;
        }

        return interpretedParameters;
    }

    private static String[] splitGivenParameter(String given_parameter) {
        // Regex config
        Pattern regexPattern = Pattern.compile(",(?=[^()]*\\()");
        Matcher match = regexPattern.matcher(given_parameter + "()");

        // Get Position of regex ,
        ArrayList<Integer> position_arr = new ArrayList<>();
        while (match.find()) {
            position_arr.add(match.start());
        }

        // Splice parameter String
        String[] given_parameters = new String[]{given_parameter};
        if (position_arr.size() != 0) {
            ArrayList<String> given_parameters_arr = new ArrayList<>();
            for (int index = 0; index < position_arr.size(); index++) {
                if (index == 0) {
                    given_parameters_arr.add(given_parameter.substring(0, position_arr.get(index)));
                    continue;
                }

                given_parameters_arr.add(given_parameter.substring(position_arr.get(index-1)+1, position_arr.get(index)));
            }

            given_parameters_arr.add(given_parameter.substring(position_arr.get(position_arr.size()-1)+1));
            given_parameters = given_parameters_arr.toArray(new String[0]);
        }

        return given_parameters;
    }

    private static int getRequiredParameters(Parameter[] parameters) {
        int required_parameter = 0;

        for (Parameter parameter : parameters) {
            if (parameter.isRequired()) {
                required_parameter++;
            }
        }

        return required_parameter;
    }
}
