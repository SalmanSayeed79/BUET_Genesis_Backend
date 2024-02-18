package com.buet_genesis.sustbackend.Repository;


import com.buet_genesis.sustbackend.Entity.Shop;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ShopRepository extends JpaRepository<Shop,Integer> {
    @Query(value="SELECT * FROM  shop  WHERE   shop.shop_id=?1",nativeQuery = true)
     Shop searchByID(Integer id);
    @Query(value="SELECT * FROM  shop  WHERE   shop.email=?1",nativeQuery = true)
    Shop searchByEmail(String email);

    @Query(value="SELECT * FROM  shop  WHERE shop.name=?1 ORDER BY shop.name ASC",nativeQuery = true)
     Shop searchByName(String name);

    @Transactional
    @Modifying
    @Query(value="UPDATE shop SET shop_name = ?2, email= ?3, address=?4, lat=?5, lng=?6, color=?7, picture=?8, cover_pic=?9 WHERE shop.shop_id= ?1",nativeQuery = true)
    int updateUser(Integer shopID,String name, String email,String address,Double lat,Double lng,String color,String picture, String cp);

}
