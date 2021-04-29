package h_audio.repository;

import h_audio.model.role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface role_repository extends JpaRepository<role, Integer> {
    role findByNameContaining(String name);
}
