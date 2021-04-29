package h_audio.controller;

import h_audio.jwt.JwtTokenUtil;
import h_audio.model.DTO.result;
import h_audio.model.playlist;
import h_audio.service.implement.playlistImplement;
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
public class PlayListController {
    @Autowired
    JwtTokenUtil Jwt;
    @Autowired
    playlistImplement playlistService;
    @Autowired
    taikhoanImplement taiKhoanService;

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/auth/playlist", method = RequestMethod.POST)
    public result create(@RequestBody playlist play_list) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            playlist playlistNew = new playlist(play_list.getTen(), new Date(), taiKhoanService.findByAccount(authentication.getName()).getNguoiDung());
            playlistService.save(playlistNew);
            return new result(true, "Thêm mới thành công!");
        } catch (Exception e) {
            return new result(false, "Thêm mới thất bại!");
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/auth/playlist", method = RequestMethod.PUT)
    public result update(@RequestBody playlist play_list) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (play_list != null) {
                play_list.setNguoiTao(taiKhoanService.findByAccount(authentication.getName()).getNguoiDung());
            }
            playlistService.save(play_list);
            return new result(true, "Cập nhật thành công!");
        } catch (Exception e) {
            return new result(false, "Cập nhật thất bại!");
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/auth/playlist", method = RequestMethod.DELETE)
    public result delete(@RequestBody ArrayList<Long> listId) {
        try {
            listId.forEach((element) -> {
                playlistService.deleteById(element);
            });
            return new result(true, "Xóa thành công!");
        } catch (Exception e) {
            return new result(false, "Xóa thất bại!");
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/auth/playlist/{id}", method = RequestMethod.GET)
    public result getById(@PathVariable Long id) {
        try {
            playlist playList = playlistService.findById(id);
            return new result(true, "Lấy playlist thành công!", playList);
        } catch (Exception e) {
            return new result(false, "Lấy playlist thất bại!");
        }
    }

    @RequestMapping(value = "/auth/playlist", method = RequestMethod.GET)
    public result getAllPage() {
        try {
            List<playlist> listplayList = playlistService.findAll();
            return new result(true, "Lấy danh sách thành công!", listplayList);
        } catch (Exception e) {
            return new result(false, "Lấy danh sách thất bại!");
        }
    }
}
