public class MyTestingClass {
    private String name;
    private int ID;

    public MyTestingClass(String name, int ID){
        this.name = name;
        this.ID = ID;
    }

    public int getID(){
        return ID;
    }

    public String getName(){
        return name;
    }

    @Override
    public int hashCode(){
        int hashResult = 17;
        hashResult = 31 * hashResult + ID;
        hashResult = 31 * hashResult + name.hashCode();
        return hashResult;
    }
}
