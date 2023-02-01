package hr.algebra.servlets;

import hr.algebra.data.IBlobRepository;
import hr.algebra.data.RepoFactory;
import hr.algebra.utils.exceptions.BlobException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "BlobServlet", value = "/blob")
@MultipartConfig
public class BlobServlet extends HttpServlet {
    private final IBlobRepository blobRepository;

    public BlobServlet() {
        try {
            blobRepository = RepoFactory.getBlobRepository();
        } catch (BlobException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String blobName = req.getParameter("name");
        if (blobName == null) {
            res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        try (OutputStream out = res.getOutputStream()) {
            byte[] byteArray = blobRepository.getFile(blobName);
            if (byteArray == null) {
                res.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return;
            }

            res.setContentType("image/png");
            res.setContentLength(byteArray.length);
            out.write(byteArray);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            String productId = req.getParameter("productId");
            Part blobPart = req.getPart("blob");
            if (productId == null || blobPart == null) {
                res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }

            blobRepository.saveFile(blobPart.getInputStream(), productId);
        } catch (BlobException e) {
            throw new RuntimeException(e);
        }
    }
}
