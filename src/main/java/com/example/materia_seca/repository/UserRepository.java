package com.example.materia_seca.repository;

import com.example.materia_seca.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @NativeQuery("SELECT * FROM usuario WHERE correo = :email")
    User findUserByEmail(String email);

}
