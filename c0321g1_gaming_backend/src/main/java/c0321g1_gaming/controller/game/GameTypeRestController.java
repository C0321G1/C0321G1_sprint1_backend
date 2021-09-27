package c0321g1_gaming.controller.game;

import c0321g1_gaming.model.entity.game.GameType;
import c0321g1_gaming.model.service.game.IGameTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("gameType/api")
public class GameTypeRestController {
    @Autowired
    private IGameTypeService iGameTypeService;

    @GetMapping
    public ResponseEntity<List<GameType>> list() {
        List<GameType> gameTypeList = iGameTypeService.findAll();
        if (gameTypeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(gameTypeList, HttpStatus.OK);
    }
}
