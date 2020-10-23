package com.delivery.mapper;

import com.delivery.entity.Sender;
import com.delivery.util.TypeUtil;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author Yvan
 * @Description SenderDao 动态sql语句
 * @Classname SenderDaoMapper
 * @Date 2020/10/18 16:39
 */
public class SenderDaoMapper {

    /**
     * insert 动态 sql
     *
     * @param sender sender
     * @return sql
     */
    public String insertSenderSql(Sender sender) {
        return new SQL() {
            {
                INSERT_INTO("sender");
                if (TypeUtil.isValidString(sender.getSenderNum())) {
                    VALUES("sender_num", "#{senderNum}");
                }
                if (TypeUtil.isValidString(sender.getSenderName())) {
                    VALUES("sender_name", "#{senderName}");
                }
                if (TypeUtil.isValidString(sender.getSenderPhone())) {
                    VALUES("sender_phone", "#{senderPhone}");
                }
                if (sender.getSenderCancell() != null) {
                    VALUES("sender_cancell", "#{senderCancell}");
                }
                if (TypeUtil.isValidString(sender.getSenderUnit())) {
                    VALUES("sender_unit", "#{senderUnit}");
                }
                if (TypeUtil.isValidString(sender.getSenderStandard())) {
                    VALUES("sender_standard", "#{sender_standard}");
                }
            }
        }.toString();
    }

    /**
     * update 动态 sql
     *
     * @param sender sender
     * @return sql
     */
    public String updateSenderSql(Sender sender) {
        return new SQL() {
            {
                UPDATE("sender");
                if (TypeUtil.isValidString(sender.getSenderNum())) {
                    SET("sender_num = #{senderNum}");
                }
                if (TypeUtil.isValidString(sender.getSenderName())) {
                    SET("sender_name = #{senderName}");
                }
                if (TypeUtil.isValidString(sender.getSenderPhone())) {
                    SET("sender_phone = #{senderPhone}");
                }
                if (sender.getSenderCancell() != null) {
                    SET("sender_cancell = #{senderCancell}");
                }
                if (TypeUtil.isValidString(sender.getSenderUnit())) {
                    SET("sender_unit = #{senderUnit}");
                }
                if (TypeUtil.isValidString(sender.getSenderStandard())) {
                    SET("sender_standard = #{senderStandard}");
                }
                WHERE("id = #{id}");
            }
        }.toString();
    }
}
