package app.discoveritech.hoom.Model;

public class Companies implements ICompanies {
    private String id;
    private String name;
    private String service_id;
    private String estimated_price;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setService_id(String service_id) {
        this.service_id = service_id;
    }

    public void setEstimated_price(String estimated_price) {
        this.estimated_price = estimated_price;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getService_id() {
        return service_id;
    }

    @Override
    public String getEstimated_price() {
        return estimated_price;
    }
}
