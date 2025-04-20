package Service;

import Model.Gallery;
import Model.Photo;
import repository.PhotoRepository;

import java.util.List;
import java.util.stream.Collectors;
import Exception.NoPhotosFoundException;
import Exception.NoPhotosFoundByLocationException;
import Exception.PhotoNotFoundException;
import Exception.NoPhotosFoundByLatLngException;
public class PhotoService {

    private final PhotoRepository photoRepo;

    public PhotoService(PhotoRepository photoRepo) {
        this.photoRepo = photoRepo;
    }

    public Photo getPhotoById(String id) {
        return photoRepo.getPhotos()
                .stream()
                .filter(photo -> photo.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new PhotoNotFoundException("Photo with  This ID " + id + " not found"));
    }

    public List<Photo> getPhotosByTag(String tag) {
        List<Photo> photos = photoRepo.getPhotos()
                .stream()
                .filter(photo -> photo.getTags().contains(tag))
                .collect(Collectors.toList());

        if (photos.isEmpty()) {
            throw new NoPhotosFoundException("No Photos Found with This Tag: " + tag);
        }

        return photos;
    }

    public List<Photo> getPhotosByLocation(String location) {
        List<Photo> photos = photoRepo.getPhotos()
                .stream()
                .filter(photo -> photo.getLocation().equalsIgnoreCase(location))
                .collect(Collectors.toList());

        if (photos.isEmpty()) {
            throw new NoPhotosFoundByLocationException("No photos found at This location: " + location);
        }

        return photos;
    }

    public List<Photo> getPhotosByLatandLng(double latitude, double longitude) {
        List<Photo> photos = photoRepo.getPhotos()
                .stream()
                .filter(photo -> photo.getLatitude() == latitude && photo.getLongitude() == longitude)
                .collect(Collectors.toList());

        if (photos.isEmpty()) {
            throw new NoPhotosFoundByLatLngException("No photos found at these Co-ordinates  given latitude and longitude: (" + latitude + ", " + longitude + ")");
        }

        return photos;
    }
    /* howa 2al el index inverting service  mehtagyeen n3ml layer service tanya
    ghyr deh n7ot feha el index inverter service
     btkhleny a3ks el search bdl e photo ma leha tag
     we title we id a3ks el search mn el na7ya el tanya */
    /*bardo fe haga tanya el mfrod tt3ml eli hya zy el GPS any agblo el surrounded photo area -> bydeny
    for an example 5 kelo na7yt el sora deh we agblo el sawar eli 7waleha */
    /* we bardo el unit testing @Test el howa Junit */

}