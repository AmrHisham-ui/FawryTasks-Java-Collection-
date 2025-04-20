package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Photo {
    private String id;
    private String title;
    private String location;
    private double latitude;
    private double longitude;
    private List<String> tags;

    public Photo(String title, String location, double latitude, double longitude, List<String> tags) {
        this.id = UUID.randomUUID().toString(); // 128- bit to string  UUID unique 7aga ID b3ml generate by 128 bit to string
        this.title = title;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.tags = tags;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }
    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }
    public List<String> getTags() { return tags; }
    public void setTags(List<String> tags) { this.tags = tags; }

    @Override
    public String toString() {
        return "Photo{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", tags=" + tags +
                '}';
    }
}