package com.product.controller;

import com.product.entity.Seckill;
import com.product.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zhangybt on 2017/4/25.
 */
@Controller
@RequestMapping("/springmvc")
public class SeckillController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @RequestMapping(name = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        List<Seckill> list = seckillService.selectByExample();
        model.addAttribute("list",list);
        logger.info("list={}",list);
        return "list";
    }

    @RequestMapping(name = "/{seckillId}/detail", method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String findOne(@PathVariable("seckillId") Long seckillId, Model model) {
        if (seckillId == null) {
            //重定向
            return "redirect:/seckill/list";
        }
        Seckill seckill = seckillService.selectByPrimaryKey(seckillId);
        if (seckill == null) {
            return "forward:/seckill/list";
        }
        model.addAttribute("seckill", seckill);
        logger.info("seckill={}",seckill);
        return "detail";
    }
}
