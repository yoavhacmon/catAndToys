package com.yoav.catAndToys.controller;

import com.yoav.catAndToys.beans.Toy;
import com.yoav.catAndToys.exception.ToyException;
import com.yoav.catAndToys.service.ToyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/toy")
@RequiredArgsConstructor
public class ToyController {
    private ToyService toyService;

    //create
    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.OK)
    public void addToy(@RequestBody Toy toy){
        toyService.addToy(toy);
    }
    //read
    @GetMapping("/all")
    public ResponseEntity<?> getAllToys(){
        return new ResponseEntity<>(toyService.getAllToys(),HttpStatus.OK);
    }
    @GetMapping("/single{id}")
    public ResponseEntity<?> getToy(@PathVariable int id) throws ToyException {
        return new ResponseEntity<>(toyService.getToy(id),HttpStatus.OK);
    }
    //update
    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void updateToy(@RequestBody Toy toy) throws ToyException {
        toyService.updateToy(toy);
    }
    //delete
    @DeleteMapping("/delete{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteToy(@PathVariable int id) throws ToyException {
        toyService.deleteToy(id);
    }
}
