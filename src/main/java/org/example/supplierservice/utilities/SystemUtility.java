package org.example.supplierservice.utilities;

import jakarta.servlet.http.HttpServletRequest;
import org.example.supplierservice.constants.SystemConstant;
import org.example.supplierservice.model.GlobalRecord;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.security.SecureRandom;
import java.time.LocalDateTime;

@Component
public class SystemUtility {

    private static final SecureRandom RANDOM = new SecureRandom();

    private static final String CHARACTERS =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                    "abcdefghijklmnopqrstuvwxyz" +
                    "0123456789" +
                    "@#$%&*!";

    public static String generatePassword(int length) {

        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {

            int index = RANDOM.nextInt(CHARACTERS.length());

            password.append(CHARACTERS.charAt(index));
        }

        return password.toString();
    }

    public static String generateIdForEntity(String prefix){
        if (prefix == null || prefix.isBlank()) {
            throw new IllegalArgumentException("Prefix cannot be null or empty");
        }

        int randomNumber = 100 + RANDOM.nextInt(900);
        // Generates 100 -> 999

        return prefix.toUpperCase()
                .replaceAll("\\s+", "_")
                + "-"
                + randomNumber;
    }

    public static void setGlobalRecordsValue(GlobalRecord globalRecord){
        globalRecord.setCreatedAt(LocalDateTime.now());
        globalRecord.setUpdatedAt(LocalDateTime.now());
        globalRecord.setCreatedBy(SystemConstant.SYSTEM_USER);
        globalRecord.setUpdatedBy(SystemConstant.SYSTEM_USER);
    }

    public static String getClientIp() {

        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        if (attributes == null) {
            return null;
        }

        HttpServletRequest request = attributes.getRequest();

        String xForwardedFor = request.getHeader("X-Forwarded-For");

        if (xForwardedFor != null && !xForwardedFor.isEmpty()) {
            return xForwardedFor.split(",")[0];
        }

        return request.getRemoteAddr();
    }

}