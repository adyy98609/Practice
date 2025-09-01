package immutable;

public record AddressRecord(String address) {

    public AddressRecord{
        if(address == null){
            throw new IllegalArgumentException("Address cannot be null");
        }
    }
}
