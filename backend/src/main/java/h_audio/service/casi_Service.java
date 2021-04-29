package h_audio.service;

import h_audio.model.casi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface casi_Service {
    Page<casi> findAllByTen(String ten, Pageable pageable);

    List<casi> findAllByTen(String ten);

    casi fingById(Long id);

    casi findByTen(String ten);

    void save(casi caSi);

    void deleteById(Long id);
}
