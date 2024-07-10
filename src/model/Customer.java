package model;

import java.util.Objects;
import java.util.Scanner;

public class Customer extends Person {

    private String country;

    public Customer(String country, String name, String age, String sex) {
        super(name, age, sex);
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Customer{" + "Country = " + country + super.toString()+'}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        return Objects.equals(this.country, other.country);
    }

    @Override
    public void language() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap quoc tich cua nguoi do (USA/VN/JP): ");
        String datNuoc = sc.nextLine();
        switch (datNuoc) {
            case "USA":
                System.out.println("Language: English");
                break;
            case "VN":
                System.out.println("Language: Vietnamese");
                break;
            case "JP":
                System.out.println("Language: Japanese");
                break;
            default:
                System.out.println("Invalid");
                break;
                
        }
    }
}
