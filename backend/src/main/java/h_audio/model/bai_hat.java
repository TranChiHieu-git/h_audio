package h_audio.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "bai_hat")
public class bai_hat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ten")
    private String ten;
    @Column(name = "url")
    private String url;
    @Column(name = "ngay_tao")
    private Date ngayTao;

    @ManyToOne
    @JoinColumn(name = "nguoi_tao")
    @JsonBackReference
    private nguoi_dung nguoiTao;


    @ManyToMany(mappedBy = "baiHat")
    private Collection<the_loai> theLoai;

    @ManyToMany(mappedBy = "baiHat")
    private Collection<album> album;

    @ManyToMany(mappedBy = "baiHat")
    private Collection<playlist> playlist;

    @ManyToMany(mappedBy = "baiHat")
    private Collection<casi> casi;

    public bai_hat() {
    }

    public bai_hat(String ten, String url, Date ngayTao, nguoi_dung nguoiTao, Collection<the_loai> theLoai, Collection<h_audio.model.casi> casi) {
        this.ten = ten;
        this.url = url;
        this.ngayTao = ngayTao;
        this.nguoiTao = nguoiTao;
        this.theLoai = theLoai;
        this.casi = casi;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public Collection<the_loai> getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(Collection<the_loai> theLoai) {
        this.theLoai = theLoai;
    }

    public Collection<h_audio.model.album> getAlbum() {
        return album;
    }

    public void setAlbum(Collection<h_audio.model.album> album) {
        this.album = album;
    }

    public Collection<h_audio.model.playlist> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Collection<h_audio.model.playlist> playlist) {
        this.playlist = playlist;
    }

    public Collection<h_audio.model.casi> getCasi() {
        return casi;
    }

    public void setCasi(Collection<h_audio.model.casi> casi) {
        this.casi = casi;
    }
}
