import java.time.*;

// Driver class
public class ElapsedTime {
    private static Instant start;
    private static Instant end;
    public static void start() {
        start=Instant.now();
    }
    public static Duration end() {
        end=Instant.now();
        return Duration.between(start,end);
    }
}