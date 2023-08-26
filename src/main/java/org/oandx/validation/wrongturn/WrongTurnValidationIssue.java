package org.oandx.validation.wrongturn;

import org.oandx.validation.ValidationIssue;

public class WrongTurnValidationIssue implements ValidationIssue {

    @Override
    public String getIssueDescription() {
        return "Not this users turn";
    }
}
