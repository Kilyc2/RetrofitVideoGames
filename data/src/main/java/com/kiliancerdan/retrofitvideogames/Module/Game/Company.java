package com.kiliancerdan.retrofitvideogames.Module.Game;

class Company {

    private Integer id;
    private Boolean developer;
    private Boolean publisher;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getDeveloper() {
        return developer;
    }

    public void setDeveloper(Boolean developer) {
        this.developer = developer;
    }

    public Boolean getPublisher() {
        return publisher;
    }

    public void setPublisher(Boolean publisher) {
        this.publisher = publisher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
