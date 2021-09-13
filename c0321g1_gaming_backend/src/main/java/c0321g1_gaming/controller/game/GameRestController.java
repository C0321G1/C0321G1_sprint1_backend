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
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("game/api")
public class GameRestController {
    @Autowired
    private IGameService gameService;

    // Creator: Nhung

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
            gameDto.setGameId(game.get().getGameId());
            BeanUtils.copyProperties(gameDto, game.get());
            gameService.updateGame(game.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
