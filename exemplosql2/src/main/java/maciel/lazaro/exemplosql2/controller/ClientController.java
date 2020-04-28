package maciel.lazaro.exemplosql2.controller;

import maciel.lazaro.exemplosql2.model.ClientEntety;
import maciel.lazaro.exemplosql2.repository.ClientRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/clientes")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public ResponseEntity<List<ClientEntety>> findAll() {
        return new ResponseEntity<List<ClientEntety>>(
                (List<ClientEntety>) this.clientRepository.findAll(),
                new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ClientEntety> findById(@PathVariable("id") long id) {
        if(this.clientRepository.findById(id).isPresent()) {
            return new ResponseEntity<ClientEntety>(
                    this.clientRepository.findById(id).get(),
                    new HttpHeaders(),
                    HttpStatus.OK);
        }
        return new ResponseEntity<ClientEntety>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<ClientEntety> strore(@RequestBody ClientEntety clientEntety) {
        return new ResponseEntity<ClientEntety>(
                this.clientRepository.save(clientEntety),
                new HttpHeaders(),
                HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClientEntety> update(@PathVariable("id") long id,
                                               @RequestBody ClientEntety clientEntety) throws Exception {
        if(id == 0 || !this.clientRepository.existsById(id)) {
            throw new Exception("Código não encontrado ou inexistente");
        }
        return new ResponseEntity<ClientEntety>(
                this.clientRepository.save(clientEntety),
                new HttpHeaders(),
                HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ClientEntety> delete(@PathVariable("id") long id) {
        this.clientRepository.deleteById(id);
        return new ResponseEntity<ClientEntety>(new HttpHeaders(), HttpStatus.OK);
    }
}
