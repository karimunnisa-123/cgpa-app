package com.cgpa;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class CGPAServlet extends HttpServlet {

    // Method to calculate grade
    private String getGrade(double cgpa) {
        if (cgpa >= 9) return "O (Outstanding)";
        else if (cgpa >= 8) return "A+";
        else if (cgpa >= 7) return "A";
        else if (cgpa >= 6) return "B";
        else if (cgpa >= 5) return "C";
        else return "F (Fail)";
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // SEM 1 marks
        double sem1_sub1 = Double.parseDouble(request.getParameter("sem1_sub1"));
        double sem1_sub2 = Double.parseDouble(request.getParameter("sem1_sub2"));
        double sem1_sub3 = Double.parseDouble(request.getParameter("sem1_sub3"));
        double sem1_sub4 = Double.parseDouble(request.getParameter("sem1_sub4"));
        double sem1_sub5 = Double.parseDouble(request.getParameter("sem1_sub5"));

        // SEM 2 marks
        double sem2_sub1 = Double.parseDouble(request.getParameter("sem2_sub1"));
        double sem2_sub2 = Double.parseDouble(request.getParameter("sem2_sub2"));
        double sem2_sub3 = Double.parseDouble(request.getParameter("sem2_sub3"));
        double sem2_sub4 = Double.parseDouble(request.getParameter("sem2_sub4"));
        double sem2_sub5 = Double.parseDouble(request.getParameter("sem2_sub5"));

        // Calculate SGPAs (marks out of 100, divide by 10 for CGPA)
        double sem1_sgpa = (sem1_sub1 + sem1_sub2 + sem1_sub3 + sem1_sub4 + sem1_sub5) / 50.0;
        double sem2_sgpa = (sem2_sub1 + sem2_sub2 + sem2_sub3 + sem2_sub4 + sem2_sub5) / 50.0;

        // Overall CGPA
        double cgpa = (sem1_sgpa + sem2_sgpa) / 2.0;

        // Grades
        String gradeSem1 = getGrade(sem1_sgpa);
        String gradeSem2 = getGrade(sem2_sgpa);
        String overallGrade = getGrade(cgpa);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>CGPA Calculator</h2>");
        out.println("<h3>Semester 1 SGPA: " + String.format("%.2f", sem1_sgpa) + " | Grade: " + gradeSem1 + "</h3>");
        out.println("<h3>Semester 2 SGPA: " + String.format("%.2f", sem2_sgpa) + " | Grade: " + gradeSem2 + "</h3>");
        out.println("<h2>Overall CGPA: " + String.format("%.2f", cgpa) + " | Grade: " + overallGrade + "</h2>");
        out.println("<a href='index.jsp'>Go Back</a>");
        out.println("</body></html>");
    }
}
