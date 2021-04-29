package h_audio.service;

import h_audio.model.nguoi_dung;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface nguoi_dung_Service {
    Page<nguoi_dung> findAllWithPage(String keySearch, Pageable pageable);

    List<nguoi_dung> findAll(Pageable pageable);

    nguoi_dung findById(Long id);


    nguoi_dung findByHoTen(String hoTen);

    nguoi_dung findByEmail(String email);

    void save(nguoi_dung nguoiDung);

    void deleteById(Long id);
}
