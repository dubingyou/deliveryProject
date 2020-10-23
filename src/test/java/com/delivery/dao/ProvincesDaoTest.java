package com.delivery.dao;

import com.delivery.entity.Provinces;
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
 * @Classname ProvincesDaoTest
 * @Date 2020/10/20 16:54
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ProvincesDaoTest {

    @Resource
    private ProvincesDao provincesDao;

    @Test
    public void selectAll() {
        List<Provinces> provinces = provincesDao.selectAll();
        assertNotNull(provinces);
    }
}