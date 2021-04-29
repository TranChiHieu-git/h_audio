package h_audio.service.implement;

import h_audio.model.role;
import h_audio.repository.role_repository;
import h_audio.service.roleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class roleImplement implements roleService {
    @Autowired
    role_repository roleRepository;

    @Override
    public List<role> findAll(Pageable pageable) {
        return roleRepository.findAll();
    }

    @Override
    public role findById(int id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public role findByName(String name) {
        return roleRepository.findByNameContaining(name);
    }


    @Override
    public void save(role Role) {
        roleRepository.save(Role);
    }

    @Override
    public void deleteById(int id) {
        roleRepository.deleteById(id);
    }
}
