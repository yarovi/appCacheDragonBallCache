package org.yasmani.io.appcachedragonballcache.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseCharacterDTO   {
    private int id;
    private String name;
    private String ki;
    private String gender;
}
