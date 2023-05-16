package se.kth.iv1350.seminartask.view;

import static java.lang.System.out;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class ErrorMessageHandler {
    void showErrorMessage(String errMessage){
        StringBuilder errorMessageBuilder = new StringBuilder();
        errorMessageBuilder.append("Error: ");
        errorMessageBuilder.append(errMessage);
        errorMessageBuilder.append(" at Time ");
        errorMessageBuilder.append(currentTime());
        out.println(errorMessageBuilder);
    }
    private String currentTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter= DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return now.format(formatter);

    }
}
