package com.service;

import com.model.Player;
import com.repository.IPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class PlayerService implements IPlayerService {
    @Autowired
    IPlayerRepository playerRepository;

    @Override
    public Page<Player> findAll(Pageable pageable) {
        return playerRepository.findAll(pageable);
    }

    @Override
    public void save(Player player) {
        playerRepository.save(player);
    }

    @Override
    public void update(Player player) {
        playerRepository.update(player.getMusicName(), player.getPersonName(), player.getRentMusic(), player.getLink(), player.getId());
    }

    @Override
    public void delete(int id) {
        playerRepository.delete(id);
    }

    @Override
    public Player findById(int id) {
        return playerRepository.findById(id);
    }
}
