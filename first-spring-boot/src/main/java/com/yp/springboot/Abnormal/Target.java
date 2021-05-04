package com.yp.springboot.Abnormal;

import org.springframework.stereotype.Component;

@Component
public class Target {

    public String save(String name) {
        System.out.println(name + ",在保存数据 ");
        //int i=10/0;
        return "你好" + name + "，欢迎学习aop";
    }
//	public void save(String name) 
//	{
//		System.out.println(name+",在保存数据 ");
//	}

}
