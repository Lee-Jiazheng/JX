package com.neusoft.mapper;

import com.neusoft.model.Address;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Bruce Lee on 2017/7/25.
 */
public interface IAddressMapper {
    @Select("select * from address where addressowner = #{userid}")
    public List<Address> getAllAddressByUserid(int userid);

    @Insert("insert into address(addressOwner,addressname,isdefault,phoneNum,contactName) values(#{addressownerid}, #{addressname}, 0, #{phonenum}, #{contactname})")
    public int addAddressByAddress(Address address);

    @Update("update address set addressname=#{addressname},isdefault=#{isdefault}, phoneNum=#{phonenum},contactName= #{contactname} where addressid= #{addressid}")
    public int editAddressByAddress(Address address);

    @Delete("delete from address where addressid=#{addressid}")
    public int delAddressById(@Param("addressid") int address);
}
