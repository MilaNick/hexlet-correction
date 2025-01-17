package io.hexlet.typoreporter.web.exception;

import org.springframework.validation.FieldError;
import org.zalando.problem.AbstractThrowableProblem;
import static org.zalando.problem.Status.CONFLICT;

public class NewPasswordTheSameException extends AbstractThrowableProblem implements ConvertibleToFieldError {

    private static final String MESSAGE_TEMPLATE = "New password is the same as the old one";

    public NewPasswordTheSameException() {
        super(null, "The same new password", CONFLICT, MESSAGE_TEMPLATE);
    }

    @Override
    public FieldError toFieldError(final String objectName) {
        return new FieldError(
            objectName,
            "newPassword",
            null,
            false,
            null,
            null,
            MESSAGE_TEMPLATE
        );
    }
}
