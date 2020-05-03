package maciel.lazaro.projetofinal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lázaro
 * @since 01/05/2020 13:25
 * @version 1.0
 */

@RestController
public class HelloWorldController {

    /**
     * @author Lázaro
     * @return Return a welcome message at application`s first page
     * @since 01/05/2020 13:27
     */
    @GetMapping("/")
    public String index() {
        return "Welcome to League of Legends`s API!";
    }
}
