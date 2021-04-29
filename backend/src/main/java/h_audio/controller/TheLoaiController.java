package h_audio.controller;

import h_audio.jwt.JwtTokenUtil;
import h_audio.model.DTO.result;
import h_audio.model.the_loai;
import h_audio.service.implement.taikhoanImplement;
import h_audio.service.implement.theLoaiImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class TheLoaiController {
    @Autowired
    JwtTokenUtil Jwt;
    @Autowired
    theLoaiImplement theLoaiService;
    @Autowired
    taikhoanImplement taiKhoanService;

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/auth/theloai", method = RequestMethod.POST)
    public result create(@RequestBody the_loai theLoai) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            the_loai theLoaiNew = new the_loai(theLoai.getTen(), new Date(), taiKhoanService.findByAccount(authentication.getName()).getNguoiDung());
            theLoaiService.save(theLoaiNew);
            return new result(true, "Thêm mới thành công!");
        } catch (Exception e) {
            return new result(false, "Thêm mới thất bại!");
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/auth/theloai", method = RequestMethod.PUT)
    public result update(@RequestBody the_loai theLoai) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (theLoai != null) {
                theLoai.setNguoiTao(taiKhoanService.findByAccount(authentication.getName()).getNguoiDung());
            }
            theLoaiService.save(theLoai);
            return new result(true, "Cập nhật thành công!");
        } catch (Exception e) {
            return new result(false, "Cập nhật thất bại!");
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/auth/theloai", method = RequestMethod.DELETE)
    public result delete(@RequestBody ArrayList<Long> listId) {
        try {
            listId.forEach((element) -> {
                theLoaiService.deleteById(element);
            });
            return new result(true, "Xóa thành công!");
        } catch (Exception e) {
            return new result(false, "Xóa thất bại!");
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/auth/theloai/{id}", method = RequestMethod.GET)
    public result getById(@PathVariable Long id) {
        try {
            the_loai theLoai = theLoaiService.findById(id);
            return new result(true, "Lấy thể loại thành công!", theLoai);
        } catch (Exception e) {
            return new result(false, "Lấy thể loại thất bại!");
        }
    }

    @RequestMapping(value = "/auth/theloai", method = RequestMethod.GET)
    public result getAllPage() {
        try {
            List<the_loai> listTheLoai = theLoaiService.findAll();
            return new result(true, "Lấy danh sách thành công!", listTheLoai);
        } catch (Exception e) {
            return new result(false, "Lấy danh sách thất bại!");
        }
    }
}
