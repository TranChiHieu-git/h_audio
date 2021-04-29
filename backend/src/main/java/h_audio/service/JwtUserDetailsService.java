package h_audio.service;

import h_audio.model.DTO.tai_khoan_DTO;
import h_audio.model.nguoi_dung;
import h_audio.model.tai_khoan;
import h_audio.repository.nguoi_dung_repository;
import h_audio.repository.role_repository;
import h_audio.repository.tai_khoan_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private tai_khoan_repository tai_khoan_Dao;
    @Autowired
    private nguoi_dung_repository nguoi_dung_Dao;

    @Autowired
    private PasswordEncoder bcryptEncoder;
    @Autowired
    private role_repository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        tai_khoan user = tai_khoan_Dao.findByAccount(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        ArrayList<GrantedAuthority> arrayList = new ArrayList<>();
        arrayList.add(new SimpleGrantedAuthority(user.getRole().getName()));
        return new org.springframework.security.core.userdetails.User(user.getAccount(), user.getPassword(),
                arrayList);
    }

    public tai_khoan save(tai_khoan_DTO user) {
        nguoi_dung newNguoiDung = new nguoi_dung(user.getTen(), user.getEmail());
        nguoi_dung nguoiDung = nguoi_dung_Dao.save(newNguoiDung);
        tai_khoan newUser = new tai_khoan(user.getAccount(), bcryptEncoder.encode(user.getPassword()), roleRepository.findById(2).orElse(null), nguoiDung);
        return tai_khoan_Dao.save(newUser);
    }
}
