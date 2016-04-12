package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;



public class Controller {
    public WebView webView;
    public TextField loginField;
    public PasswordField passwordField;
    public Button okButton;
    public TextField ipField;

    public void okButtonAction(ActionEvent actionEvent) {
//        System.out.printf("Login: %s, Password: %s", loginField.getText(), passwordField.getText());
        String url = "rtsp://" + loginField.getText() + ":" + passwordField.getText() + "@" + ipField.getText() + ":554";
        System.out.println(url);
        try {
//            URL u = new URL(url);
//            HttpURLConnection connection = (HttpURLConnection) u.openConnection();
            WebEngine engine = webView.getEngine();
//            engine.load("rtsp://" + loginField.getText() + ":" + passwordField.getText() + "@" + ipField.getText() + ":554" /*connection*/);
            engine.load("http://192.168.1.8");
        } /*catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {

        }*/
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
