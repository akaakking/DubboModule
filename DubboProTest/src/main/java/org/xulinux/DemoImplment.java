package org.xulinux;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/7/31 下午8:09
 */
public class DemoImplment implements DemoInterface{
    @Override
    public String sayHello() {
        System.out.println("hello");
        return "hello";
    }
}
