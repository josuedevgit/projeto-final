package com.github.user_service.repository;
import com.github.user_service.model.Zelda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZeldaRepository extends JpaRepository<Zelda, String> {

}