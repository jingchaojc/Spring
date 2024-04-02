package com.example.demo;


import java.util.UUID;

public class UUIDGenerator {

    public static void main(String[] args) {

            //随机生成一个UUID字符串
            String uuid = UUID.randomUUID().toString();
            System.out.println("生成的UUID为：" + uuid);

    }

}
