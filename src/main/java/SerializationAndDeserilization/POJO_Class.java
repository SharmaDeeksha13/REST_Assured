package SerializationAndDeserilization;

public class POJO_Class {



    // Step 1 : create private Data Members
    private String instructor;
    private String url;
    private String services;
    private String expertise;
    private Sub_POJO_Class courses;

    public Sub_POJO_Class getCourses() {
        return courses;
    }

    public void setCourses(Sub_POJO_Class courses) {
        this.courses = courses;
    }

    private String linkedIn;



    // Step 2 : Create getter and setter method  - alt+functionkey+insert

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }



    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }


}
