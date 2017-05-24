package com.product.controller;

import com.product.controller.resultData.BaseControllerRS;
import com.product.entity.User;
import com.product.service.IUserCenterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zhangybt on 2017/5/22.
 */
@Controller
@RequestMapping("/user")
public class UserCenterController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IUserCenterService userCenterService;


//    @RequestMapping(name = "/list", method = RequestMethod.GET)
//    public String list(Model model) {
//        String phone = "13920170000";
//        List<Person> list = userCenterService.selectRelation(phone);
//        model.addAttribute("list",list);
//        logger.info("list={}",list);
//        return "list";
//    }

    @RequestMapping(value = "userList", method = RequestMethod.POST)
    public @ResponseBody
    BaseControllerRS userList() {
        List<User> list = userCenterService.selectUsers();
        BaseControllerRS rs = new BaseControllerRS(true, BaseControllerRS.code_success, "查询成功", list);
        return rs;
    }
}
