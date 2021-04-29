package h_audio.service.implement;

import h_audio.model.album;
import h_audio.repository.album_repository;
import h_audio.service.albumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class albumImplement implements albumService {
    @Autowired
    album_repository albumRepository;

    @Override
    public Page<album> findAllWithPage(String keySearch, Pageable pageable) {
        return albumRepository.findAllByTenContaining(keySearch, pageable);
    }

    @Override
    public List<album> findAll() {
        return albumRepository.findAll();
    }

    @Override
    public album findByTen(String ten) {
        return albumRepository.findByTenContaining(ten);
    }

    @Override
    public album findById(Long id) {
        return albumRepository.findById(id).orElse(null);
    }

    @Override
    public Page<album> findByNguoiTaoWithPage(Long id_nguoi_tao, Pageable pageable) {
        return albumRepository.findAllByNguoiTao_Id(id_nguoi_tao, pageable);
    }

    @Override
    public List<album> findByNguoiTao(Long id_nguoi_tao) {
        return albumRepository.findAllByNguoiTao_Id(id_nguoi_tao);
    }


    @Override
    public void save(album album) {
        albumRepository.save(album);
    }

    @Override
    public void deleteById(Long id) {
        albumRepository.deleteById(id);
    }
}
