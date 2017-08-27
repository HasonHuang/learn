package com.hason.service;

import com.hason.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;


@Service
public class AggregationService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    public Observable<User> getUserById(Long id) {
        // 创建一个被观察者
        return Observable.create(subscriber -> {
            // 请求用户微服务的/{id}端点
            User user = restTemplate.getForObject("http://microservice-provider-user/{id}", User.class, id);
            subscriber.onNext(user);
            subscriber.onCompleted();
        });
    }

    @HystrixCommand(fallbackMethod = "fallback")
    public Observable<User> getMovieUserByUserId(Long id) {
        return Observable.create(subscriber -> {
            // 请求电影微服务的/users/{id}端点
            User user = restTemplate.getForObject("http://microservice-consumer-movie/users/{id}", User.class, id);
            subscriber.onNext(user);
            subscriber.onCompleted();
        });
    }

    private User fallback(Long id) {
        User user = new User();
        user.setId(id);
        return user;
    }
}
