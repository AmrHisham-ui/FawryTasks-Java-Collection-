package Model;

import repository.PhotoRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Gallery implements PhotoRepository {
    private List<Photo> photos = new ArrayList<>();

    public void addPhoto(Photo photo) {
        photos.add(photo);
    }

    @Override
    public List<Photo> getPhotos() {
        return photos;
    }
}