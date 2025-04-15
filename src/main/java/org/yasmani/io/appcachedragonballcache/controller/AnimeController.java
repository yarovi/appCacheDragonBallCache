package org.yasmani.io.appcachedragonballcache.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.DeleteExchange;
import org.yasmani.io.appcachedragonballcache.dto.ResponseCharacterDTO;
import org.yasmani.io.appcachedragonballcache.service.CharacterService;

import java.util.List;
@RestController
@RequestMapping("/api/v1/anime")
@AllArgsConstructor
public class AnimeController {

    private CharacterService characterService;
    @GetMapping
    public String getAnime() {
        return "Dragon Ball Z";
    }

    @GetMapping("/characters")
    public ResponseEntity<List<ResponseCharacterDTO>> getCharacters() {
        List<ResponseCharacterDTO> responseCharacterDTOList =characterService.getAllCharacters();
        if (responseCharacterDTOList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(responseCharacterDTOList);
    }
   //  build method to like of one character and save in redis
    @PostMapping("/{id}/like")
    public ResponseEntity<String> likeCharacter(@PathVariable int id) {
        characterService.setLikeCharacter(id);
        return ResponseEntity.ok("Character liked");
    }

    @DeleteMapping("/{id}/dislike")
    public ResponseEntity<String> dislikeCharacter(int id) {
        characterService.removeFromCache("characters", String.valueOf(id));
        return ResponseEntity.ok("Character disliked");
    }


}
