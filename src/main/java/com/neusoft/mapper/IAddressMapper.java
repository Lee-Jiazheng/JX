package com.neusoft.mapper;

import com.neusoft.model.Address;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by Bruce Lee on 2017/7/25.
 */
public interface IAddressMapper {
    @Select("select * from address where addressowner = #{userid}")
    public List<Address> getAllAddressByUserid(int userid);

    @Insert("insert into address values(#{userid}, #{address})")
    public int addAddressByAddress(String address, int userid);
}
