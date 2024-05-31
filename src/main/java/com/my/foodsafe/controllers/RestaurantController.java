package com.my.foodsafe.controllers;

import com.my.foodsafe.pojo.Restaurant;
import com.my.foodsafe.services.IRestaurantService;
import com.my.foodsafe.utilities.IUUIDGenerator;
import com.my.foodsafe.utilities.TestUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.dnd.DragSourceDragEvent;

@Controller
@RequestMapping("/restaurant")
class RestaurantController {

    @Autowired
    private IRestaurantService restaurantService;
    @Autowired
    private TestUpload testUpload;

    @GetMapping("/")
    @ResponseBody
    public String hello() {
        return "";
    }

    // 掃描餐廳時，若餐廳沒被其他使用者掃描過，必須儲存進入資料庫
    @PostMapping("/")
    @ResponseBody
    public Restaurant saveRestaurant(Restaurant restaurant) {
//        restaurantService.saveRestaurant(restaurant, image);
        testUpload.savePhotoLocally("AUGGfZnHB5Ue4Gj8-VycVDqXtAZ6f6hIg9z7AN5fpolColO0EnuDjBGQ_3IAEjLm7Ji88CTjRNdaW1HutDHeGbgExn9hddXuf1_BkftRUS22ORrA2nnngpER3t32G5mEwmYgV7iSz2U3A4iMj8l5COw7O6LHiykVSbrNarLlLY0YJ3Bote9L");
        System.out.println("ddd");
        return restaurant;
    }

    @PostMapping("/scan")
    public ResponseEntity<?> uploadImage(MultipartFile image) {
        try {
            // 檢查上傳的檔案是否存在
            if (image.isEmpty()) {
                return ResponseEntity.badRequest().body("File is empty");
            }

            // 創建上傳目錄(如果不存在)
//            Path uploadPath = Paths.get(UPLOAD_DIRECTORY);
//            Files.createDirectories(uploadPath);
//
//            // 保存上傳的檔案
//            byte[] bytes = file.getBytes();
//            Path filePath = uploadPath.resolve(file.getOriginalFilename());
//            Files.write(filePath, bytes);

            return ResponseEntity.ok("File uploaded successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file");
        }
    }
}