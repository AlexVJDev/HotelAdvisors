package ru.hotel.ejb.repository;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ru.hotel.domain.entity.HotelEntity;
import java.util.List;

@Stateless
public class HotelRepository {

    @PersistenceContext(unitName = "hotelPU")
    private EntityManager em;

    // For test if need it.
    /*public void setEntityManager(EntityManager em) {
        this.em = em;
    }*/

    public HotelEntity findById(Long id) {
        return em.find(HotelEntity.class, id);
    }

    public List<HotelEntity> findAll() {
        return em.createQuery("select h from HotelEntity h", HotelEntity.class)
                .getResultList();
    }

    public HotelEntity save(HotelEntity hotel) {
        if (hotel.getId() == null) {
            em.persist(hotel);
            return hotel;
        } else {
            return em.merge(hotel);
        }
    }

    public void delete(Long id) {
        HotelEntity hotel = findById(id);
        if (hotel != null) {
            em.remove(hotel);
        }
    }
}
