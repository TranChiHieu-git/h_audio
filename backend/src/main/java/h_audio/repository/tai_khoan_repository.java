package h_audio.repository;

import h_audio.model.tai_khoan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface tai_khoan_repository extends JpaRepository<tai_khoan, Long> {
    tai_khoan findByAccount(String Account);

    tai_khoan getByAccount(String Account);

    List<tai_khoan> findAllByNguoiDung_Id(Long id_Nguoi_Tao);

    Page<tai_khoan> findAllByNguoiDung_Id(Long id_Nguoi_Tao, Pageable pagination);

    Page<tai_khoan> findAllByAccountContaining(String key, Pageable pagination);

    tai_khoan findByAccountContaining(String account);

    Boolean existsByAccount(String account);
}
