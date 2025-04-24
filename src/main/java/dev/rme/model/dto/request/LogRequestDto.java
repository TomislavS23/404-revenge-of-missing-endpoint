package dev.rme.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class LogRequestDto {
    private Integer idUser;
    private String ipAddr;
    private Instant tstamp;
}
