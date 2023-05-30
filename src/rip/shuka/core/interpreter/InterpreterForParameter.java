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
        ArrayList<DatatypeObject> interpretedParametersList = new ArrayList<>();
        int required_parameter = getRequiredParameters(parameters, interpretedParametersList);

        for (String parameter : given_parameters) {
            if (Objects.equals(parameter, "")) {
                if (required_parameter == 0 && interpretedParametersList.size() == 0) {
                    return new DatatypeObject[0];
                } else {
                    given_parameters = new String[0];
                }
            }
        }

        if (given_parameters.length < required_parameter) {
            ErrorUtil.callError("The function <" + func + "> has " + required_parameter + " required parameters but " + given_parameters.length + " were given.");
        }

        if (given_parameters.length > parameters.length && !anyParameterIsInfinity(parameters)) {
            ErrorUtil.callError("The function <" + func + "> has " + required_parameter + " parameters but " + given_parameters.length + " were given.");
        }

        int infinity_pos = -1;
        for (int i = 0; i < given_parameters.length; i++) {
            if (infinity_pos == -1) {
                try {
                    if (parameters[i].isInifinity()) {
                        infinity_pos = i;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    break;
                }
            }

            DatatypeObject interpretedParameter = InterpreterForDatatype.interpretDatatype(given_parameters[i], lineNumber);

            if (interpretedParameter == null) {
                interpretedParameter = interpretLine(given_parameters[i], lineNumber)[0];
            }

            boolean validDatatypeCheck;
            if (infinity_pos == -1) {
                validDatatypeCheck = !interpretedParameter.isValidDatatype(parameters[i].getTypes());
            } else {
                validDatatypeCheck = !interpretedParameter.isValidDatatype(parameters[infinity_pos].getTypes());
            }

            if (validDatatypeCheck) {
                StringBuilder allowedDatatypes = new StringBuilder();

                for (Datatype datatype : parameters[infinity_pos == -1 ? i : infinity_pos].getTypes()) {
                    allowedDatatypes.append(datatype.getName()).append(", ");
                }

                allowedDatatypes = new StringBuilder(allowedDatatypes.substring(0, allowedDatatypes.length() - 2));

                ErrorUtil.callError(
                        "The parameter <" + given_parameters[i] + "> at line " + lineNumber + " and position " + position + " is not a valid datatype. " +
                                "Valid datatypes are: '" + allowedDatatypes + "' but you tried to use " + interpretedParameter.datatype().getName() + ".");
            }

            if (infinity_pos == -1) {
                interpretedParametersList.add(i, interpretedParameter);
            } else {
                interpretedParametersList.add(interpretedParameter);
            }
        }

        return interpretedParametersList.toArray(new DatatypeObject[0]);
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

                given_parameters_arr.add(given_parameter.substring(position_arr.get(index - 1) + 1, position_arr.get(index)));
            }

            given_parameters_arr.add(given_parameter.substring(position_arr.get(position_arr.size() - 1) + 1));
            given_parameters = given_parameters_arr.toArray(new String[0]);
        }

        return given_parameters;
    }

    private static int getRequiredParameters(Parameter[] parameters, ArrayList<DatatypeObject> interpretedParameters) {
        int required_parameter = 0;

        for (Parameter parameter : parameters) {
            if (parameter.isRequired()) {
                required_parameter++;
            } else {
                interpretedParameters.add(parameter.getValue());
            }
        }

        return required_parameter;
    }

    private static boolean anyParameterIsInfinity(Parameter[] parameters) {
        boolean infinity = false;

        for (Parameter parameter : parameters) {
            if (parameter.isInifinity()) {
                infinity = true;
                break;
            }
        }

        return infinity;
    }
}
