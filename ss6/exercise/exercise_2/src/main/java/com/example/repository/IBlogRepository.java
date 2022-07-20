package com.example.repository;


import com.example.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    @Modifying
    @Query(value = "update Blog set blog_detail = :blogDetail, blog_name=:blogName," + " blog_rent=:blogRent  where id = :id", nativeQuery = true)
    void update(@Param("blogDetail") String blogDetail, @Param("blogName") String blogName, @Param("blogRent") String blogRent, @Param("id") int id);
}
