package org.yasmani.io.appcachedragonballcache.dto;

import lombok.Data;

import java.util.List;
@Data
public class DragonBallApiResponse {
    private List<ResponseCharacterDTO> items; // o "data", "results" según el JSON real
    private int total;
    private String next;
}
