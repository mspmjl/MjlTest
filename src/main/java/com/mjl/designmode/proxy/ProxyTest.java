package com.mjl.designmode.proxy;

import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {
        //1.创建真实对象
        Lenovo lenovo = new Lenovo();

        //2.动态代理增强lenovo对象
        /*
             三个参数：
                1 . 类加载器：真实对象.getClass().getClassLoader()
                2 . 接口数组：真实对象.getClass().getInterfaces()
                3 . 处理器：new InvocationHandler()
          */
        /*  代理逻辑编写的方法：代理对象调用的所有方法都会触发该方法执行
        参数：
           1 . proxy:代理对象
           2 . method：代理对象调用的方法，被封装为的对象
           3 . args:代理对象调用的方法时，传递的实际参数
       */
        SaleComputer proxy_lenovo = (SaleComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), (proxy, method, args1) -> {
            //判断是否是sale方法
            if (method.getName().equals("sale")) {
                //.增强参数
                double money = (double) args1[0];
                money = money * 0.85;
                System.out.println("专车接你....");
                //使用真实对象调用该方法
                String obj = (String) method.invoke(lenovo, money);
                System.out.println("免费送货...");
                //.增强返回值
                return obj + "_鼠标垫";
            } else {
                Object obj = method.invoke(lenovo, args1);
                return obj;
            }


        });

        //3.调用方法

        String computer = proxy_lenovo.sale(800);
        System.out.println(computer);

        proxy_lenovo.show();
    }
}