package com.my.foodsafe.services;

import com.my.foodsafe.pojo.Restaurant;
import com.my.foodsafe.utilities.IImageUtility;
import com.my.foodsafe.utilities.IUUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Service
public class RestaurantImpl implements IRestaurantService {

    @Autowired
    private IUUIDGenerator iuuidGenerator;
    @Autowired
    private IImageUtility iImageUtility;

    @Override
    public Restaurant saveRestaurant(Restaurant restaurant, MultipartFile image) {
        String id = iuuidGenerator.getUUID();
        String path = iImageUtility.generatePath(image);
        restaurant.setRestaurantId(id);
        restaurant.setRestaurantImage(path);
        return restaurant;
    }
}
