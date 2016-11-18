package com.exigenservices.lectures;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.IOException;

public class GuessTag extends BodyTagSupport {
    private void output(String s) {
        JspWriter out = getBodyContent().getEnclosingWriter();
        try {
            out.write(s);
        } catch (java.io.IOException e) {
        }
    }

    private void redirect(String s) {
        HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();
        try {
            response.sendRedirect(s);
        } catch (java.io.IOException e) {
        }
    }

    @Override
    public int doStartTag() {
        if(pageContext.getRequest() != null) {
            int number = -1;
            int guesstimate = 0;

            String s = pageContext.getRequest().getParameter("tryguesstimate");
            if (s != null) {
                if(!s.equals("")) {
                    guesstimate = Integer.parseInt(pageContext.getRequest().getParameter("tryguesstimate"));
                } else {
                    return EVAL_BODY_INCLUDE;
                }
            }

            s = pageContext.getRequest().getParameter("trynumber");
            if (s != null) {
                if(!s.equals("")) {
                    number = Integer.parseInt(pageContext.getRequest().getParameter("trynumber"));
                }
            }
            if(number > 0) {
                if(number == guesstimate) {
                    redirect("win.html");
                } else {
                    redirect("defeat.html");
                }
            }
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() {
        return EVAL_PAGE;
    }
}
