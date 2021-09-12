package c0321g1_gaming.controller.game;

import c0321g1_gaming.model.entity.game.Game;
import c0321g1_gaming.model.service.game.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("game/api")
public class GameRestController {
    @Autowired
    private GameService gameService;

    //    Nhung
    @PostMapping
    public ResponseEntity<Game> createSoTietKiem(@RequestBody Game game) {
        return new ResponseEntity<>(gameService.save(game), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Game> updateCategory(@PathVariable Long id, @RequestBody Game game) {
        Optional<Game> gameOptional = gameService.findById(id);
        return gameOptional.map(findgame -> {
            game.setGameId(findgame.getGameId());
            return new ResponseEntity<>(gameService.save(game), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
