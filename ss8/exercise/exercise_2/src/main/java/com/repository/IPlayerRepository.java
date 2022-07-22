package com.repository;


import com.model.Player;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;


@Transactional
public interface IPlayerRepository extends JpaRepository<Player, Integer> {

    @Query(value = "select * from player ", nativeQuery = true)
    Page<Player> findAll(Pageable pageable);

    @Modifying
    @Query(value = " delete from player where id = :id ", nativeQuery = true)
    void delete(@Param("id") int id);

    @Query(value = "select * from player where id = :id", nativeQuery = true)
    Player findById(@Param("id") int id);

    @Query(value = "select * from player where musicName like :name", nativeQuery = true)
    Page<Player> findByName(@Param("name") String name, Pageable pageable);

    @Modifying
    @Query(value = "update player set music_name =:musicName,person_name=:personName,rent_music=:rentMusic,link=:link where id=:id", nativeQuery = true)
    void update(@Param("musicName") String musicName, @Param("personName") String personName, @Param("rentMusic") String rentMusic, @Param("link") String link, @Param("id") int id);

}
