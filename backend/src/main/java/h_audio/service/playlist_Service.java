package h_audio.service;

import h_audio.model.playlist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface playlist_Service {
    Page<playlist> findAllWithPage(Pageable pageable);

    List<playlist> findAll();

    playlist findByTen(String ten);

    playlist findById(Long id);


    List<playlist> findByNguoiTao(Long id_nguoi_tao);

    void save(playlist playlist);

    void deleteById(Long id);
}
