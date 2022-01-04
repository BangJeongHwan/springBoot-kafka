package com.ums.service;

import static com.ums.utils.ModelMapperUtils.getModelMapper;

import com.ums.domain.OnlinePushQue;
import com.ums.domain.OnlineXmsQue;
import com.ums.model.online.OnlinePushQueDto;
import com.ums.model.online.OnlineXmsQueDto;
import com.ums.repository.OnlinePushQueRepository;
import com.ums.repository.OnlineXmsQueRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class TasonIntegrationService {

    private final OnlinePushQueRepository onlinePushQueRepository;
    private final OnlineXmsQueRepository onlineXmsQueRepository;

    public void insertOnlinePushQue(OnlinePushQueDto dto){
        OnlinePushQue domain = getModelMapper().map(dto, OnlinePushQue.class);
        OnlinePushQue rs = onlinePushQueRepository.save(domain);
        if(rs!=null){
            log.info("insertOnlinePushQue success");
        }else{
            log.info("insertOnlinePushQue fail");
        }
    }

    public void insertOnlineXmsQue(OnlineXmsQueDto dto){
        OnlineXmsQue domain = getModelMapper().map(dto, OnlineXmsQue.class);
        OnlineXmsQue rs = onlineXmsQueRepository.save(domain);
        if(rs!=null){
            log.info("insertOnlineXmsQue success");
        }else{
            log.info("insertOnlineXmsQue fail");
        }
    }
}
