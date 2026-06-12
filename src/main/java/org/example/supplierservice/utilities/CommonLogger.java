package org.example.supplierservice.utilities;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CommonLogger {

    public static final String INFO = "info";
    public static final String WARN = "warn";
    public static final String ERROR = "error";
    public static final String messageTemplate = "[%s] :  %s";

    private static String messageGenerate(String message, String className){
        return String.format(messageTemplate,message,className);
    }

    public static void log(String className, String message, String logLevel){
        message = messageGenerate(message, className);
        switch (logLevel) {
            case INFO:
                log.info(message);
                break;
            case WARN:
                log.warn(message);
                break;
            case ERROR:
                log.error(message);
                break;
            default:
                break;
        }
    }



}
