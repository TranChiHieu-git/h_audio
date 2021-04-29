package h_audio.service.implement;

import h_audio.model.the_loai;
import h_audio.repository.the_loai_repository;
import h_audio.service.the_loai_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class theLoaiImplement implements the_loai_Service {
    @Autowired
    the_loai_repository theLoaiRepository;
    public List<the_loai> findAll() {
        return theLoaiRepository.findAll();
    }
    public Page<the_loai> findAll(Pageable pageable) {
        return theLoaiRepository.findAll(pageable);
    }
    @Override
    public Page<the_loai> findAllByTen(String ten, Pageable pageable) {
        return theLoaiRepository.findAllByTenContaining(ten, pageable);
    }

    @Override
    public List<the_loai> findAllByTen(String ten) {
        return theLoaiRepository.findAllByTenContaining(ten);
    }

    @Override
    public the_loai findById(Long id) {
        return theLoaiRepository.findById(id).orElse(null);
    }

    @Override
    public void save(the_loai theLoai) {
        theLoaiRepository.save(theLoai);
    }

    @Override
    public void deleteById(Long id) {
        theLoaiRepository.deleteById(id);
    }
}
