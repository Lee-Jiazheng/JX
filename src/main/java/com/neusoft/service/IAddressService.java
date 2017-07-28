package com.neusoft.service;

import com.neusoft.model.Address;
import java.util.List;
/**
 * Created by Bruce Lee on 2017/7/28.
 */
public interface IAddressService {
    public List<Address> getAllAddressByUserId(int userId);
}
