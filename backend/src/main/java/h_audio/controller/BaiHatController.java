package h_audio.controller;

import h_audio.jwt.JwtTokenUtil;
import h_audio.model.DTO.result;
import h_audio.model.bai_hat;
import h_audio.service.implement.baihatImplement;
import h_audio.service.implement.taikhoanImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class BaiHatController {
    @Autowired
    JwtTokenUtil Jwt;
    @Autowired
    baihatImplement baihatService;
    @Autowired
    taikhoanImplement taiKhoanService;

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/auth/baihat", method = RequestMethod.POST)
    public result create(@RequestBody bai_hat baiHat) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            bai_hat baihatNew = new bai_hat(
                    baiHat.getTen(),
                    baiHat.getUrl(),
                    new Date(),
                    taiKhoanService.findByAccount(authentication.getName()).getNguoiDung(),
                    baiHat.getTheLoai(),
                    baiHat.getCasi()
            );
            baihatService.save(baihatNew);
            return new result(true, "Thêm mới thành công!");
        } catch (Exception e) {
            return new result(false, "Thêm mới thất bại!");
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/auth/baihat", method = RequestMethod.PUT)
    public result update(@RequestBody bai_hat baiHat) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (baiHat != null) {
                baiHat.setNguoiTao(taiKhoanService.findByAccount(authentication.getName()).getNguoiDung());
            }
            baihatService.save(baiHat);
            return new result(true, "Cập nhật thành công!");
        } catch (Exception e) {
            return new result(false, "Cập nhật thất bại!");
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/auth/baihat", method = RequestMethod.DELETE)
    public result delete(@RequestBody ArrayList<Long> listId) {
        try {
            listId.forEach((element) -> {
                baihatService.deleteById(element);
            });
            return new result(true, "Xóa thành công!");
        } catch (Exception e) {
            return new result(false, "Xóa thất bại!");
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/auth/baihat/{id}", method = RequestMethod.GET)
    public result getById(@PathVariable Long id) {
        try {
            bai_hat baiHat = baihatService.findBaiHatById(id);
            return new result(true, "Lấy bài hát thành công!", baiHat);
        } catch (Exception e) {
            return new result(false, "Lấy bài hát thất bại!");
        }
    }

    @RequestMapping(value = "/auth/baihat", method = RequestMethod.GET)
    public result getAllPage() {
        try {
            List<bai_hat> listBaiHat = baihatService.findAll();
            return new result(true, "Lấy danh sách thành công!", listBaiHat);
        } catch (Exception e) {
            return new result(false, "Lấy danh sách thất bại!");
        }
    }
}
