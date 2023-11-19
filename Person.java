public class Person implements Comparable<Person>{
    String name;
    
    private int time;
    
    public Person(String name,int time){
        this.name = name;
        this.time = time;
        
    }

    public Person (){

    }

    public void setName(String name){
        this.name = name;
    }

    public void setTime(int time){
        this.time = time;
    }
   
    public String getName(){
        return this.name;
    }

    public int getTime(){
        return this.time;
    }


    @Override
    public int compareTo(Person o) {
        return Integer.compare(this.getTime(), o.getTime());
    }

}