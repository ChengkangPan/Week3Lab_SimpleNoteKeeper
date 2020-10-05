/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serlet;

import java.util.*;
import java.io.*;
import domain.Note;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 832676
 */
public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //read from the txt file and create note object to display in the welcome page
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        File file = new File(path);
        try (Scanner myReader = new Scanner(file)) {
            String title = myReader.nextLine();
            String contents = myReader.nextLine();
            Note note = new Note(title, contents);
            request.setAttribute("note", note);
        }
        
        //checking if the request is going to the editnote.jsp
        String action = request.getParameter("edit");
        if ("editnote".equals(action)) {
            request.getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
        }
        
        //welcome page
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //writing to the file
         String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        try (PrintWriter pw = new PrintWriter (new FileWriter(path,false))) {
            String newTitle= request.getParameter("title");
            String newContent= request.getParameter("content");
            pw.println(newTitle);
            pw.println(newContent);
            Note note = new Note(newTitle, newContent);
            request.setAttribute("note", note);
        }
        
        //get back to viewnote page
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
    }

}
