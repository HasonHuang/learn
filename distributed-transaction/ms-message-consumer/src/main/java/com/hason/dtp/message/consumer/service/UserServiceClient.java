package com.hason.dtp.message.consumer.service;

import com.hason.dtp.account.api.UserApi;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * 用户微服务客户端
 *
 * @author Huanghs
 * @since 2.0
 * @date 2017/11/12
 */
@FeignClient(name = "ms-account")
public interface UserServiceClient extends UserApi {
}
