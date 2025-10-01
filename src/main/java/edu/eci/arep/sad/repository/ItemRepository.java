package edu.eci.arep.sad.repository;

import edu.eci.arep.sad.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepository extends JpaRepository<Item, Long> {
}
