package com.delivery.dao;

import com.delivery.entity.Areas;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Yvan
 * @Description
 * @Classname AreasDaoTest
 * @Date 2020/10/20 17:01
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AreasDaoTest {

    @Resource
    private AreasDao areasDao;

    @Test
    public void selectAreaByCityIdNull() {
        List<Areas> areas = areasDao.selectAreaByCityId("11011");
        assertTrue(areas.isEmpty());
    }

    @Test
    public void selectAreaByCityIdNotNull() {
        List<Areas> areas = areasDao.selectAreaByCityId("1101");
        assertFalse(areas.isEmpty());
    }

    @Test
    public void selectAreaByProvinceIdNull() {
        List<Areas> areas = areasDao.selectAreaByProvinceId("99");
        assertTrue(areas.isEmpty());
    }

    @Test
    public void selectAreaByProvinceIdNotNull() {
        List<Areas> areas = areasDao.selectAreaByProvinceId("11");
        assertFalse(areas.isEmpty());
    }

    @Test
    public void selectAreaByCityIdAndProvinceIdNull() {
        List<Areas> areas = areasDao.selectAreaByCityIdAndProvinceId("1180", "99");
        assertTrue(areas.isEmpty());
    }

    @Test
    public void selectAreaByCityIdAndProvinceIdNotNull() {
        List<Areas> areas = areasDao.selectAreaByCityIdAndProvinceId("1101", "11");
        assertFalse(areas.isEmpty());
    }
}