package com.sam.springcloud.controller;

import com.sam.springcloud.entities.CommonResult;
import com.sam.springcloud.entities.Payment;
import com.sam.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
//@Slf4j
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult create(Payment payment) {
        int result = paymentService.create(payment);
        //log.info("#####插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入成功");
        } else {
            return new CommonResult(422, "插入数据库失败");
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        //log.info("#####查询结果：" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功");
        } else {
            return new CommonResult(422, "查询数据库失败，查询id：" + id);
        }
    }
}
