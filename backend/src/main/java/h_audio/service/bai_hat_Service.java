package h_audio.service;

import h_audio.model.bai_hat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface bai_hat_Service {
    void save(bai_hat baiHat);

    void deleteById(Long id);

    List<bai_hat> findAll();

    Page<bai_hat> findAll(Pageable pageable);

    List<bai_hat> findByTen(String ten);

    Page<bai_hat> findByTen(String ten, Pageable pageable);

    List<bai_hat> findByNguoiTao(Long id);

    Page<bai_hat> findByNguoiTao(Long id, Pageable pageable);

    List<bai_hat> findByAlbum(Long id);

    List<bai_hat> findByPlayList(Long id);


}
