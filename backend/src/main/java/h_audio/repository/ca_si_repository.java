package h_audio.repository;

import h_audio.model.casi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ca_si_repository extends JpaRepository<casi, Long> {
    Page<casi> findAllByTenContaining(String ten, Pageable pageable);

    List<casi> findAllByTenContaining(String ten);

    casi findByTen(String ten);
}
