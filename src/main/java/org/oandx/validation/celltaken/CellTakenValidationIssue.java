package org.oandx.validation.celltaken;

import org.oandx.validation.ValidationIssue;

public class CellTakenValidationIssue implements ValidationIssue {

    @Override
    public String getIssueDescription() {
        return "Cell already taken";
    }
}
