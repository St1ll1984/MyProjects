package Module10;

public class ObjectToJson {
    private String name;
    private String age;

    @Override
    public String toString() {
        return "ObjectToJson{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public ObjectToJson(String name, String age) {
        this.name = name;
        this.age = age;
    }
}
