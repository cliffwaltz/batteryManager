package cn.ys.entity;

import java.io.Serializable;

public class Car implements Serializable {

    private String carId;
    private String userId;
    private String userName;
    private Integer weight;
    private String batteryType;

    public Car() {
    }

    public Car(String carId, String userId, String userName, Integer weight, String batteryType) {
        this.carId = carId;
        this.userId = userId;
        this.userName = userName;
        this.weight = weight;
        this.batteryType = batteryType;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId='" + carId + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", weight=" + weight +
                ", batteryType='" + batteryType + '\'' +
                '}';
    }
}
