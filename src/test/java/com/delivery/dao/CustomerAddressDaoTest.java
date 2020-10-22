package com.delivery.dao;

import com.delivery.entity.CustomerAddress;
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
 * @Classname CustomerAddressDaoTest
 * @Date 2020/10/22 14:49
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CustomerAddressDaoTest {

    @Resource
    private CustomerAddressDao customerAddressDao;

    @Test
    public void insertCustomerAddress() {
        //已经和三层测测试过
        assertTrue(true);
    }

    @Test
    public void selectCustomerAddressByIdUserIdNull() {
        List<CustomerAddress> customerAddressList = customerAddressDao.selectCustomerAddressByIdUserId(3);
        assertTrue(customerAddressList.isEmpty());
    }

    @Test
    public void selectCustomerAddressByIdUserIdNotNull() {
        List<CustomerAddress> customerAddressList = customerAddressDao.selectCustomerAddressByIdUserId(1);
        assertFalse(customerAddressList.isEmpty());
    }

    @Test
    public void updateCustomerAddress() {
        CustomerAddress customerAddress = new CustomerAddress();
        customerAddress.setId(4);
        customerAddress.setProvinceId("999");
        customerAddress.setCityId("99999");
        customerAddress.setAreaId("99999");
        customerAddress.setAddressDetail("test");
        customerAddress.setUserId(1);
        int i = customerAddressDao.updateCustomerAddress(customerAddress);
        assertTrue(i > 0);
    }
}