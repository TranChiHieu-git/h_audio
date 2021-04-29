package h_audio.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "album")
public class album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ten")
    private String ten;
    @Column(name = "gioi_thieu")
    private String gioiThieu;
    @Column(name = "ngay_tao")
    private Date ngayTao;

    @ManyToOne
    @JoinColumn(name = "nguoi_tao")
    @JsonBackReference
    private nguoi_dung nguoiTao;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "album_bai_hat",
            joinColumns = @JoinColumn(name = "album_id"),
            inverseJoinColumns = @JoinColumn(name = "bai_hat_id")
    )
    private Collection<bai_hat> baiHat;

    public album() {
    }

    public album(String ten, String gioiThieu, Date ngayTao, nguoi_dung nguoiTao) {
        this.ten = ten;
        this.gioiThieu = gioiThieu;
        this.ngayTao = ngayTao;
        this.nguoiTao = nguoiTao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioiThieu() {
        return gioiThieu;
    }

    public void setGioiThieu(String gioiThieu) {
        this.gioiThieu = gioiThieu;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public nguoi_dung getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(nguoi_dung nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public Collection<bai_hat> getBaiHat() {
        return baiHat;
    }

    public void setBaiHat(Collection<bai_hat> baiHat) {
        this.baiHat = baiHat;
    }

}
