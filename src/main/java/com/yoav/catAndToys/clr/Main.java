package com.yoav.catAndToys.clr;

import com.yoav.catAndToys.beans.Cat;
import com.yoav.catAndToys.beans.Toy;
import com.yoav.catAndToys.repo.CatRepository;
import com.yoav.catAndToys.repo.ToyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Order(1)
public class Main implements CommandLineRunner {
    private final ToyRepository toyRepository;
    private final CatRepository catRepository;
    @Override
    public void run(String... args) throws Exception {
        Toy toy1 = Toy.builder()
                .name("ball")
                .build();
        Toy toy2 = Toy.builder()
                .name("snake")
                .build();
        Toy toy3 = Toy.builder()
                .name("mouse")
                .build();
        Cat cat1 = Cat.builder()
                .name("mitzi")
                .weight(5)
                .toys(List.of(toy1,toy2))
                .build();
        Cat cat2 = Cat.builder()
                .name("kitzi")
                .weight(3)
                .toys(List.of(toy3,toy2))
                .build();
        Cat cat3 = Cat.builder()
                .name("shushu")
                .weight(4)
                .toys(List.of(toy1,toy3))
                .build();
        List<Cat>cats = List.of(cat1,cat2,cat3);
        List<Toy>toys = List.of(toy1,toy2,toy3);
        //create
//        toyRepository.saveAll(toys);
//        catRepository.saveAll(cats);
        //read
        Optional<Cat> cat = catRepository.findById(1);
        if(cat.isPresent()){
            System.out.println(cat);
        }else {
            System.out.println("cat not found");
        }
        List<Toy>toyList = toyRepository.findAll();
        System.out.println(toyList);
        //update
        Cat catNewName = catRepository.getById(1);
        catNewName.setName("yoyo");
        catRepository.save(catNewName);
        System.out.println(catNewName);
        //delete
       // catRepository.deleteById(3);
        System.out.println(catRepository.findAll());
    }
}
