package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GMIBankCountryPojo {
    private int id;
    private String name;
    private String states;

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

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states;
    }

    public GMIBankCountryPojo() {
    }

    public GMIBankCountryPojo(int id, String name, String states) {
        this.id = id;
        this.name = name;
        this.states = states;
    }

    @Override
    public String toString() {
        return "GMIBankCountryPojo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", states='" + states + '\'' +
                '}';
    }
}

