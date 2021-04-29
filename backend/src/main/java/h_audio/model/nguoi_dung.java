package h_audio.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "nguoi_dung")
public class nguoi_dung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "ten")
    private String ten;
    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "nguoiTao", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Collection<bai_hat> baiHat;

    @OneToMany(mappedBy = "nguoiTao", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Collection<the_loai> theLoai;

    @OneToMany(mappedBy = "nguoiTao", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Collection<album> album;

    @OneToMany(mappedBy = "nguoiTao", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Collection<playlist> playlist;

    @OneToMany(mappedBy = "nguoiTao", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Collection<casi> casi;

    public nguoi_dung() {
    }

    public nguoi_dung(String ten, String email) {
        this.ten = ten;
        this.email = email;
    }

    public Collection<bai_hat> getBaiHat() {
        return baiHat;
    }

    public void setBaiHat(Collection<bai_hat> baiHat) {
        this.baiHat = baiHat;
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

    public Collection<casi> getCasi() {
        return casi;
    }

    public void setCasi(Collection<casi> Casi) {
        this.casi = Casi;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
