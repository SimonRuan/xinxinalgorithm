package mapper.ruanxinxin.mvc01.designpattern;

import java.util.Objects;

public class MyClass {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyClass myClass = (MyClass) o;
        return age == myClass.age &&
                Objects.equals(name, myClass.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }
}
