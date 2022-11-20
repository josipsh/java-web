package hr.algebra.utils.tags;
//
//import jakarta.servlet.jsp.JspException;
//import jakarta.servlet.jsp.JspWriter;
//import jakarta.servlet.jsp.tagext.SimpleTagSupport;
//import java.io.IOException;
//
//public class TestTag extends SimpleTagSupport {
//    private String name;
//
//    @Override
//    public void doTag() throws JspException, IOException {
//        JspWriter out = getJspContext().getOut();
//
//        try {
//            out.println("Hello" + name);
//        }catch (IOException ex){
//            throw new JspException("Error in TestTag", ex);
//        }
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//}
