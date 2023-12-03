/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.dataflair.mp3.dataflair.mp3musicplayer;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mirthula
 */
public class urls extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String songName = request.getParameter("songName");
        
        String youtubeUrl = "https://www.youtube.com/results?search_query=" + songName;
        
        
        // Redirect the user to the YouTube URL
        response.sendRedirect(youtubeUrl);
        
        // Open the Spotify URL in a new tab/window
        //response.getWriter().println("<script>window.open('" + spotifyUrl + "', '_blank');</script>");
}
}