package h_audio.controller;

import h_audio.jwt.JwtTokenUtil;
import h_audio.model.DTO.result;
import h_audio.model.casi;
import h_audio.service.implement.casiImplement;
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
public class CasiController {
    @Autowired
    JwtTokenUtil Jwt;
    @Autowired
    casiImplement casiService;
    @Autowired
    taikhoanImplement taiKhoanService;

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/auth/casi", method = RequestMethod.POST)
    public result create(@RequestBody casi caSi) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            casi casiNew = new casi(caSi.getTen(), caSi.getGioiThieu(), new Date(), taiKhoanService.findByAccount(authentication.getName()).getNguoiDung());
            casiService.save(casiNew);
            return new result(true, "Thêm mới thành công!");
        } catch (Exception e) {
            return new result(false, "Thêm mới thất bại!");
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/auth/casi", method = RequestMethod.PUT)
    public result update(@RequestBody casi caSi) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (caSi != null) {
                caSi.setNguoiTao(taiKhoanService.findByAccount(authentication.getName()).getNguoiDung());
            }
            casiService.save(caSi);
            return new result(true, "Cập nhật thành công!");
        } catch (Exception e) {
            return new result(false, "Cập nhật thất bại!");
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/auth/casi", method = RequestMethod.DELETE)
    public result delete(@RequestBody ArrayList<Long> listId) {
        try {
            listId.forEach((element) -> {
                casiService.deleteById(element);
            });
            return new result(true, "Xóa thành công!");
        } catch (Exception e) {
            return new result(false, "Xóa thất bại!");
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/auth/casi/{id}", method = RequestMethod.GET)
    public result getById(@PathVariable Long id) {
        try {
            casi caSi = casiService.fingById(id);
            return new result(true, "Lấy ca sĩ thành công!", caSi);
        } catch (Exception e) {
            return new result(false, "Lấy ca sĩ thất bại!");
        }
    }

    @RequestMapping(value = "/auth/casi", method = RequestMethod.GET)
    public result getAllPage() {
        try {
            List<casi> listCasi = casiService.findAll();
            return new result(true, "Lấy danh sách thành công!", listCasi);
        } catch (Exception e) {
            return new result(false, "Lấy danh sách thất bại!");
        }
    }
}
