public class Data {
   
    private String name;
    private Integer count;

    public Data(String name, Integer count) {
        this.name = name;
        this.count = count;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCount(Integer count){
        this.count = count;
    }

    public String getName(){
        return this.name;
    }

    public Integer getCount(){
        return this.count;
    }

    @Override
    public String toString() {
        return this.getName()+ " : "+ this.getCount();
    }
}

