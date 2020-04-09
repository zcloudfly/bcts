package com.bcts.web.admin.service.fallback;

import com.bcts.common.constants.HttpStatusConstants;
import com.bcts.common.dto.BaseResult;
import com.bcts.common.utils.MapperUtils;
import com.bcts.web.admin.service.AdminService;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

@Component
public class AdminServiceFallback implements AdminService {
    @Override
    public String login(String logincode, String password) {
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
