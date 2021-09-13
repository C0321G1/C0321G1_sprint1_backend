package c0321g1_gaming.controller.game;

import c0321g1_gaming.model.entity.game.Game;
import c0321g1_gaming.model.service.game.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("game/api")
public class GameRestController {
    @Autowired
    private IGameService gameService;

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

    //    Creator: Thúy
    @GetMapping
    public ResponseEntity<List<Game>> showListGame(Optional<String> name, Optional<String> gameType) {
        String nameValue = name.orElse("");
        String gameTypeValue = gameType.orElse("");
        List<Game> gameList = gameService.getGameBySearchingName(nameValue, gameTypeValue);
        return new ResponseEntity<>(gameList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Game> findById(@PathVariable Long id){
        Optional<Game> gameOptional = gameService.findById(id);
        if (!gameOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(gameOptional.get(),HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Game> deleteGame(@PathVariable Long id, @RequestBody Game game) {
        Optional<Game> gameOptional = gameService.findById(id);
        if (!gameOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        game.setFlagDelete(1);
        gameService.save(game);
        return new ResponseEntity<>(gameOptional.get(), HttpStatus.OK);
    }
}
