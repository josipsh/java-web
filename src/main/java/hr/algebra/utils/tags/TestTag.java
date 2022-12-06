package hr.algebra.utils.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class TestTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        try {
            out.println("<h1>Test tag title</h1>");
        }catch (IOException ex){
            throw new JspException("Error in TestTag", ex);
        }
    }
}
