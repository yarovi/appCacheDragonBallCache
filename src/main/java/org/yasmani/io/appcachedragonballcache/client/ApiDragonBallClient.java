package org.yasmani.io.appcachedragonballcache.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.yasmani.io.appcachedragonballcache.dto.DragonBallApiResponse;
import org.yasmani.io.appcachedragonballcache.dto.ResponseCharacterDTO;

import java.util.List;

@FeignClient(name = "apiDragonBallClient", url = "${app.api.base-url}")
public interface ApiDragonBallClient {

    @GetMapping
    DragonBallApiResponse getAllCharacters();
}
