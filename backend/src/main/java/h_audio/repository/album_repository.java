package h_audio.repository;

import h_audio.model.album;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface album_repository extends JpaRepository<album, Long> {
    List<album> findAllByNguoiTao_Id(Long id_Nguoi_Tao);

    Page<album> findAllByNguoiTao_Id(Long id_Nguoi_Tao, Pageable pagination);

    Page<album> findAllByTenContaining(String key, Pageable pagination);

    album findByTenContaining(String ten);

}
