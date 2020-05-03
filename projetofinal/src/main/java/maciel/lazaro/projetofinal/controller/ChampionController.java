package maciel.lazaro.projetofinal.controller;

import maciel.lazaro.projetofinal.model.ChampionEntity;
import maciel.lazaro.projetofinal.repository.ChampionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Lázaro
 * @since 01/05/2020 14:10
 * @version 1.0
 */

@RestController
@RequestMapping("champions")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ChampionController {
    @Autowired
    private ChampionRepository  championRepository;

    /**
     * @author Lázaro
     * @since 01/05/2020 14:14
     * @return It`s a method that return all of data from Champions DataBase
     */
    @GetMapping
    public ResponseEntity<List<ChampionEntity>> findAll() {
        return new ResponseEntity<List<ChampionEntity>>((List<ChampionEntity>) this.championRepository.findAll(), new HttpHeaders(), HttpStatus.OK);
    }

    /**
     * @author Lázaro
     * @since 01/05/2020 15:20
     * @param id this id is the value that the user must put in the URL to can see the respective id`s Data
     * @return this method returns a specific champion from database, that is definied by your id
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<ChampionEntity> findById(@PathVariable("id") long id) {
        if(this.championRepository.findById(id).isPresent()) {
            return new ResponseEntity<ChampionEntity>(
                    this.championRepository.findById(id).get(),
                    new HttpHeaders(),
                    HttpStatus.OK);
        }
        return new ResponseEntity<ChampionEntity>(HttpStatus.NOT_FOUND);
    }

    /**
     * @author Lázaro
     * @since 01/05/2020 15:27
     * @param championEntity is the value that user will provides us to put a new champion in our database
     * @return this method will save a new champion in our database and return a http status OK
     */
    @PostMapping
    public ResponseEntity<ChampionEntity> store(@RequestBody ChampionEntity championEntity) {
        return new ResponseEntity<ChampionEntity>(
                this.championRepository.save(championEntity),
                new HttpHeaders(),
                HttpStatus.CREATED);
    }

    /**
     * @author Lázaro
     * @since 01/05/2020 15:36
     * @param id this id is the value that the user must put in the URL to can update the respective id`s Data
     * @param championEntity is the value that user will provides us to update the champion in our database
     * @return this method will update a champion from our database and return a http status 200
     * @throws Exception this exception will verify if has an error or nonexistent id in our database
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<ChampionEntity> update(@PathVariable("id") long id, @RequestBody ChampionEntity championEntity) throws Exception {
        if(id == 0 || !this.championRepository.existsById(id)) {
            throw new Exception("Código não encontrado ou inexistente");
        }
        return new ResponseEntity<ChampionEntity>(this.championRepository.save(championEntity), new HttpHeaders(), HttpStatus.OK);
    }

    /**
     * @author Lázaro
     * @since 01/05/2020 15:48
     * @param id this id is the value that the user must put in the URL to can delete the respective id`s Data
     * @return this method will delete a champion from our database and return a http status 200
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ChampionEntity> delete (@PathVariable("id") long id) {
        this.championRepository.deleteById(id);
        return new ResponseEntity<ChampionEntity>(new HttpHeaders(), HttpStatus.OK);
    }
}
