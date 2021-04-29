package h_audio.controller;

import h_audio.model.DTO.result;
import h_audio.model.album;
import h_audio.service.implement.albumImplement;
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
public class AlbumController {
    @Autowired
    albumImplement albumService;
    @Autowired
    taikhoanImplement taiKhoanService;

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/auth/album", method = RequestMethod.POST)
    public result create(@RequestBody album alBum) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            album albumNew = new album(alBum.getTen(), alBum.getGioiThieu(), new Date(), taiKhoanService.findByAccount(authentication.getName()).getNguoiDung());
            albumService.save(albumNew);
            return new result(true, "Thêm mới thành công!");
        } catch (Exception e) {
            return new result(false, "Thêm mới thất bại!");
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/auth/album", method = RequestMethod.PUT)
    public result update(@RequestBody album alBum) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (alBum != null) {
                alBum.setNguoiTao(taiKhoanService.findByAccount(authentication.getName()).getNguoiDung());
            }
            albumService.save(alBum);
            return new result(true, "Cập nhật thành công!");
        } catch (Exception e) {
            return new result(false, "Cập nhật thất bại!");
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/auth/album", method = RequestMethod.DELETE)
    public result delete(@RequestBody ArrayList<Long> listId) {
        try {
            listId.forEach((element) -> {
                albumService.deleteById(element);
            });
            return new result(true, "Xóa thành công!");
        } catch (Exception e) {
            return new result(false, "Xóa thất bại!");
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/auth/album/{id}", method = RequestMethod.GET)
    public result getById(@PathVariable Long id) {
        try {
            album alBum = albumService.findById(id);
            return new result(true, "Lấy album thành công!", alBum);
        } catch (Exception e) {
            return new result(false, "Lấy album thất bại!");
        }
    }

    @RequestMapping(value = "/auth/album", method = RequestMethod.GET)
    public result getAllPage() {
        try {
            List<album> listalBum = albumService.findAll();
            return new result(true, "Lấy danh sách thành công!", listalBum);
        } catch (Exception e) {
            return new result(false, "Lấy danh sách thất bại!");
        }
    }
}
