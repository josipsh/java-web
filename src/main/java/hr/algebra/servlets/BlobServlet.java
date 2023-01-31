package hr.algebra.servlets;

import hr.algebra.data.IBlobRepository;
import hr.algebra.data.RepoFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "BlobServlet", value = "/blob")
@MultipartConfig
public class BlobServlet extends HttpServlet {
    private final IBlobRepository blobRepository;

    public BlobServlet() {
        blobRepository = RepoFactory.getBlobRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String blobName = req.getParameter("name");
        if (blobName == null){
            res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        File file = blobRepository.getFile(blobName);
        if (file == null){
            res.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        res.setContentType("image/png");
        res.setContentLength((int) file.length());

        try (FileInputStream in = new FileInputStream(file);
             OutputStream out = res.getOutputStream()){
            byte[] buf = new byte[1024];
            int count;
            while ((count = in.read(buf)) > 0){
                out.write(buf, 0, count);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String productId = req.getParameter("productId");
        Part blobPart = req.getPart("blob");
        if (productId == null || blobPart == null){
            res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        blobRepository.saveFile(blobPart.getInputStream(), productId);
    }
}
