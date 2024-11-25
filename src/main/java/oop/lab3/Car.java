package oop.lab3;

public class Car {
    private String id;
    private String type;
    private String passangers;
    private boolean isDining;
    private int consumption;

    public Car(String id, String type, String passangers, boolean isDining, int consumption) {
        this.id = id;
        this.type = type;
        this.passangers = passangers;
        this.consumption = consumption;
        this.isDining = isDining;
    }

    public boolean isDining() {
        return isDining;
    }

    public void setDining(boolean dining) {
        isDining = dining;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getConsumption() {
        return consumption;
    }

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }

    public String getPassangers() {
        return passangers;
    }

    public void setPassangers(String passangers) {
        this.passangers = passangers;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
