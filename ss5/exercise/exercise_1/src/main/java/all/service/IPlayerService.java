package all.service;

import all.model.Player;

import java.util.List;

public interface IPlayerService {
    List<Player> findAll();

    void save(Player player);

    void update( Player player);

    void delete(int id);

    Player findById(int id);


}
