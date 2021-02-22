package ImageHoster.controller;

import ImageHoster.model.Image;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * This is a controller class containing all the request handling methods to handle landing page operations in the ImageHoster application
 * DispatcherServlet scans the classes annotated with @Controller annotation and looks for the appropriate handler method to serve the client request
 */
@Controller
public class HomeController {

    /**
     * This class needs an object of ImageService class
     * One way is to simply declare the object of ImageService class in this class using new operator
     * But declaring the object using the new operator makes this class tightly coupled to ImageService class
     * Therefore in order to achieve loose coupling, we use the concept of dependency injection
     *
     * @Autowired annotation injects the ImageService bean in this class from the Spring container, which has been declared in the Spring container at the time you run the application
     */
    @Autowired
    private ImageService imageService;

    /**
     * This request handling method is called when you run the application on the localhost
     * The method adds a list of images in the Model type object with 'images' as the key and returns the 'index.html' file displaying all the images in the application
     *
     * @param model - model is an object of Type Model, a class provided by the Spring. You can add the attributes in this Model type object and then access these attributes in the HTML files
     * @return - This method returns the 'index.html' file displaying all the images in the application
     */
    @RequestMapping("/")
    public String getAllImages(Model model) {
        List<Image> images = imageService.getAllImages();
        model.addAttribute("images", images);
        return "index";
    }
}