package h_audio.service;

import h_audio.model.tai_khoan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface tai_khoanService {
    Page<tai_khoan> findAllWithPage(String keySearch, Pageable pageable);

    List<tai_khoan> findAll();

    tai_khoan findById(Long id);

    tai_khoan findByAccount(String account);

    List<tai_khoan> findByNguoiTao(Long id_nguoi_tao);

    void save(tai_khoan taiKhoan);

    void deleteById(Long id);
}
