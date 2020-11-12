package app.discoveritech.hoom.Model;

public class Services implements IServices {
    private String id;
    private String company_id;
    private String service_detail;
    private String price;
    private String status;

    public Services(String id, String company_id, String service_detail, String price, String status) {
        this.id = id;
        this.company_id = company_id;
        this.service_detail = service_detail;
        this.price = price;
        this.status = status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public void setService_detail(String service_detail) {
        this.service_detail = service_detail;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getCompany_id() {
        return company_id;
    }

    @Override
    public String getService_detail() {
        return service_detail;
    }

    @Override
    public String getPrice() {
        return price;
    }

    @Override
    public String getStatus() {
        return status;
    }
}
