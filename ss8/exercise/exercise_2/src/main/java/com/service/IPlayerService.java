package com.service;


import com.model.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPlayerService {
    Page<Player> findAll(Pageable pageable);

    void save(Player player);

    void update(Player player);

    void delete(int id);

    Player findById(int id);


}
