/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author Bavneet
 */
public class NoteServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String Title  = "";
        String Contents = "" ;
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        // to read files
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        
        Title = br.readLine();
        String x;
        while ((x = br.readLine()) != null)   {
            Contents = x + Contents;
            // Print the content on the console
            //System.out.println (Contents);    
        }
        br.close();
        
        Note note = new Note(Title, Contents);
        request.setAttribute("note", note);
        
        if(request.getParameter("edit") == null){
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        return;
        }
        else{
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
        return;
        }
        
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String Title = request.getParameter("title");
        String Contents = request.getParameter("contents");
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
//        // to read files
//        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
//        
//        Title = br.readLine();
//        
//        while ((Contents = br.readLine()) != null)   {
//            // Print the content on the console
//            System.out.println (Contents);    
//        }

        Note note = new Note(Title, Contents);
        request.setAttribute("note", note);
        
        // to write to a file
        PrintWriter pw = new PrintWriter(new BufferedWriter(new 
        FileWriter(path)));
        pw.write(Title + "\n" + Contents);
        pw.close();
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        
    }

}
