import lombok.With;

import java.time.Instant;
import java.util.List;

@With

public record Order(
        String id,
        List<Product> products,
        Status status,
        Instant orderTime
) {
    public enum Status {
        PROCESSING("processing"),
        IN_DELIVERY("in delivery"),
        DELIVERED("Delivered"),
        CANCELLED("Cancelled"),
        ;

        private final String value;

        Status (String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

}
