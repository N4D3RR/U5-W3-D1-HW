package naderdeghaili.u5w3d1hw.payloads;


import java.time.LocalDateTime;

public record ErrorsDTO(String message, LocalDateTime timeStamp) {
}
