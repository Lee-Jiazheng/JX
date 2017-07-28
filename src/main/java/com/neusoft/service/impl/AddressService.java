package com.neusoft.service.impl;

import com.neusoft.mapper.IAddressMapper;
import com.neusoft.model.Address;
import com.neusoft.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Bruce Lee on 2017/7/28.
 */
@Service("addressService")
@Transactional
public class AddressService implements IAddressService{

    @Autowired
    private IAddressMapper addressMapper;

    @Override
    public List<Address> getAllAddressByUserId(int userId) {
        return addressMapper.getAllAddressByUserid(userId);
    }
}
