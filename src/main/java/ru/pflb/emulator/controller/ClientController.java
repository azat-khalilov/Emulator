package ru.pflb.emulator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.pflb.emulator.model.dto.ClientDto;
import ru.pflb.emulator.service.ClientService;

@RestController
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<ClientDto> getHello(@PathVariable long id) {
        ClientDto client = clientService.getUserById(id);
        return ResponseEntity.ok(client);
    }
    @PostMapping("/client")
    public ResponseEntity<ClientDto> addCl(@Validated @RequestBody ClientDto client) {
        return ResponseEntity.status(HttpStatus.OK).build();//{"id":45,"firstName":"Jojo","lastName":"Bean","cardNumber":"123","active":true}
    }

    @PutMapping("/client/{id}")
    public ResponseEntity<ClientDto> updCl(@PathVariable long id,@Validated @RequestBody ClientDto client) {
        //ClientDto client = clientService.getUserById(id);
        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/client/{id}")
    public ResponseEntity<ClientDto> delCl(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
