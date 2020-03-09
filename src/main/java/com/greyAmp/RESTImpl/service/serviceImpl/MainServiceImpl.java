package com.greyAmp.RESTImpl.service.serviceImpl;

import com.greyAmp.RESTImpl.model.GreyAmpTable;
import com.greyAmp.RESTImpl.repository.MainRepository;
import com.greyAmp.RESTImpl.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainServiceImpl implements MainService {

    @Autowired
    MainRepository mainRepository;

    @Override
    public List<GreyAmpTable> fetchAllInputs() {
        return mainRepository.findAll();
    }

    @Override
    public GreyAmpTable addNew(GreyAmpTable gat) {
        return mainRepository.save(gat);
    }
}
