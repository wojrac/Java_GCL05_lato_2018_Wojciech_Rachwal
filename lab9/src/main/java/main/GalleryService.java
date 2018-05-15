package main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class GalleryService {
    List<Gallery> galleryList = new ArrayList<Gallery>(Arrays.asList(
            new Gallery(1,"photo1 ","1920x1080",262777,1525941686),
            new Gallery(2,"photo2"  ,"1920x1080",262777,1525941686),
            new Gallery(3,"photo3" , "1920x1080",262777,1525941686)));
    List<Gallery> getAllPhotos(){
        return galleryList;
    }
    public Gallery getPhoto(int id)
    {
        return galleryList.stream().filter(t->t.getId()==id).findFirst().get();
    }

    public void addPhoto(Gallery photo) {
        galleryList.add(photo);
    }

    public void updateGallery(Gallery photo,int id) {
        for(int i = 0 ;i<galleryList.size();i++)
        {
            Gallery gallery = galleryList.get(i);
            if(gallery.getId() == id)
            {
                galleryList.set(i,photo);
            }
        }

    }

    public void deleteGallery(int id) {
        galleryList.removeIf(t->t.getId()==id);

    }
}
