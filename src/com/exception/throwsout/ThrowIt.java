package com.exception.throwsout;

public class ThrowIt {
    // >> TODO 在方法声明里可以使用throws关键字，声明方法会抛出的异常。
    // >> TODO 抛出的异常类型，可以是实际异常的父类或者本身。
    // >> TODO 可以抛出多种类型的异常，用逗号分开就可以。
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class clazz = Class.forName("abc");
        clazz.getField("");
    }
}
