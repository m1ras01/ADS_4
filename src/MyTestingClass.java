public class MyTestingClass {
    private int value;

    public MyTestingClass(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }



    @Override
    public int hashCode(){
        int hashResult = 17;
        hashResult = 31 * hashResult + value;
        return hashResult;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MyTestingClass)) {
            return false;
        }
        MyTestingClass other = (MyTestingClass) obj;
        return this.value == other.value;
    }


}

