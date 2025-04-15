package org.yasmani.io.appcachedragonballcache.service;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.yasmani.io.appcachedragonballcache.client.ApiDragonBallClient;
import org.yasmani.io.appcachedragonballcache.dto.ResponseCharacterDTO;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CharacterService {



    private ApiDragonBallClient apiDragonBallClient;
    private CacheManager cacheManager;

    @Cacheable(value = "characters", key = "#id")
    public String setLikeCharacter(int id) {
        cacheManager.getCache("characters").put(id, "name"+id);
        return  "The was liked";
    }

    public void removeFromCache(String cacheName, String key) {
        cacheManager.getCache(cacheName).evict(key);
    }

    public List<ResponseCharacterDTO> getAllCharacters() {
        var characters = apiDragonBallClient.getAllCharacters();
        log.info("Characters: " + characters.getItems().size());
        return characters.getItems();
    }
}
