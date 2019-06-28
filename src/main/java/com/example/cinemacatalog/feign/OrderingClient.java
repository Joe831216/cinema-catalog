package com.example.cinemacatalog.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("ordering")
public interface OrderingClient {

    @GetMapping("/newMovieOrdering/{moviesID}")
    void orderingMovie(@PathVariable("moviesID") String moviesID);

}
