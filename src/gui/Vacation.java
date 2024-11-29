package gui;

public class Vacation {
    String name, phone, destination;
    int days;
    boolean discount;

    public Vacation(String name, String phone, String destination, int days, boolean discount) {
        this.name = name;
        this.phone = phone;
        this.destination = destination;
        this.days = days;
        this.discount = discount;
    }

    String[] returnAsTableRow(){
        return new String[]{name,
                phone,
                destination,
                String.valueOf(days),
                discount ? "Yes" : "No"
        };
    }
}
