package org.xulinux.dubbopro;

import org.xulinux.dubbopro.demo.DemoService;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/8/9 下午6:26
 */
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        System.out.println("hello" + name);
        return "hello dubbopro";
    }
}
