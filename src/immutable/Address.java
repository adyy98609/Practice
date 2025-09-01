package immutable;

import java.util.Objects;

public class Address{
    String street;

    public Address(String street){
        this.street = street;
    }

    public Address(Address address){
        this.street = address.street;
    }

    public String street(){
        return street;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Address address)) return false;
        return Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(street);
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                '}';
    }
}
