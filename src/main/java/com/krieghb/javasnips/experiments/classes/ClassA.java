package com.krieghb.javasnips.experiments.classes;

/**
 * Created by krido02 on 1/3/2017.
 *
 */
public class ClassA {

    private String name;
    private int age;
    private MyClass personality;

    public ClassA(String name, int age, MyClass personality) {
        this.name = name;
        this.age = age;
        this.personality = personality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Object getPersonality() {
        return personality;
    }

    public void setPersonality(MyClass personality) {
        this.personality = personality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassA classA = (ClassA) o;

        if (age != classA.age) return false;
        if (!name.equals(classA.name)) return false;
        return personality.equals(classA.personality);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        result = 31 * result + personality.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ClassA{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", personality=" + personality +
                '}';
    }
}
