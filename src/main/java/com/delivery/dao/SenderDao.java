package com.delivery.dao;

import com.delivery.entity.Sender;
import com.delivery.mapper.SenderDaoMapper;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Yvan
 * @Description Sender(快递员) 表的Dao层
 * @Classname SenderDao
 * @Date 2020/10/18 15:53
 */
@Repository
public interface SenderDao {

    /**
     * 插入 sender
     *
     * @param sender sender
     * @return 条数
     */
    @InsertProvider(type = SenderDaoMapper.class, method = "insertSenderSql")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insertSender(Sender sender);

    /**
     * 更新 sender
     *
     * @param sender sender
     * @return true
     */
    @UpdateProvider(type = SenderDaoMapper.class, method = "updateSenderSql")
    int updateSender(Sender sender);

    /**
     * 查询 sender
     *
     * @return sender list
     */
    @Select("select id, sender_num, sender_name, sender_phone, sender_cancell, sender_unit, sender_standard from sender")
    List<Sender> selectSender();
}
