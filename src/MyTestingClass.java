public class MyTestingClass implements Comparable<MyTestingClass> {
    private int id;
    private String name;
    public MyTestingClass(int id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public int compareTo(MyTestingClass other) {
        return Integer.compare(this.id, other.id);
    }
    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + id;
        for (int i = 0; i < name.length(); i++) {
            hash = 31 * hash + name.charAt(i);
        }
        return hash;
    }
    @Override
    public String toString() {
        return "(" + id + ", " + name + ")";
    }
}