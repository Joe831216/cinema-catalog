package com.example.cinemacatalog.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("notifications")
public interface NotificationClient {

    @GetMapping("/getNotification/{userID}")
    void getNotification(@PathVariable("userID") String ID);

}
