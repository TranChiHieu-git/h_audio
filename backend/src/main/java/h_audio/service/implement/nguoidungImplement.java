package h_audio.service.implement;

import h_audio.model.nguoi_dung;
import h_audio.repository.nguoi_dung_repository;
import h_audio.service.nguoi_dung_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class nguoidungImplement implements nguoi_dung_Service {
    @Autowired
    nguoi_dung_repository nguoiDungRepository;

    @Override
    public Page<nguoi_dung> findAllWithPage(String keySearch, Pageable pageable) {
        return nguoiDungRepository.findAllByTenContaining(keySearch, pageable);
    }

    @Override
    public List<nguoi_dung> findAll(Pageable pageable) {
        return nguoiDungRepository.findAll();
    }

    @Override
    public nguoi_dung findById(Long id) {
        return nguoiDungRepository.findById(id).orElse(null);
    }

    @Override
    public nguoi_dung findByHoTen(String hoTen) {
        return nguoiDungRepository.findByTenContaining(hoTen);
    }

    @Override
    public nguoi_dung findByEmail(String email) {
        return nguoiDungRepository.findByEmail(email);
    }

    @Override
    public void save(nguoi_dung nguoiDung) {
        nguoiDungRepository.save(nguoiDung);
    }

    @Override
    public void deleteById(Long id) {
        nguoiDungRepository.deleteById(id);
    }

    public Boolean checkExistByEmail(String email) {
        return nguoiDungRepository.existsByEmail(email);
    }
}
