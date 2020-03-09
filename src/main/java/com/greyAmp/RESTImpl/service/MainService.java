package com.greyAmp.RESTImpl.service;

import com.greyAmp.RESTImpl.model.GreyAmpTable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MainService {
    List<GreyAmpTable> fetchAllInputs();
    GreyAmpTable addNew(GreyAmpTable gat);
}
