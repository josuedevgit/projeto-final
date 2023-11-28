package com.projetofinal.zelda.repository;

import com.projetofinal.zelda.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}