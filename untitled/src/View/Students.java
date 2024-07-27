package View;

public class Students {
    private int id;
    private String name;
    private int age;
    private double score;
    private static int idNext=1;
    public Students( String name, int age,double score) {
        this.id = idNext;
        this.name = name;
        this.age = age;
        this.score = score;
        idNext++;
    }

    public Students(int id, String name, int age, double score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public static int getIdNext() {
        return idNext;
    }

    public static void setIdNext(int idNext) {
        Students.idNext = idNext;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "STT: "+id + " || Ten hoc sinh: " + name + " || Tuoi: " + age + " || Điểm: " + score;
    }
}
