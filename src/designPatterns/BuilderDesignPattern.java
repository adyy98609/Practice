package designPatterns;

public class BuilderDesignPattern {

    private final String name;// required
    private final int age;
    private final String street;

    private BuilderDesignPattern(Builder builder){
        this.name = builder.name;
        this.age = builder.age;
        this.street = builder.street;
    }

    public static class Builder{
        private final String name;
        private int age = 0;
        private String street = "";

        public Builder(String name){
            this.name = name;
        }
        public Builder age(int age){
            this.age = age;
            return this;
        }
        public Builder street(String street){
            this.street = street;
            return this;
        }

        public BuilderDesignPattern build(){
            return new BuilderDesignPattern(this);
        }
    }

    public static void main(String[] args) {
        BuilderDesignPattern person = new BuilderDesignPattern.Builder("John")
                .age(30)
                .street("123 Main St")
                .build();
        System.out.println(person);
    }

    @Override
    public String toString() {
        return "BuilderDesignPattern{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", street='" + street + '\'' +
                '}';
    }
}
