package com.yoav.catAndToys.service;

import com.yoav.catAndToys.beans.Cat;
import com.yoav.catAndToys.controller.CatController;
import com.yoav.catAndToys.exception.CatException;
import com.yoav.catAndToys.repo.CatRepository;
import com.yoav.catAndToys.repo.ToyRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CatService {
    private final CatRepository catRepository;

    //create
    public void addCat(Cat cat){
        catRepository.save(cat);
    }
    //read
    public Cat getCat(int id) throws CatException {
        if (catRepository.existsById(id)) {
          return catRepository.findById(id).get();
        }else {
            throw new CatException("Cat not exists");
        }
    }
    //update
    public void updateCat(Cat cat) throws CatException {
        if (catRepository.existsById(cat.getId())) {
            catRepository.save(cat);
        }else {
            throw new CatException("Cat not exists");
        }
    }
    //delete
    public void deleteCat(int id) throws CatException{
        if (catRepository.existsById(id)){
            catRepository.deleteById(id);
        }else {
            throw new CatException("Cat not exists");
        }
    }
    public List<Cat> getAllCats(){
        return catRepository.findAll();
    }
}
