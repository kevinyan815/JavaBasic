package com.learncollection.learnstream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GetTwoObjectListIntersectionAndDiff {
    static class A {
        String id;
        String nickName;

        public A(String id, String nickName) {
            this.id = id;
            this.nickName = nickName;
        }

        @Override
        public String toString() {
            return "A{" +
                    "id='" + id + '\'' +
                    ", nickName='" + nickName + '\'' +
                    '}';
        }

        public String getId() {
            return id;
        }

        public String getNickName() {
            return nickName;
        }
    }

    public static void main(String[] args) {
        List<A> aList = new ArrayList<>(Arrays.asList(
                new A("1", "张三"),
                new A("2", "李四"),
                new A("3", "王五")
        ));

        List<A> bList = new ArrayList<>(Arrays.asList(
                new A("2", "李四"),
                new A("3", "王五"),
                new A("4", "赵六")
        ));

        // 求bList 与 aList的差集（在bList中不在aList中)
        List<A> differences = bList.stream().filter(b -> aList.stream().map(A::getId).noneMatch(id -> Objects.equals(b.getId(), id))).collect(Collectors.toList());
        System.out.println("----------bList 与 aList 的差集为：");
        System.out.println(differences);

        // aList 与 bList 的交集 (在两个集合中都存在的元素)
        List<A> intersections = aList
                .stream() //获取第一个集合的Stream1
                .filter(  //取出Stream1中符合条件的元素组成新的Stream2，lambda表达式1返回值为true时为符合条件
                    a ->  //lambda表达式1，a为lambda表达式1的参数，是Stream1中的每个元素
                    bList.stream() //获取第二个集合的Stream3
                                    .map(A::getId) //将第二个集合每个元素的id属性取出来，映射成新的一个Stream4
                                    .anyMatch( //返回值（boolean）：Stream4中是否至少有一个元素使lambda表达式2返回值为true
                                            id -> //lambda表达式2，id为lambda表达式2的参数，是Stream4中的每个元素
                                                Objects.equals(a.getId(), id) //判断id的值是否相等
                                    )
                )
                .collect(Collectors.toList()); //将Stream2转换为List
        System.out.println("----------bList 与 aList 的交集为：");
        System.out.println(intersections);
    }
}


