package naderdeghaili.u5w3d1hw.payloads;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorsWithListDTO(String message, LocalDateTime timestamp, List<String> errors) {
}
