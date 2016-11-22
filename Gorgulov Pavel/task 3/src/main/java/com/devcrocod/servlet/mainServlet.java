package com.devcrocod.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/")
public class mainServlet extends HttpServlet {

    private final static String ACTION_START = "start";

    private static boolean aBoolean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        req.getRequestDispatcher("start.jsp").forward(req, res);

        if (aBoolean)
            redirectWin(req, res);
        else
            redirectLose(req, res);

//        req.setAttribute("name", "Devcrocod");
//
//        req.getRequestDispatcher("mypage.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        String s = req.getParameter("count");

        int count = Integer.parseInt(s);

        result(count, action);
//        if (ACTION_START.equals(action)) {
//            if (count == riddle()) {
//                redirectWin(req, res);
//            } else {
//                redirectLose(req, res);
//            }
//        }
//        String count = req.getParameter("name");

//        String value = req.getParameter(name);

    }

    private void result(int count, String action) {
        if (ACTION_START.equals(action)) {
            if (count == riddle()) {
                aBoolean = true;
            } else {
                aBoolean = false;
            }
        }
    }

    private int riddle() {
        return (int) (Math.random() * 100);
    }

    private void redirectWin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("win.jsp").forward(request, response);
    }

    private void redirectLose(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("lose.jsp").forward(request, response);
    }
}
