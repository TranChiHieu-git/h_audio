package h_audio.controller;

import h_audio.jwt.JwtTokenUtil;
import h_audio.model.DTO.result;
import h_audio.model.DTO.tai_khoan_DTO;
import h_audio.model.JwtRequest;
import h_audio.model.JwtResponse;
import h_audio.model.tai_khoan;
import h_audio.service.JwtUserDetailsService;
import h_audio.service.implement.nguoidungImplement;
import h_audio.service.implement.taikhoanImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class JwtAuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;
    @Autowired
    private JwtUserDetailsService userDetailsService;
    @Autowired
    private taikhoanImplement TaiKhoanService;
    @Autowired
    private nguoidungImplement NguoiDungService;

    @RequestMapping(value = "/dangnhap", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getAccount(), authenticationRequest.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getAccount());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @RequestMapping(value = "/dangky", method = RequestMethod.POST)
    public result saveUser(@RequestBody tai_khoan_DTO user) {
        try {
            if (!TaiKhoanService.checkExistByAccount(user.getAccount()) && !NguoiDungService.checkExistByEmail(user.getEmail())) {
                userDetailsService.save(user);
                return new result(true, "Đăng ký thành công!");
            } else {
                return new result(false, "Đăng ký thất bại!");
            }
        } catch (Exception e) {
            return new result(false, "Đăng ký thất bại!");
        }
    }

    @RequestMapping(value = "/checktoken", method = RequestMethod.POST)
    public result checkToken(@RequestBody String token) {
        if (token.charAt(0) == ('\"')) {
            token = token.substring(1, token.length() - 1);
        }
        try {
            String account = jwtTokenUtil.getUsernameFromToken(token);
            UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(account);
            if (jwtTokenUtil.validateToken(token, userDetails)) {
                tai_khoan taiKhoanEdit = TaiKhoanService.findByAccount(account);
                tai_khoan_DTO resultTaiKhoan = new tai_khoan_DTO();
                resultTaiKhoan.setId(taiKhoanEdit.getId());
                resultTaiKhoan.setAccount(taiKhoanEdit.getAccount());
                resultTaiKhoan.setEmail(taiKhoanEdit.getNguoiDung().getEmail());
                resultTaiKhoan.setTen(taiKhoanEdit.getNguoiDung().getTen());
                return new result(true, "Hợp lệ!", resultTaiKhoan);
            } else {
                return new result(false, "Không hợp lệ!");
            }
        } catch (Exception e) {
            return new result(false, "Xảy ra lỗi !");
        }
    }

    private void authenticate(String account, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(account, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
