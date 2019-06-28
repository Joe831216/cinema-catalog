package com.example.cinemacatalog.controller;

import com.example.cinemacatalog.feign.NotificationClient;
import com.example.cinemacatalog.feign.OrderingClient;
import com.soselab.vmamvserviceclient.annotation.FeignRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "CinemaCatalogController", tags = "與電影相關的所有一切都在這裡")
@RestController
public class CinemaCatalogController {
    @Autowired
    private NotificationClient notificationClient;
    @Autowired
    private OrderingClient orderingClient;

    @ApiOperation(value = "測試此伺服器是否成功連線", notes = "成功連線就回傳success")
    @CrossOrigin(origins = "*")
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index() {
        return "success";
    }

    @ApiOperation(value = "拿到所有的電影資料", notes = "回傳資料")
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/getAllMovies", method = RequestMethod.GET)
    public void getAllMovies() {}

    @ApiOperation(value = "利用ID找到某個電影", notes = "回傳某電影資料")
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/getMovieByID/{userID}", method = RequestMethod.GET)
    public void getMovieByID(@ApiParam(required = true, name = "userID", value = "使用者編號") @PathVariable("userID") String userID) {}

    @FeignRequest(client = NotificationClient.class, method = "getNotification", parameterTypes = String.class)
    @ApiOperation(value = "拿到所有通知", notes = "回傳通知資料")
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/getNotification/{userID}", method = RequestMethod.GET)
    public void getNotification(@ApiParam(required = true, name = "userID", value = "使用者編號") @PathVariable("userID") String userID) {
        notificationClient.getNotification(userID);
    }

    @FeignRequest(client = OrderingClient.class, method = "orderingMovie", parameterTypes = String.class)
    @ApiOperation(value = "購買電影", notes = "購買成功就回傳成功")
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/orderingMovie/{moviesID}", method = RequestMethod.GET)
    public void orderingMovie(@ApiParam(required = true, name = "ID", value = "電影編號") @PathVariable("moviesID") String moviesID) {
        orderingClient.orderingMovie(moviesID);
    }
}
