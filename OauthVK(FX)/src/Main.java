        /*Все очень просто. Нужно извлечь адрес, на который тебя перенаправляет Vk.com*/

        /* Подключаем FX компонент */
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Main extends Application{
    public static final String REDIRECT_URL = "https://oauth.vk.com/blank.html";
    public static final String VK_AUTH_URL = "https://oauth.vk.com/authorize?client_id=6691918&amp;display=page&amp;redirect_uri=http://example.com/callback&amp;scope=friends&amp;response_type=token&amp;v=5.59"; //TODO!!!
    public static String tokenUrl;

    public static void main(String[] args){
        System.out.println(Main.getTokenUrl()); //запрашиваем токен
    }

    public static String getTokenUrl(){
        launch(Main.class);
        return tokenUrl;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        final WebView view = new WebView();
        final WebEngine engine = view.getEngine();
        engine.load(VK_AUTH_URL);


        primaryStage.setScene(new Scene(view));
        primaryStage.show();

        engine.locationProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue.startsWith(REDIRECT_URL)){
                    tokenUrl=newValue;
                    primaryStage.close();
                }
            }

        });

    }

}