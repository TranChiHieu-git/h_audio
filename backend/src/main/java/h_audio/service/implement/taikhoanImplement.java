package h_audio.service.implement;

import h_audio.model.tai_khoan;
import h_audio.repository.tai_khoan_repository;
import h_audio.service.tai_khoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class taikhoanImplement implements tai_khoanService {
    @Autowired
    tai_khoan_repository taiKhoanService;

    @Override
    public Page<tai_khoan> findAllWithPage(String keySearch, Pageable pageable) {
        return taiKhoanService.findAllByAccountContaining(keySearch, pageable);
    }

    @Override
    public List<tai_khoan> findAll() {
        return taiKhoanService.findAll();
    }

    @Override
    public tai_khoan findById(Long id) {
        return taiKhoanService.findById(id).orElse(null);
    }

    @Override
    public tai_khoan findByAccount(String account) {
        return taiKhoanService.findByAccount(account);
    }

    @Override
    public List<tai_khoan> findByNguoiTao(Long id_nguoi_tao) {
        return taiKhoanService.findAllByNguoiDung_Id(id_nguoi_tao);
    }

    @Override
    public void save(tai_khoan taiKhoan) {
        taiKhoanService.save(taiKhoan);
    }

    @Override
    public void deleteById(Long id) {
        taiKhoanService.deleteById(id);
    }

    public Boolean checkExistByAccount(String account) {
        return taiKhoanService.existsByAccount(account);
    }
}
