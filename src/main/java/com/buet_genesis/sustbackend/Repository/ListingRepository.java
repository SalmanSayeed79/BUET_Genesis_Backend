package com.buet_genesis.sustbackend.Repository;

import com.buet_genesis.sustbackend.Entity.Listing;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ListingRepository extends JpaRepository<Listing,Integer> {
    @Query(value="SELECT * FROM  listing  WHERE   listing.listing_id=?1",nativeQuery = true)
    Listing searchByID(Integer id);
    @Query(value="SELECT * FROM  listing  WHERE   listing.email=?1",nativeQuery = true)
    Listing searchByEmail(String email);

    @Query(value="SELECT * FROM  listing  WHERE   listing.shop_id=?1",nativeQuery = true)
    List<Listing> seachByShop(Integer id);

    @Transactional
    @Modifying
    @Query(value="UPDATE listing SET shop_id = ?2, title= ?3, brand=?4, type=?5, price=?6, images=?7, description=?8 WHERE listing.shop_id= ?1",nativeQuery = true)
    int updateUser(Integer shop_id, String title, String brand, Double type, Double price, String images, String description);

}
