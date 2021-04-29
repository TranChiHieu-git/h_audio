package h_audio.repository;

import h_audio.model.bai_hat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface bai_hat_repository extends JpaRepository<bai_hat, Long> {
    List<bai_hat> findAllByNguoiTao_Id(Long id);

    Page<bai_hat> findAllByNguoiTao_Id(Long id, Pageable pageable);

}
