package all.repository;

import all.model.Player;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PlayerRepository implements IPlayerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Player> findAll() {
        TypedQuery<Player> listPlayer = entityManager.createQuery("select s from Player s", Player.class);
        return listPlayer.getResultList();
    }

    @Override
    public void save(Player player) {
        entityManager.persist(player);
    }

    @Override
    public void update(Player player) {
        entityManager.merge(player);
    }

    @Override
    public void delete(Player player) {
        entityManager.remove(player);
    }

    @Override
    @Modifying
    public Player findById(int id) {
        return entityManager.find(Player.class,id);
    }

}
