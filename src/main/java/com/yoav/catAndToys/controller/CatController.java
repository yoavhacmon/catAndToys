package com.yoav.catAndToys.controller;

import com.yoav.catAndToys.beans.Cat;
import com.yoav.catAndToys.exception.CatException;
import com.yoav.catAndToys.service.CatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cat") //http://localhost:8080/cat
@RequiredArgsConstructor
public class CatController {
    private final CatService catService;

    //create
    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addCat(@RequestBody Cat cat){
        catService.addCat(cat);
    }
    //read
    @GetMapping("/all")
    public ResponseEntity<?> getAllCats(){
       return new ResponseEntity<>(catService.getAllCats(),HttpStatus.OK);
    }

    @GetMapping("/single/{id}")
    public ResponseEntity<?> getCat(@PathVariable int id) throws CatException {
        return new ResponseEntity<>(catService.getCat(id),HttpStatus.OK);
    }
    //update
    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void updateCat(@RequestBody Cat cat) throws CatException {
        catService.updateCat(cat);
    }
    //delete
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteCat(@PathVariable int id) throws CatException {
        catService.deleteCat(id);
    }

}
