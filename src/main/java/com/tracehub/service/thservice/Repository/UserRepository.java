package com.tracehub.service.thservice.Repository;

import java.util.Optional;

import com.tracehub.service.thservice.Data.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    @Query(value = "select password from UserInfo where name = ?1 ;", nativeQuery = true)
    public Optional<String> findPasswordByName(String name);
}
