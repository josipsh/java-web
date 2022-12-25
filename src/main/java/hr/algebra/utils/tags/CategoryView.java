package hr.algebra.utils.tags;

import hr.algebra.data.IUnitOfWork;
import hr.algebra.data.RepoFactory;
import hr.algebra.models.Category;
import hr.algebra.models.SubCategory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class CategoryView extends SimpleTagSupport {
    private String contextPath;
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        IUnitOfWork uow = RepoFactory.getUnitOfWork();

        try {
            Collection<Category> categories = uow.categories().getAll();
            for (Category category : categories){
                out.println("<div class=\"flex flex-col ml-2 py-2\">");
                out.println("<div class=\"flex flex-row\">");
                out.println("<button id=\"expandButton_" + category.getLink() + "\" class=\"flex pl-1 items-center w-[24px] h-[24px]\" type=\"button\">");
                out.println("<img src=\"" + contextPath + "/Icons/expand_right_24.svg\" alt=\"Expand icon\" />");
                out.println("</button>");
                out.println("<a href=\"?category=${category.link}\" class=\"text-light-300 text-lg self-center font-bold uppercase whitespace-nowrap\">");
                out.println(category.getDisplayName());
                out.println("</a>");
                out.println("</div>");
                out.println("<div id=\"subcategories_" + category.getLink() + "\" class=\"flex-col pl-12 hidden\">");
                renderSubcategories(out, (ArrayList<SubCategory>) category.getSubcategories());
                out.println("</div>");
                out.println("</div>");
                appendJavaScript(out, category);
            }
        } catch (Exception ex) {
            throw new JspException("Error in CategoryView tag.", ex);
        }
    }

    private void appendJavaScript(JspWriter out, Category category) throws IOException {
        out.println("<script>");
        out.println("const expandButton_" + category.getLink() + " = document.querySelector(\"#expandButton_"+ category.getLink() + "\");");
        out.println("const subcategories_"+ category.getLink() + " = document.querySelector(\"#subcategories_"+ category.getLink() + "\");");
        out.println("if (expandButton_" + category.getLink() + " == null) {");
        out.println("console.log(\"Unable to load expandButton element!\");");
        out.println("}");
        out.println("expandButton_" + category.getLink() + " === null || expandButton_" + category.getLink() + " === void 0 ? void 0 : expandButton_" + category.getLink() + ".addEventListener(\"click\", () => {");
        out.println("if (subcategories_" + category.getLink() + " == null) {");
        out.println("console.log(\"Unable to load subcategories element!\");");
        out.println("return;");
        out.println("}");
        out.println("if (subcategories_" + category.getLink() + ".classList.contains(\"flex\")) {");
        out.println("subcategories_" + category.getLink() + ".classList.remove(\"flex\");");
        out.println("subcategories_" + category.getLink() + ".classList.add(\"hidden\");");
        out.println("updateIcon_" + category.getLink() + "(false);");
        out.println("}");
        out.println("else {");
        out.println("subcategories_" + category.getLink() + ".classList.add(\"flex\");");
        out.println("subcategories_" + category.getLink() + ".classList.remove(\"hidden\");");
        out.println("updateIcon_" + category.getLink() + "(true);");
        out.println("}");
        out.println("});");
        out.println("function updateIcon_" + category.getLink() + "(isExpend) {");
        out.println("const imgElement_" + category.getLink() + " = expandButton_" + category.getLink() + " === null || expandButton_" + category.getLink() + " === void 0 ? void 0 : expandButton_" + category.getLink() + ".childNodes[1];");
        out.println("if (imgElement_" + category.getLink() + " == null) {");
        out.println("console.log(\"Unable to load imgEleemnt.\");");
        out.println("return;");
        out.println("}");
        out.println("if (isExpend) {");
        out.println("imgElement_" + category.getLink() + ".src = imgElement_" + category.getLink() + " === null || imgElement_" + category.getLink() + " === void 0 ? void 0 : imgElement_" + category.getLink() + ".src.replace(\"right\", \"more\");");
        out.println("}");
        out.println("else {");
        out.println("imgElement_" + category.getLink() + ".src = imgElement_" + category.getLink() + " === null || imgElement_" + category.getLink() + " === void 0 ? void 0 : imgElement_" + category.getLink() + ".src.replace(\"more\", \"right\");");
        out.println("}");
        out.println("}");
        out.println("</script>");
    }

    private static void renderSubcategories(JspWriter out, ArrayList<SubCategory> subCategories) throws IOException {
        for (SubCategory sub : subCategories) {
            out.println("<a href=\"?subcategory=${subcategory.link}\" class=\"text-light-300 uppercase py-[0.15rem] whitespace-nowrap\">");
            out.println(sub.getDisplayName());
            out.println("</a>");
        }
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }
}
