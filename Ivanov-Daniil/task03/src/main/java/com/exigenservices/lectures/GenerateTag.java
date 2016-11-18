package com.exigenservices.lectures;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.IOException;

public class GenerateTag extends BodyTagSupport {
    boolean having_number = false;
    int number;
    private void output(String s) {
        JspWriter out = getBodyContent().getEnclosingWriter();
        try {
            out.write(s);
        } catch (java.io.IOException e) {
        }
    }
    private void output_console(String s) {
        JspWriter out = getBodyContent().getEnclosingWriter();
        try {
            out.write("<script>\n" +
                    "console.log('" + s + "');\n" +
                    "</script>");
        } catch (java.io.IOException e) {
        }
    }


    @Override
    public int doStartTag() {
        return EVAL_BODY_BUFFERED;
    }

    @Override
    public int doEndTag() {
        if(pageContext.getRequest() != null) {
            String s = pageContext.getRequest().getParameter("restart");
            if(s != null) {
                if(s.equals("yes")) {
                    having_number = false;
                }
            }
        }
        if(!having_number) {
            java.util.Random rand = new java.util.Random();
            number = (rand.nextInt(100)) + 1;
            having_number = true;
        }
        output_console(String.valueOf(number));
        output("<input type='hidden' name='trynumber' value='" + String.valueOf(number) + "'>");
        return EVAL_PAGE;
    }

    public void setNumber(String s) {
        if(s == null) {
            return;
        }
        if(!s.equals("")) {
            having_number = true;
            number = Integer.parseInt(s);
        }
    }
}
