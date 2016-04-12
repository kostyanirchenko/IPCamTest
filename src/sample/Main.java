package sample;


import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.component.EmbeddedMediaListPlayerComponent;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import javax.swing.*;

public class Main {

    private final EmbeddedMediaPlayerComponent mediaPlayerComponent;

    public static void main(String[] args) {
        /*System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        VideoCapture camera = new VideoCapture(*//*"rtp://192.168.1.8"*//*);
        camera.set(Videoio.CV_CAP_PROP_FRAME_WIDTH, 1280);
        camera.set(Videoio.CV_CAP_PROP_FRAME_HEIGHT, 720);
        camera.open("http://iris.not.iac.es/axis-cgi/mjpg/video.cgi?resolution=320x240");
        if(!camera.isOpened()) {
            System.out.println("Error");
        } else {
            int index = 0;
            Mat frame = new Mat();
            while(true) {
                if (camera.read(frame)) {
                    System.out.println("Captured");
                    Imgcodecs.imwrite("camera" + (index++) + ".jpg", frame);
                }
            }
        }
        camera.release();*/
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }

    private Main() {
        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "C:\\Program Files\\VideoLAN\\VLC");
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
        JFrame frame = new JFrame("Test");
        mediaPlayerComponent = new EmbeddedMediaListPlayerComponent();
        frame.setContentPane(mediaPlayerComponent);
        frame.setLocation(100, 100);
        frame.setSize(1050, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        mediaPlayerComponent.getMediaPlayer().playMedia("rtsp://admin:12345678q@192.168.1.8:554");
    }
}
