package h_audio.service;

import h_audio.model.the_loai;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface the_loai_Service {
    
    Page<the_loai> findAllByTen(String ten, Pageable pageable);

    List<the_loai> findAllByTen(String ten);

    the_loai findById(Long id);

    void save(the_loai theLoai);

    void deleteById(Long id);
}
