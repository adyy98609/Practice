package immutable;

public record PersonRecord(String name, int age, AddressRecord address) {

    public PersonRecord{
        if(name == null || address == null){
            throw new IllegalArgumentException("Name and Address cannot be null");
        }
    }

    public static void main(String[] args) {
        AddressRecord address = new AddressRecord("123 main st");
        PersonRecord person = new PersonRecord("John",30,address);

        System.out.println(person);

        address = new AddressRecord("789 diff st");
        System.out.println(person);

        AddressRecord extracted = person.address();
        extracted = new AddressRecord("Bangalore");
        System.out.println(person);
    }

}
