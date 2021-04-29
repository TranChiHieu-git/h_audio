package h_audio.repository;

import h_audio.model.playlist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface playlist_repository extends JpaRepository<playlist, Long> {
    List<playlist> findAllByNguoiTao_Id(Long id_Nguoi_Tao);

    Page<playlist> findAllByNguoiTao_Id(Long id_Nguoi_Tao, Pageable pagination);

    Page<playlist> findAllByTenContaining(String key, Pageable pagination);

    playlist findByTenContaining(String ten);
}
