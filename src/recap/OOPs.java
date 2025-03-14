package recap;

public class OOPs {
    String[] properties;

    public String[] getProperties() {
        return properties;
    }

    public void setProperties(String[] properties) {
        this.properties = properties;
    }

    public int getAge() {
        return age;
    }

    public void increaseAge() {
        age++;
    }

    protected int age;

    public OOPs(String[] properties, int age) {
        this.properties = properties;
        this.age = age;
    }

    public static void main(String[] args) {
        OOPs o = new OOPClass(new String[]{}, 2);

        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 20000; j++) {
                if (i+j == 300){
                    int i1 = 2 ^ 2;
                }
            }
        }

    }
} class OOPClass extends OOPs implements function{
    int attendance;

    public OOPClass(String[] properties, int age) {
        super(properties, age);
    }

    @Override
    public void increaseAge() {
        age += 2;
    }

    @Override
    public double evaluate(double x) {
        return x+5;
    }
}

 interface function{
    double evaluate(double x);
 }

