package com.ssp.apps;

public class AcceptorIdGenerator {
    private String DEFAULT_INITIAL_VALUE = "000000";

    public synchronized String nextStringIdentifier(String initialValue) {
        validateInitialValue(initialValue);

        String currentAcceptorId = isInitialValueNotEmpty(initialValue)? initialValue : DEFAULT_INITIAL_VALUE;
        char[] currentValue = leftPad(currentAcceptorId).toCharArray();
        for (int i = currentValue.length - 1; i >= 0; --i) {
            switch (currentValue[i]) {
                case '9':
                    currentValue[i] = 'A';
                    i = -1;
                    break;
                case 'Z':
                    currentValue[i] = '0';
                    if (i == 0) {
                        throw new IllegalStateException("The maximum number of identifiers has been reached");
                    }
                    break;
                default:
                    ++currentValue[i];
                    i = -1;
            }
        }

        return new String(currentValue);
    }

    private String leftPad(String acceptorId){
        return (DEFAULT_INITIAL_VALUE + acceptorId).substring(acceptorId.length());
    }

    private boolean isInitialValueNotEmpty(String initialValue) {
        return initialValue != null && initialValue.length() > 0;
    }

    private void validateInitialValue(String initialValue) {
        char[] count = initialValue.toCharArray();

        for(int i = 0; i < count.length; ++i) {
            char ch = count[i];
            if ((ch < '0' || ch > '9') && (ch < 'A' || ch > 'Z')) {
                throw new IllegalArgumentException("character " + count[i] + " is not valid");
            }
        }
    }
}
