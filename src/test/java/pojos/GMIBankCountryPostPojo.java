package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GMIBankCountryPostPojo {

    private String name;

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public GMIBankCountryPostPojo() {
    }

    public GMIBankCountryPostPojo(String name) {

        this.name = name;
    }

    @Override
    public String toString() {
        return "GMIBankCountryPostPojo{" +
                "name='" + name + '\'' +
                '}';
    }
}
