package h_audio.service.implement;

import h_audio.model.bai_hat;
import h_audio.repository.bai_hat_repository;
import h_audio.service.bai_hat_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class baihatImplement implements bai_hat_Service {
    @Autowired
    bai_hat_repository baiHatRepository;

    @Override
    public void save(bai_hat baiHat) {
        baiHatRepository.save(baiHat);
    }

    @Override
    public void deleteById(Long id) {
        baiHatRepository.deleteById(id);
    }

    @Override
    public List<bai_hat> findAll() {
        return baiHatRepository.findAll();
    }

    @Override
    public Page<bai_hat> findAll(Pageable pageable) {
        return baiHatRepository.findAll(pageable);
    }

    @Override
    public List<bai_hat> findByTen(String ten) {
        return null;
    }

    @Override
    public Page<bai_hat> findByTen(String ten, Pageable pageable) {
        return null;
    }

    @Override
    public List<bai_hat> findByNguoiTao(Long id) {
        return baiHatRepository.findAllByNguoiTao_Id(id);
    }

    @Override
    public Page<bai_hat> findByNguoiTao(Long id, Pageable pageable) {
        return baiHatRepository.findAllByNguoiTao_Id(id, pageable);
    }

    @Override
    public List<bai_hat> findByAlbum(Long id) {
        EntityManager em = null;
        TypedQuery<bai_hat> query = em.createQuery(
                new StringBuilder()
                        .append("SELECT b From bai_hat b ")
                        .append("left join album_bai_hat ab on b.id=ab.bai_hat_id ")
                        .append("left join album a on a.id=ab.play_list_id ")
                        .append("where album_id = :albumId")
                        .toString(),
                bai_hat.class);

        query.setParameter("albumId", id);

        List<bai_hat> baiHatList = query.setFirstResult(5)
                .setMaxResults(5)
                .getResultList();
        return baiHatList;
    }

    public List<bai_hat> findByPlayList(Long id) {
        EntityManager em = null;
        TypedQuery<bai_hat> query = em.createQuery(
                new StringBuilder()
                        .append("SELECT b From bai_hat b ")
                        .append("left join play_list_bai_hat pb on b.id=pb.bai_hat_id ")
                        .append("left join play_list p on p.id=pb.play_list_id ")
                        .append("where play_list_id = :playListId")
                        .toString(),
                bai_hat.class);

        query.setParameter("playListId", id);

        List<bai_hat> baiHatList = query.setFirstResult(5)
                .setMaxResults(5)
                .getResultList();
        return baiHatList;
    }

    public bai_hat findBaiHatById(Long id) {
        return baiHatRepository.findById(id).orElse(null);
    }
}
