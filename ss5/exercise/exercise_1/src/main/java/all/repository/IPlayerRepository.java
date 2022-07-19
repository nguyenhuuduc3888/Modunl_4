package all.repository;

import all.model.Player;

import java.util.List;

public interface IPlayerRepository {
    List<Player> findAll();

    void save(Player player);

    void update( Player player);

    void delete(Player player);

    Player findById(int id);

}
