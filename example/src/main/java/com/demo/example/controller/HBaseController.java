package com.demo.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
import org.springframework.data.hadoop.hbase.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HBaseController {

    @Autowired
    private HbaseTemplate hbaseTemplate;

    @GetMapping(value = "/hbase/row")
    public void hbaseTest() {
        Object student = hbaseTemplate.get("student", "0001", null);
        System.out.println(student);
    }
}
