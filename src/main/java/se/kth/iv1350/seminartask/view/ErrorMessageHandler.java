package se.kth.iv1350.seminartask.view;

import static java.lang.System.out;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
/**
 * 
 * Class for printing error message
 */
public class ErrorMessageHandler {
    /**
     * Prints error message
     * @param errMessage The message to be printed
     */
    void showErrorMessage(String errMessage){
        StringBuilder errorMessageBuilder = new StringBuilder();
        errorMessageBuilder.append("Error: ");
        errorMessageBuilder.append(errMessage);
        errorMessageBuilder.append(" at Time ");
        errorMessageBuilder.append(currentTime());
        out.println(errorMessageBuilder);
    }
    /**
     * Gets the current time
     * @return The current time formatted
     */
    private String currentTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter= DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return now.format(formatter);

    }
}
