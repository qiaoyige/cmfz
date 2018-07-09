package com.qyg.cmfz.controller;

import com.qyg.cmfz.entity.EchartsChain;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author gege
 * @Time 2018/7/9  14:38
 */
@Controller
@RequestMapping("/user")
public class EchartsController {
    /*[
    {name: '北京',value: '100' },{name: '天津',value: randomData() },
    {name: '上海',value: randomData() },{name: '重庆',value: randomData() },
    {name: '河北',value: randomData() },{name: '河南',value: randomData() },
    {name: '云南',value: randomData() },{name: '辽宁',value: randomData() },
    {name: '黑龙江',value: randomData() },{name: '湖南',value: randomData() },
    {name: '安徽',value: randomData() },{name: '山东',value: randomData() },
    {name: '新疆',value: randomData() },{name: '江苏',value: randomData() },
    {name: '浙江',value: randomData() },{name: '江西',value: randomData() },
    {name: '湖北',value: randomData() },{name: '广西',value: randomData() },
    {name: '甘肃',value: randomData() },{name: '山西',value: randomData() },
    {name: '内蒙古',value: randomData() },{name: '陕西',value: randomData() },
    {name: '吉林',value: randomData() },{name: '福建',value: randomData() },
    {name: '贵州',value: randomData() },{name: '广东',value: randomData() },
    {name: '青海',value: randomData() },{name: '西藏',value: randomData() },
    {name: '四川',value: randomData() },{name: '宁夏',value: randomData() },
    {name: '海南',value: randomData() },{name: '台湾',value: randomData() },
    {name: '香港',value: randomData() },{name: '澳门',value: randomData() }
    ]*/
    @RequestMapping("/showAllEchartsF")
    public @ResponseBody List<EchartsChain> showAllEchartsF(){
        List<EchartsChain> echarts=new ArrayList<EchartsChain>();
        echarts.add(new EchartsChain("北京","100","男"));
        echarts.add(new EchartsChain("天津","120","男"));
        echarts.add(new EchartsChain("上海","110","男"));
        echarts.add(new EchartsChain("重庆","50","男"));
        echarts.add(new EchartsChain("云南","70","男"));
        echarts.add(new EchartsChain("河南","90","男"));
        echarts.add(new EchartsChain("辽宁","120","男"));
        echarts.add(new EchartsChain("河北","170","男"));
        echarts.add(new EchartsChain("湖南","170","男"));
        echarts.add(new EchartsChain("黑龙江","10","男"));
        echarts.add(new EchartsChain("安徽","130","男"));
        echarts.add(new EchartsChain("山东","144","男"));
        echarts.add(new EchartsChain("新疆","10","男"));
        echarts.add(new EchartsChain("江苏","106","男"));
        echarts.add(new EchartsChain("浙江","107","男"));
        echarts.add(new EchartsChain("江西","109","男"));
        echarts.add(new EchartsChain("内蒙古","140","男"));
        echarts.add(new EchartsChain("陕西","100","男"));
        echarts.add(new EchartsChain("吉林","100","男"));
        echarts.add(new EchartsChain("福建","100","男"));

        return echarts;

    }
    @RequestMapping("/showAllEchartsM")
    public @ResponseBody List<EchartsChain> showAllEchartsM(){
        List<EchartsChain> echarts=new ArrayList<EchartsChain>();
        echarts.add(new EchartsChain("北京","170","女"));
        echarts.add(new EchartsChain("天津","109","女"));
        echarts.add(new EchartsChain("上海","134","女"));
        echarts.add(new EchartsChain("重庆","45","女"));
        echarts.add(new EchartsChain("云南","54","女"));
        echarts.add(new EchartsChain("河南","32","女"));
        echarts.add(new EchartsChain("辽宁","150","女"));
        echarts.add(new EchartsChain("河北","170","女"));
        echarts.add(new EchartsChain("湖南","175","女"));
        echarts.add(new EchartsChain("黑龙江","30","女"));
        echarts.add(new EchartsChain("安徽","145","女"));
        echarts.add(new EchartsChain("山东","153","女"));
        echarts.add(new EchartsChain("新疆","10","女"));
        echarts.add(new EchartsChain("江苏","106","女"));
        echarts.add(new EchartsChain("浙江","107","女"));
        echarts.add(new EchartsChain("江西","109","女"));
        echarts.add(new EchartsChain("内蒙古","140","女"));
        echarts.add(new EchartsChain("陕西","130","女"));
        echarts.add(new EchartsChain("吉林","150","女"));
        echarts.add(new EchartsChain("福建","110","女"));
        return echarts;

    }
}
