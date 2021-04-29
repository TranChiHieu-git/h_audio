package h_audio.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "play_list")
public class playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ten")
    private String ten;
    @Column(name = "ngay_tao")
    private Date ngayTao;

    @ManyToOne
    @JoinColumn(name = "nguoi_tao")
    @JsonBackReference
    private nguoi_dung nguoiTao;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "play_list_bai_hat",
            joinColumns = @JoinColumn(name = "play_list_id"),
            inverseJoinColumns = @JoinColumn(name = "bai_hat_id")
    )
    private Collection<bai_hat> baiHat;

    public playlist() {
    }

    public playlist(String ten, Date ngayTao, nguoi_dung nguoiTao) {
        this.ten = ten;
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
