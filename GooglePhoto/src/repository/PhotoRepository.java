package repository;

import Model.Photo;

import java.util.ArrayList;
import java.util.List;
/*
* el coupling hena kan 3ali fa hnrou7
* nefsl el tight coupling
*  be class el repo zy el spring
* el so2al hna 3ayzen eh ?
* 3yzen n3m; kol el operation 3n tare2 el repo bdl ma ykon fe high dependency
* Aknena bn3ml CRUD 3adi Add,remove,retrieve(Read)
* fe 7etet el batch deh l72na n3mlha eshta ml72nash khalas lama n2lbo spring n3mlo *Bonus*  */




public interface PhotoRepository {
    List<Photo> getPhotos();
}



