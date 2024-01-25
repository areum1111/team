package com.store.onedaySeed.service;

import com.store.onedaySeed.entity.Host;
import com.store.onedaySeed.repository.HostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class HostService {

    private final HostRepository hostRepository;

    //아무 이상 없다면 host 정보 저장
    public Host saveHost (Host host){

        return hostRepository.save(host);
    }



}
