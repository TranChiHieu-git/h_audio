package h_audio.repository;

import h_audio.model.nguoi_dung;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface nguoi_dung_repository extends JpaRepository<nguoi_dung, Long> {

    Page<nguoi_dung> findAllByTenContaining(String key, Pageable pagination);

    Page<nguoi_dung> findAllByEmailContaining(String key, Pageable pagination);

    nguoi_dung findByTenContaining(String ten);

    nguoi_dung findByEmail(String email);

    Boolean existsByEmail(String email);
}
