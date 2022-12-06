package hr.algebra.utils.tags;

import hr.algebra.viewModel.PageType;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class IsLinkActive extends SimpleTagSupport {

    private PageType current;
    private PageType active;
    private String activeColorClass;
    private String passiveColorClass;

    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        try {
            if (current.isEqual(active)) {
                out.println(activeColorClass);
            } else {
                out.println(passiveColorClass);
            }
        } catch (IOException ex) {
            throw new JspException("Error in IsLinkActive tac.", ex);
        }
    }

    public void setCurrent(PageType current) {
        this.current = current;
    }

    public void setActive(PageType active) {
        this.active = active;
    }

    public void setActiveColorClass(String activeColorClass) {
        this.activeColorClass = activeColorClass;
    }

    public void setPassiveColorClass(String passiveColorClass) {
        this.passiveColorClass = passiveColorClass;
    }
}
