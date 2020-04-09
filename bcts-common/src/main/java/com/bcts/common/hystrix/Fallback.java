package com.bcts.common.hystrix;

import com.bcts.common.constants.HttpStatusConstants;
import com.bcts.common.dto.BaseResult;
import com.bcts.common.utils.MapperUtils;
import com.google.common.collect.Lists;

/**
 * 通用的熔断方法
 * @author yunfei
 * @description FallBack
 * @Date 2020/4/9 0009
 */
public class Fallback {

    /**
     * 502错误
     * @return
     */

    public static String badGateway(){
        try {
            BaseResult result = BaseResult.notok(
                    Lists.newArrayList(
                            new BaseResult.Error(HttpStatusConstants.BAD_GETEAY.getStatus(),
                                    HttpStatusConstants.BAD_GETEAY.getContent()))
            );
            return  MapperUtils.obj2json(result);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
