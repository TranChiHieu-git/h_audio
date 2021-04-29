package h_audio.service.implement;

import h_audio.model.casi;
import h_audio.repository.ca_si_repository;
import h_audio.service.casi_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class casiImplement implements casi_Service {
    @Autowired
    ca_si_repository caSiRepository;

    @Override
    public Page<casi> findAllByTen(String ten, Pageable pageable) {
        return caSiRepository.findAllByTenContaining(ten, pageable);
    }

    @Override
    public List<casi> findAllByTen(String ten) {
        return caSiRepository.findAllByTenContaining(ten);
    }
    public List<casi> findAll() {
        return caSiRepository.findAll();
    }
    @Override
    public casi fingById(Long id) {
        return caSiRepository.findById(id).orElse(null);
    }

    @Override
    public casi findByTen(String ten) {
        return caSiRepository.findByTen(ten);
    }

    @Override
    public void save(casi caSi) {
        caSiRepository.save(caSi);
    }

    @Override
    public void deleteById(Long id) {
        caSiRepository.deleteById(id);
    }
}
