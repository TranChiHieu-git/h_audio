package h_audio.service.implement;

import h_audio.model.playlist;
import h_audio.repository.playlist_repository;
import h_audio.service.playlist_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class playlistImplement implements playlist_Service {
    @Autowired
    playlist_repository playlistRepository;


    @Override
    public Page<playlist> findAllWithPage(Pageable pageable) {
        return playlistRepository.findAll(pageable);
    }

    @Override
    public List<playlist> findAll() {
        return playlistRepository.findAll();
    }

    @Override
    public playlist findByTen(String ten) {
        return playlistRepository.findByTenContaining(ten);
    }

    @Override
    public playlist findById(Long id) {
        return playlistRepository.findById(id).orElse(null);
    }

    @Override
    public List<playlist> findByNguoiTao(Long id_nguoi_tao) {
        return playlistRepository.findAllByNguoiTao_Id(id_nguoi_tao);
    }

    @Override
    public void save(playlist playlist) {
        playlistRepository.save(playlist);
    }

    @Override
    public void deleteById(Long id) {
        playlistRepository.deleteById(id);
    }
}
