package SpringBoot.REST;

import SpringBoot.Extras.MyImage;
import SpringBoot.Extras.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


@Component
@PropertySource("classpath:application.properties")
@Controller
public class MainController {
    @Value("${folderPath}")
    private String path;
    private List<MyImage> listOfImages;



    @RequestMapping(value = "view/photos", method = RequestMethod.GET)
    @ResponseBody

    public ModelAndView allPictures() {
        listOfImages = new ArrayList<MyImage>();
        BufferedImage readImage = null;
        String name = "";
        int h = 0, w = 0;
        String resulution = "";
        long size = 0;
        MyImage.clearid();

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles != null) {
            for (File f : listOfFiles) {
                MyImage tempImage;
                try {
                    readImage = ImageIO.read(f);
                    name = f.getName();
                    size = f.length();
                    w = readImage.getWidth();
                    h = readImage.getHeight();
                } catch (IOException e) {
                    readImage = null;
                    e.printStackTrace();
                }

                BasicFileAttributes attr;
                try {
                    attr = Files.readAttributes(Paths.get(f.getPath()), BasicFileAttributes.class);
                    String time = String.valueOf(attr.creationTime());
                    resulution = w + "x" + h;
                    tempImage = new MyImage(name, resulution, size, time);
                    listOfImages.add(tempImage);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        ModelAndView modelAndView = new ModelAndView("index");


        modelAndView.addObject("photosArray", listOfImages);

        return modelAndView;
        //return listOfImages;

    }




     @RequestMapping(value = "/view/photos/{index}", method = RequestMethod.GET,produces = MediaType.IMAGE_JPEG_VALUE)
     public BufferedImage getImage(HttpServletResponse response, @PathVariable(value = "index") int index) {
         BufferedImage img=null;
         response.setContentType(MediaType.IMAGE_JPEG_VALUE);
         try {
             img = ImageIO.read(new File("C:\\Images\\image.png"));
         } catch (IOException e) {
             e.printStackTrace();
         }

         return img; //nie działa
     }
    public List<MyImage> allPictures2() {
        listOfImages = new ArrayList<MyImage>();
        BufferedImage readImage = null;
        String name = "";
        int h = 0, w = 0;
        String resulution = "";
        long size = 0;
        MyImage.clearid();

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles != null) {
            for (File f : listOfFiles) {
                MyImage tempImage;
                try {
                    readImage = ImageIO.read(f);
                    name = f.getName();
                    size = f.length();
                    w = readImage.getWidth();
                    h = readImage.getHeight();
                } catch (IOException e) {
                    readImage = null;
                    e.printStackTrace();
                }

                BasicFileAttributes attr;
                try {
                    attr = Files.readAttributes(Paths.get(f.getPath()), BasicFileAttributes.class);
                    String time = String.valueOf(attr.creationTime());
                    resulution = w + "x" + h;
                    tempImage = new MyImage(name, resulution, size, time);
                    listOfImages.add(tempImage);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        return listOfImages;
    }
   /* @RequestMapping(method = RequestMethod.GET, value = "/view/photos/{index}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<InputStreamResource> showImage(@PathVariable int index) throws FileNotFoundException {
        File file = new File(this.path.get(index).toString());
        InputStream inputStream = new FileInputStream(file);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(new InputStreamResource(inputStream));}*/
    @RequestMapping(value = "/view/photos/{index}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteImage(@PathVariable(value = "index") int index) {
        String nameToDelete="";
        boolean resDel=false;
        Result result=new Result();
        for(Object img: listOfImages)
        {
            MyImage tempImage=(MyImage)img;
            if(tempImage.getIndex()==index)
                nameToDelete=tempImage.getName();

        }



        if(nameToDelete.equals(""))
            result.setResult(false);

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        for (File f: listOfFiles) {
            if(f.getName().equals(nameToDelete)) {
                resDel=f.delete();
            }
        }

        if(resDel==true)
            result.setResult(true);
        else
            result.setResult(false);

        return result;
    }

   /* @RequestMapping(method = RequestMethod.DELETE, value = "view/photos/{id}")
    @ResponseBody
    public void deleteGallery ( @PathVariable int id){
        listOfImages.removeIf(t -> t.getIndex() == id);
    }*/

   @RequestMapping(value = "view/photos/{index}")
   public MyImage getPhoto(@PathVariable int index)
   {
       return listOfImages.stream().filter(t->t.getIndex()==index).findFirst().get();
   }
}


