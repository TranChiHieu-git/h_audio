package h_audio.service;

import h_audio.model.role;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface roleService {
    List<role> findAll(Pageable pageable);

    role findById(int id);

    role findByName(String name);

    void save(role Role);

    void deleteById(int id);
}
