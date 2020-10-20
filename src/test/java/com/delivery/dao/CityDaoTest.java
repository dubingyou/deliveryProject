package com.delivery.dao;

import com.delivery.entity.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Yvan
 * @Description
 * @Classname CityDaoTest
 * @Date 2020/10/20 17:19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CityDaoTest {

    @Resource
    private CityDao cityDao;

    @Test
    public void selectAreaByProvinceIdNull() {
        List<City> cities = cityDao.selectAreaByProvinceId("99");
        assertTrue(cities.isEmpty());
    }

    @Test
    public void selectAreaByProvinceIdNotNull() {
        List<City> cities = cityDao.selectAreaByProvinceId("11");
        assertFalse(cities.isEmpty());
    }
}