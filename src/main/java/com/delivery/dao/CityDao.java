package com.delivery.dao;

import com.delivery.entity.Areas;
import com.delivery.entity.City;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Yvan
 * @Description city 的 dao 层
 * @Classname CityDao
 * @Date 2020/10/20 16:41
 */
@Repository
public interface CityDao {
    /**
     * 根据provinceId 查询 城市
     *
     * @param provinceId 省 id
     * @return List<City>
     */
    @Select("select id, city_name, province_id from city where province_id = #{provinceId}")
    List<City> selectAreaByProvinceId(@Param("provinceId") String provinceId);
}
