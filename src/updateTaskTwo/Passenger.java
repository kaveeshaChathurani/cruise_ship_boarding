package updateTaskTwo;

public class Passenger {
    String firstName;
    String surName;
    int Expenses;

    public Passenger() {
    }

    public Passenger(String firstName, String surName, int expenses) {
        this.firstName = firstName;
        this.surName = surName;
        Expenses = expenses;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getExpenses() {
        return Expenses;
    }

    public void setExpenses(int expenses) {
        Expenses = expenses;
    }
}
