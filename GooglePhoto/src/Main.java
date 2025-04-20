import Model.Gallery;
import Model.Photo;
import Service.PhotoService;

import java.util.Arrays;
import java.util.List;
import Exception.NoPhotosFoundException;
import Exception.NoPhotosFoundByLocationException;
import Exception.PhotoNotFoundException;
import Exception.NoPhotosFoundByLatLngException;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Init gallery (repo 3shan bt implement (DeCoupling))
        Gallery gallery = new Gallery();

        // Samples
        Photo photo1 = new Photo("Sunset", "Beach", 34.0522, -118.2437, Arrays.asList("vacation", "sunset", "beach"));
        Photo photo2 = new Photo("Nature", "Alps", 46.8523, 10.3032, Arrays.asList("vacation", "mountain", "snow"));
        Photo photo3 = new Photo("Za7ma", "Cairo", 40.7128, -74.0060, Arrays.asList("city", "night", "lights"));
        Photo photo4 = new Photo("Beach Relaxation", "Beach", 34.0522, -118.2437, Arrays.asList("relax", "beach"));


        gallery.addPhoto(photo1);
        gallery.addPhoto(photo2);
        gallery.addPhoto(photo3);
        gallery.addPhoto(photo4);

        // Create a PhotoService to interact with the photos
        PhotoService photoService = new PhotoService(gallery);

        // 1. Test getting a photo by ID (invalid case)
        try {
            System.out.println("Getting photo by ID (invalid):");
            Photo photoById = photoService.getPhotoById("invalid_id"); // Invalid ID should throw an exception
            System.out.println(photoById);
        } catch (PhotoNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 2. Test getting a photo by ID (valid case)
        try {
            System.out.println("\nGetting photo by ID (valid):");
            Photo photoById = photoService.getPhotoById(photo1.getId()); // Valid ID should return a photo
            System.out.println(photoById);
        } catch (PhotoNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 3. Test getting photos by tag (invalid case)
        try {
            System.out.println("\nGetting photos by tag 'vacation' (valid):");
            List<Photo> photosByTag = photoService.getPhotosByTag("vacation"); // Valid tag should return a list of photos
            photosByTag.forEach(System.out::println);
        } catch (NoPhotosFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 4. Test getting photos by tag (invalid case)
        try {
            System.out.println("\nGetting photos by tag 'holiday' (invalid):");
            List<Photo> photosByTag = photoService.getPhotosByTag("holiday"); // No photos with this tag should throw an exception
            photosByTag.forEach(System.out::println);
        } catch (NoPhotosFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 5. Test getting photos by location (valid case)
        try {
            System.out.println("\nGetting photos by location 'Beach' (valid):");
            List<Photo> photosByLocation = photoService.getPhotosByLocation("Beach"); // Valid location should return photos
            photosByLocation.forEach(System.out::println);
        } catch (NoPhotosFoundByLocationException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 6. Test getting photos by location (invalid case)
        try {
            System.out.println("\nGetting photos by location 'Desert' (invalid):");
            List<Photo> photosByLocation = photoService.getPhotosByLocation("Desert"); // No photos in 'Desert' should throw an exception
            photosByLocation.forEach(System.out::println);
        } catch (NoPhotosFoundByLocationException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 7. Test getting photos by latitude and longitude (valid case)
        try {
            System.out.println("\nGetting photos by latitude and longitude (valid):");
            List<Photo> photosByLatAndLng = photoService.getPhotosByLatandLng(34.0522, -118.2437); // Valid coordinates should return photos
            photosByLatAndLng.forEach(System.out::println);
        } catch (NoPhotosFoundByLatLngException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 8. Test getting photos by latitude and longitude (invalid case)
        try {
            System.out.println("\nGetting photos by latitude and longitude (invalid):");
            List<Photo> photosByLatAndLng = photoService.getPhotosByLatandLng(999.9999, 999.9999); // Invalid coordinates should throw an exception
            photosByLatAndLng.forEach(System.out::println);
        } catch (NoPhotosFoundByLatLngException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
