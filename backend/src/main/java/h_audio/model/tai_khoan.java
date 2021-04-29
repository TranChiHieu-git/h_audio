package h_audio.model;

import javax.persistence.*;

@Entity
@Table(name = "tai_khoan")
public class tai_khoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "account")
    private String account;
    @Column(name = "password")
    private String password;
    @OneToOne
    @JoinColumn(name = "role_id")
    private role role;
    @OneToOne
    @JoinColumn(name = "nguoi_dung_id")
    private nguoi_dung nguoiDung;

    public tai_khoan() {
    }

    public tai_khoan(String account, String password, role roles, nguoi_dung nguoiDung) {
        this.account = account;
        this.password = password;
        this.role = roles;
        this.nguoiDung = nguoiDung;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public h_audio.model.role getRole() {
        return role;
    }

    public void setRole(h_audio.model.role role) {
        this.role = role;
    }

    public nguoi_dung getNguoiDung() {
        return nguoiDung;
    }

    public void setNguoiDung(nguoi_dung nguoiDung) {
        this.nguoiDung = nguoiDung;
    }
}

