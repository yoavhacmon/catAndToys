package com.yoav.catAndToys.service;

import com.yoav.catAndToys.beans.Toy;
import com.yoav.catAndToys.exception.ToyException;
import com.yoav.catAndToys.repo.ToyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToyService {
    private final ToyRepository toyRepository;

    //create
    public void addToy(Toy toy){
        toyRepository.save(toy);
    }
    //read
    public Toy getToy(int id) throws ToyException {
        if (toyRepository.existsById(id)){
            return toyRepository.findById(id).get();
        } else {
            throw new ToyException("toy not exists");
        }
    }
    public List<Toy> getAllToys(){
        return toyRepository.findAll();
    }
    //update
    public void updateToy(Toy toy) throws ToyException {
        if (toyRepository.existsById(toy.getId())){
            toyRepository.save(toy);
        } else {
            throw new ToyException("toy not found");
        }
    }
    //delete
    public void deleteToy(int id) throws ToyException {
        if (toyRepository.existsById(id)){
            toyRepository.deleteById(id);
        }else {
            throw new ToyException("toy not exists");
        }
    }
}
