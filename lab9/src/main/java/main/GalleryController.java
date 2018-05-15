package main;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import java.util.List;
@RestController
public class GalleryController {
    @Autowired
    private GalleryService galleryService;
    private Gallery gallery;
    @RequestMapping("/photos")
    public List<Gallery >getAllPhotos()
    {
        return galleryService.getAllPhotos();
    }
    @RequestMapping("/photos/{id}")
    public Gallery getPhoto(@PathVariable  int id)
    {
        return galleryService.getPhoto(id);
    }
    @RequestMapping(method = RequestMethod.POST , value = "/photos")
    public void addPhoto(@RequestBody Gallery photo)
    {
        galleryService.addPhoto(photo);
    }
    @RequestMapping(method = RequestMethod.PUT , value= "/photos/{id}")
    public void updateGallery(@RequestBody Gallery photo , @PathVariable int id)
    {
        galleryService.updateGallery(photo,id);
    }
    @RequestMapping(method = RequestMethod.DELETE , value= "/photos/{id}")
    public void deleteGallery( @PathVariable int id)
    {
        galleryService.deleteGallery(id);
    }

}
