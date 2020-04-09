package com.bcts.service.sso.consumer.fallback;

import com.bcts.common.constants.HttpStatusConstants;
import com.bcts.common.dto.BaseResult;
import com.bcts.common.hystrix.Fallback;
import com.bcts.common.utils.MapperUtils;
import com.bcts.service.sso.consumer.RedisService;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

/**
 * @author yunfei
 * @description RedisServiceFallback
 * @Date 2020/4/9 0009
 */
@Component
public class RedisServiceFallback implements RedisService {
    @Override
    public String put(String key, String value, long seconds) {
        return null;
    }

    @Override
    public String get(String key) {
        return null;
    }
}
