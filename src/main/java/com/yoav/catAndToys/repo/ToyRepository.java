package com.yoav.catAndToys.repo;

import com.yoav.catAndToys.beans.Toy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToyRepository extends JpaRepository<Toy,Integer> {}
