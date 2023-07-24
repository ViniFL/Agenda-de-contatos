package com.vinicius.schedule.entities;

public class Contact {

    private Long id;
    private String name;
    private String cellphone;
    private String address;

    public Contact() {
    }

    public Contact(Long id, String name, String cellphone, String address) {
        this.id = id;
        this.name = name;
        this.cellphone = cellphone;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        return id.equals(contact.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
