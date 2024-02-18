package com.buet_genesis.sustbackend.Service;

import com.buet_genesis.sustbackend.Entity.Listing;
import com.buet_genesis.sustbackend.Entity.Shop;
import com.buet_genesis.sustbackend.Repository.ListingRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class ListingService {
    @Autowired
    ListingRepository listingRepository;

    @RequestMapping(value="/listings",method= RequestMethod.GET)
    public List<Listing> getShops(){
        List<Listing> allUsers= listingRepository.findAll();
        return allUsers;
    }
    @RequestMapping(value="/listing",method= RequestMethod.POST)
    public ResponseEntity<Object> addUser(@RequestBody Listing newUser){
        //System.out.println(newUser);
        if( listingRepository.searchByID(newUser.getShop_id())!=null){
            JSONObject json=new JSONObject();
            json.put("message","User with id "+newUser.getShop_id()+" already exists");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(json.toString());
        }
        Listing user= listingRepository.saveAndFlush(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
    @RequestMapping(value="/listing/{id}",method = RequestMethod.GET,produces = {"application/json"})
    public ResponseEntity<Object> getUser(@PathVariable("id") Integer id){
        Listing ret= listingRepository.searchByID(id);
        if(ret==null){
            JSONObject json=new JSONObject();
            json.put("message","User with id "+id+" not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(json.toString());
        }
        return ResponseEntity.status(HttpStatus.OK).body(ret);

    }
    @RequestMapping(value="/listing/shop/{id}",method = RequestMethod.GET,produces = {"application/json"})
    public ResponseEntity<Object> getByshop(@PathVariable("id") Integer id){
        List<Listing> ret= listingRepository.seachByShop(id);
        if(ret==null){
            JSONObject json=new JSONObject();
            json.put("message","User with mail "+id+" not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(json.toString());
        }
        return ResponseEntity.status(HttpStatus.OK).body(ret);

    }
}
