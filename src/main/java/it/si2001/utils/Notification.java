package it.si2001.utils;

public class Notification
{
    private String type,description;

    public Notification(String type, String description)
    {
        this.type = type;
        this.description = description;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
