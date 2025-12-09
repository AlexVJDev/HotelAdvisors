package ru.hotel.ejb.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ru.hotel.domain.entity.HotelEntity;
import ru.hotel.ejb.repository.HotelRepository;
import java.util.List;

@Stateless
public class HotelService {

    @Inject
    private HotelRepository repository;

    public List<HotelEntity> getAllHotels() {
        return repository.findAll();
    }

    public HotelEntity createHotel(HotelEntity hotel) {
        return repository.save(hotel);
    }

    public void deleteHotel(Long id) {
        repository.delete(id);
    }

}
