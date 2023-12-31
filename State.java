import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class State implements Comparable<State>{
    int totalTime;

    boolean torchRight;
    ArrayList<Person> leftside ;
    ArrayList<Person> rightside ;
    int f, g , h;
    State father;

    public State(){
        this.f =0;
        this.g =0;
        this.h =0;
        this.father = null;
        this.totalTime =0;
        leftside = new ArrayList<>();
        rightside = new ArrayList<>();
        this.torchRight = true; 

    }
    public State(State s){
        this.f = s.getF();
        this.g = s.getG();
        this.h = s.getH();
        this.father = s.getFather();
        this.totalTime = s.getTotalTime();
        this.rightside = new ArrayList<>(s.rightside);// na to testaroume
        this.leftside = new ArrayList<>(s.leftside);//na to testaroume
        this.torchRight = s.torchRight;
    }
    public int getF() 
	{
		return this.f;
	}
	
	public int getG() 
	{
		return this.g;
	}
	
	public int getH() 
	{
		return this.h;
	}
	
	public State getFather()
	{
		return this.father;
	}
    public void setF(int f)
	{
		this.f = f;
	}
	
	public void setG(int g)
	{
		this.g = g;
	}
	
	public void setH(int h)
	{
		this.h = h;
	}
	
	public void setFather(State f)
	{
		this.father = f;
	}
	
	public int getTotalTime() 
	{
		return this.totalTime;
	}
	
	public void setTotalTime(int time)
	{
		this.totalTime = time;
	}

    public void evaluate(){
        setG(getTotalTime());
        Person fastest = new Person();
        
        fastest = Collections.min(rightside);
        setH(fastest.getTime());

        setF(getG()+getH());
    }

    public void moveFromRight(Person p1 , Person p2){
       leftside.add(p1);
       leftside.add(p2);
       rightside.remove(p1);
       rightside.remove(p2);
       setTotalTime(p1.compareTo(p2)>0?p1.getTime()+getTotalTime():p2.getTime()+getTotalTime());
        //p1.getTime()+p2.getTime()+this.getTotalTime()
       torchRight = false;
    }

    public void moveFromLeft(Person p){
        rightside.add(p);
        leftside.remove(p);
        torchRight = true;
        setTotalTime(this.getTotalTime()+p.getTime());

        torchRight = true;
    }

    public ArrayList<State> getChildren(){
        ArrayList<State> children = new ArrayList<>();
        
        if(torchRight){
            for(int i =0;i<rightside.size();i++){
                for(int j = i+1; j<rightside.size();j++){
                   
                        State child = new State(this);
                        
                        child.moveFromRight(rightside.get(i), rightside.get(j));
                        child.evaluate();
                        child.setFather(this);
                        children.add(child);
                    

                }
            }
        }else{
            for(Person i : leftside){
                State child = new State(this);
                child.moveFromLeft(i);
                child.evaluate();
                child.setFather(this);
                children.add(child);
            }
        }

        return children;

    }
    public int compareTo(State s){
        return Double.compare(this.getF(), s.getF());
    }
   @Override
    public String toString(){
        String s="Rightside:\n";
        for(int i =0; i<this.rightside.size();i++){
            Person current = rightside.get(i);
            s+=current.getName()+"\t"+current.getTime()+"\n";
          }
          s+="Leftside:\n";
          for(int i =0; i<this.leftside.size();i++){
            Person current = leftside.get(i);
            s+=current.getName()+ "\t"+current.getTime()+"\n";
          }
          s+="Total time :"+getTotalTime()+"\n";
          s+="F(n) :"+getF()+"\t";
          s+="G(n) :"+getG()+"\t";
          s+="H(n) :"+getH()+"\t";

        return s;  
    }
   


}
