package h_audio.controller;

import h_audio.model.DTO.result;
import h_audio.model.DTO.tai_khoan_DTO;
import h_audio.model.nguoi_dung;
import h_audio.model.tai_khoan;
import h_audio.service.implement.nguoidungImplement;
import h_audio.service.implement.taikhoanImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaiKhoan_NguoiDung_Controller {
    @Autowired
    taikhoanImplement taikhoanService;
    @Autowired
    nguoidungImplement nguoidungService;

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/auth/taikhoan", method = RequestMethod.GET)
    public result getAllTaiKhoan() {
        try {
            List<tai_khoan> listTaiKhoan = taikhoanService.findAll();
            return new result(true, "Lấy danh sách thành công!", listTaiKhoan);
        } catch (Exception e) {
            return new result(false, "Lấy danh sách thất bại!");
        }
    }


    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/auth/taikhoan", method = RequestMethod.PUT)
    public result update(@RequestBody tai_khoan_DTO taikhoanDTO) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            tai_khoan taiKhoanEdit = null;
            if (taikhoanDTO != null) {
                taiKhoanEdit = taikhoanService.findById(taikhoanDTO.getId());
                taiKhoanEdit.setNguoiDung(taikhoanService.findByAccount(authentication.getName()).getNguoiDung());
                taiKhoanEdit.setPassword(taikhoanDTO.getPassword());
                nguoi_dung nguoiDungEdit = nguoidungService.findByEmail(taikhoanDTO.getEmail());
                nguoiDungEdit.setTen(taikhoanDTO.getTen());
                nguoiDungEdit.setEmail(taikhoanDTO.getEmail());
                taiKhoanEdit.setNguoiDung(nguoiDungEdit);
            }
            taikhoanService.save(taiKhoanEdit);
            return new result(true, "Cập nhật thành công!");
        } catch (Exception e) {
            return new result(false, "Cập nhật thất bại!");
        }
    }
}
