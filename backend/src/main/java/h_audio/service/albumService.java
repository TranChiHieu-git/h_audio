package h_audio.service;

import h_audio.model.album;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface albumService {
    Page<album> findAllWithPage(String keySearch, Pageable pageable);

    List<album> findAll();

    album findByTen(String ten);

    album findById(Long id);

    Page<album> findByNguoiTaoWithPage(Long id_nguoi_tao, Pageable pageable);

    List<album> findByNguoiTao(Long id_nguoi_tao);

    void save(album album);

    void deleteById(Long id);
}
