package com.delivery.dao;

import com.delivery.entity.Areas;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Yvan
 * @Description areas 表的dao
 * @Classname AreasDao
 * @Date 2020/10/20 16:18
 */
@Repository
public interface AreasDao {

    /**
     * 根据cityId查询 区
     *
     * @param cityId 城市 id
     * @return List<Areas>
     */
    @Select("select id, areas_name, city_id, province_id from areas where city_id = #{cityId}")
    List<Areas> selectAreaByCityId(@Param("cityId") String cityId);

    /**
     * 根据provinceId 查询 区
     *
     * @param provinceId 省 id
     * @return List<Areas>
     */
    @Select("select id, areas_name, city_id, province_id from areas where province_id = #{provinceId}")
    List<Areas> selectAreaByProvinceId(@Param("provinceId") String provinceId);


    /**
     * 根据cityId和provinceId 查询 区
     *
     * @param cityId     城市 id
     * @param provinceId 省 id
     * @return List<Areas>
     */
    @Select("select id, areas_name, city_id, province_id from areas where city_id = #{cityId} and province_id = #{provinceId}")
    List<Areas> selectAreaByCityIdAndProvinceId(@Param("cityId") String cityId, @Param("provinceId") String provinceId);
}
