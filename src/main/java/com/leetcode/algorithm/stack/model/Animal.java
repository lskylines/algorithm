package com.leetcode.algorithm.stack.model;

public class Animal implements Comparable<Animal>{
    private String name;

    private Integer age;

    public Animal(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Animal o) {
        return Integer.compare(this.age, o.age);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
