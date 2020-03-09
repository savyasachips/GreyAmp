package com.greyAmp.RESTImpl.repository;

import com.greyAmp.RESTImpl.model.GreyAmpTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MainRepository extends JpaRepository<GreyAmpTable,Integer> {
}
