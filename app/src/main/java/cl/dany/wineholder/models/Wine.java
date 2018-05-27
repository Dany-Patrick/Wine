package cl.dany.wineholder.models;

import com.orm.SugarRecord;

public class Wine extends SugarRecord {

    private String name, age, vine;

    public Wine() {
    }

    public Wine(String name, String age, String vine) {
        this.name = name;
        this.age = age;
        this.vine = vine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getVine() {
        return vine;
    }

    public void setVine(String vine) {
        this.vine = vine;
    }
}
