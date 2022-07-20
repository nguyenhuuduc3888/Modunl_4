package com.example.service;

import com.example.model.Blog;

import java.util.List;

public interface IBlogService {

    List<Blog> findAll();

    void update(Blog blog);

    void delete(int id);

    Blog findById(Integer id);

    void save(Blog blog);


}
