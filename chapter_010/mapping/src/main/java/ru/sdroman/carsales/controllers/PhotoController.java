package ru.sdroman.carsales.controllers;

import com.google.gson.JsonArray;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.FileCleanerCleanup;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileCleaningTracker;
import org.apache.log4j.Logger;
import ru.sdroman.carsales.models.Photo;
import ru.sdroman.carsales.repository.PhotoRepository;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sdroman
 * @since 07.2018
 */
public class PhotoController extends HttpServlet {

    /**
     * Logger.
     */
    private static final Logger LOG = Logger.getLogger(PhotoController.class);

    /**
     * Get.
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     * @throws ServletException exception
     * @throws IOException      exception
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("image/jpeg");
        int orderId = Integer.valueOf(req.getParameter("orderId"));
        PhotoRepository repository = new PhotoRepository();
        List<Photo> photoList = repository.getPhotoByOrderId(orderId);
        JsonArray json = new JsonArray();
        for (Photo photo : photoList) {
            json.add(String.format("data:image/jpeg;base64,%s", DatatypeConverter.printBase64Binary(photo.getImages())));
        }
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append(json.toString());
        writer.flush();
    }

    /**
     * Post.
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     * @throws ServletException exception
     * @throws IOException      exception
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        if (isMultipart) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletContext context = this.getServletConfig().getServletContext();
            FileCleaningTracker tracker = FileCleanerCleanup.getFileCleaningTracker(context);
            factory.setFileCleaningTracker(tracker);
            File repository = (File) context.getAttribute("javax.servlet.context.tempdir");
            factory.setRepository(repository);

            ServletFileUpload upload = new ServletFileUpload(factory);
            HttpSession session = req.getSession();
            List<Photo> photoList = session.getAttribute("photoList") != null
                    ? (List<Photo>) session.getAttribute("photoList") : new ArrayList<>();
            try {
                List<FileItem> items = upload.parseRequest(req);
                for (FileItem file : items) {
                    byte[] fileByte = file.get();
                    Photo photo = new Photo();
                    photo.setImages(fileByte);
                    photoList.add(photo);
                }
                session.setAttribute("photoList", photoList);
            } catch (FileUploadException e) {
                LOG.error(e.getMessage(), e);
            }
        }
    }
}
