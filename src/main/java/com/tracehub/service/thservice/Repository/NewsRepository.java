package com.tracehub.service.thservice.Repository;

import java.util.List;
import java.util.Optional;

import com.tracehub.service.thservice.Data.News;
import com.tracehub.service.thservice.Data.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News,Integer> {
    @Query(value = "select * from news;", nativeQuery = true)
    public List<News> findPasswordByName(String name);

}
