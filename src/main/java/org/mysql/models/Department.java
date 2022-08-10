package org.mysql.models;

public class Department {
    private int id;
    private String name;

    public Department() {
    }
    public Department(int id, String name) {
        this.id=id;
        this.name=name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "Department{" +
                "Id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
