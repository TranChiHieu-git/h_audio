package h_audio.repository;

import h_audio.model.the_loai;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface the_loai_repository extends JpaRepository<the_loai, Long> {
    Page<the_loai> findAllByTenContaining(String ten, Pageable pageable);

    List<the_loai> findAllByTenContaining(String ten);
}
