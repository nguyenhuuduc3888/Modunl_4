package all.service;

import all.model.Player;

import java.util.List;

public interface IPlayerService {
    List<Player> findAll();

    void save(Player player);

    void update( Player player);

    void delete(Player player);

    Player findById(int id);


}
