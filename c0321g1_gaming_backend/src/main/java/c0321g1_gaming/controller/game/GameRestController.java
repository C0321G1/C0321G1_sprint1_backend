package c0321g1_gaming.controller.game;

import c0321g1_gaming.dto.game.GameDto;
import c0321g1_gaming.model.entity.game.Game;
import c0321g1_gaming.model.service.game.IGameService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("game/api")
public class GameRestController {
    @Autowired
    private IGameService gameService;

    // Creator: Nhung

    @GetMapping("/{id}")
    public ResponseEntity<?> findGameById(@PathVariable Long id) {
        Optional<Game> game = gameService.findById(id);
        if (!game.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(game, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }


    @PostMapping
    public ResponseEntity<Void> saveGame(@Valid @RequestBody GameDto gameDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        Game game = new Game();
        gameDto.setFlagDelete(1);
        BeanUtils.copyProperties(gameDto, game);
        gameService.saveGame(game);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Game> updateGame(@Valid @RequestBody GameDto gameDto, BindingResult bindingResult,
                                           @PathVariable Long id) {
        Optional<Game> game = gameService.findById(id);
        if (!game.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        } else {
            Game newGame = new Game();
            BeanUtils.copyProperties(gameDto, newGame);
            gameService.updateGame(newGame);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
//
//    //    Creator: Thúy
//    @GetMapping
//    public ResponseEntity<List<Game>> showListGame(Optional<String> name, Optional<String> gameType) {
//        String nameValue = name.orElse("");
//        String gameTypeValue = gameType.orElse("");
//        List<Game> gameList = gameService.getGameBySearchingName(nameValue, gameTypeValue);
//        return new ResponseEntity<>(gameList, HttpStatus.OK);
//    }
//
//    @GetMapping(value = "/{id}")
//    public ResponseEntity<Game> findById(@PathVariable Long id) {
//        Optional<Game> gameOptional = gameService.findById(id);
//        if (!gameOptional.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(gameOptional.get(), HttpStatus.OK);
//    }
//
//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity<Game> deleteGame(@PathVariable Long id, @RequestBody Game game) {
//        Optional<Game> gameOptional = gameService.findById(id);
//        if (!gameOptional.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        game.setFlagDelete(1);
//        gameService.saveGame(game);
//        return new ResponseEntity<>(gameOptional.get(), HttpStatus.OK);
//    }
}
