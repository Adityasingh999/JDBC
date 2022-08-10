package org.mysql.models;


public class Address {
    private int Id;
    private String name;
    private String address;


    public Address(int id, String name,String address) {
        this.Id = id;
        this.name = name;
        this.address=address;
    }

    public Address() {

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }



    @Override
    public String toString() {
        return "address{" +
                "Id=" + Id +
                ", name='" + name + '\'' +",Address="+address+
                '}';
    }
}

