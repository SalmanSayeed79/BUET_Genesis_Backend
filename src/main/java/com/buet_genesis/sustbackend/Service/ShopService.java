package com.buet_genesis.sustbackend.Service;


import com.buet_genesis.sustbackend.Entity.Shop;
import com.buet_genesis.sustbackend.Repository.ShopRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class ShopService {
    @Autowired
    ShopRepository shopRepository;

    @RequestMapping(value="/shops",method= RequestMethod.GET)
    public List<Shop> getShops(){
        List<Shop> allUsers=shopRepository.findAll();
        return allUsers;
    }
    @RequestMapping(value="/shop",method= RequestMethod.POST)
    public ResponseEntity<Object> addUser(@RequestBody Shop newUser){
        System.out.println(newUser);
        if(shopRepository.searchByID(newUser.getShop_id())!=null){
            JSONObject json=new JSONObject();
            json.put("message","User with id "+newUser.getShop_id()+" already exists");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(json.toString());
        }
        Shop user=shopRepository.saveAndFlush(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
    @RequestMapping(value="/shop/{id}",method = RequestMethod.GET,produces = {"application/json"})
    public ResponseEntity<Object> getUser(@PathVariable("id") Integer id){
        Shop ret=shopRepository.searchByID(id);
        if(ret==null){
            JSONObject json=new JSONObject();
            json.put("message","User with id "+id+" not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(json.toString());
        }
        return ResponseEntity.status(HttpStatus.OK).body(ret);

    }
    @RequestMapping(value="/shop/email/{email}",method = RequestMethod.GET,produces = {"application/json"})
    public ResponseEntity<Object> getByEmail(@PathVariable("email") String mail){
        Shop ret=shopRepository.searchByEmail(mail);
        if(ret==null){
            JSONObject json=new JSONObject();
            json.put("message","User with mail "+mail+" not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(json.toString());
        }
        return ResponseEntity.status(HttpStatus.OK).body(ret);

    }
    @RequestMapping(value="/shop/{id}",method= RequestMethod.PUT)
    public int updateProduct(@PathVariable("id") Integer id,@RequestBody Shop shop) {
        try{
            shopRepository.updateUser(
                    id,
                    shop.getShop_name(),
                    shop.getEmail(),
                    shop.getAddress(),
                    shop.getLat(),
                    shop.getLng(),
                    shop.getColor(),
                    shop.getPicture(),
                    shop.getCover_pic()
            );
            return 1;
        }
        catch (EmptyResultDataAccessException e){
            return 0;
        }

    }


}
