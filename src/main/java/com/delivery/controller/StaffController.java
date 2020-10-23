package com.delivery.controller;

import com.alibaba.fastjson.JSONObject;
import com.delivery.entity.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/sys")
public class StaffController {

    @RequestMapping("/staffView")
    public String staff() {
        return "base/staff";
    }


    @RequestMapping("/staffShow")
    public void staffShow(HttpServletResponse response) throws IOException {
        List<Staff> staff = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Staff e = new Staff();
            e.setName("wmm" + i);
            e.setHaspda(i % 2 == 1 ? "0" : "1");
            e.setDeltag(i % 2 == 0 ? "0" : "1");
            e.setStandard("Standard" + i);
            e.setTelephone("132" + i + "3333" + i + "22");
            staff.add(e);
        }
        response.getWriter().write(JSONObject.toJSONString(staff));

    }

    @RequestMapping("/findStaffView")
    public String findStaffView() {

        return "base/staff";
    }
    @RequestMapping("/staffAdd")
    public String staffAdd(Staff staff, Model model) throws IOException {

        System.out.println("staff.toString() = " + staff.toString());
        String msg = "添加成功";
        model.addAttribute("msg", msg);
        return "base/staff";
    }

    @RequestMapping("/staffDelete")
    public String staffDelete(String ids, Model model) {
        System.out.println("ids = " + ids);//选中的id用‘,'分割

        String msg = "删除成功";
        model.addAttribute("msg", msg);
        return "base/staff";

    }
    @RequestMapping("/staffEdit")
    public String staffEdit(Staff staff, Model model) {
        System.out.println("ids = " + staff);//选中的id用‘,'分割

        String msg = "修改成功";
        model.addAttribute("msg", msg);
        return "base/staff";

    }
}
