import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

@WebServlet("/mp")
public class mp extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AudioStream audioStream;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String command = request.getParameter("command");
        String songName = request.getParameter("song");
        //if(songName == null || songName.isEmpty()) {
            //response.getWriter().println("Please provide song name as a parameter.");
            //return;
        //}
        if(command.equals("play")) {
            if(audioStream != null) {
                AudioPlayer.player.start(audioStream);
            } else {
                InputStream in = getServletContext().getResourceAsStream("/WEB-INF/music/" + songName);
                audioStream = new AudioStream(in);
                AudioPlayer.player.start(audioStream);
            }
        } else if(command.equals("pause")) {
            AudioPlayer.player.stop(audioStream);
        } else if(command.equals("stop")) {
            AudioPlayer.player.stop(audioStream);
            audioStream = null;
            }
        }
    }

    
    
        
    
