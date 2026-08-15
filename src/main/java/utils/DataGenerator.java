package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class DataGenerator {
    private static final Random random = new Random();

    private DataGenerator() {
        throw new IllegalStateException("Utility class - do not instantiate");
    }

    public static String generateUniqueEmail(String prefix, String domain) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss"));
        int randomNum = random.nextInt(1000);
        return String.format("%s+%s%03d@%s", prefix, timestamp, randomNum, domain);
    }

    public static String generateRandomUkrainianPhone() {
        int randomPart = 1000000 + random.nextInt(9000000); // 7 випадкових цифр
        return "+38020" + randomPart;
    }
}
