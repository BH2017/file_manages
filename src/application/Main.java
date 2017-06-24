package application;
	
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
//import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.FlowPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	private Label l1;
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("homePage1.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("本地文件管理");
			primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				
				@Override
				public void handle(WindowEvent event) {
					// TODO Auto-generated method stub
					System.out.println("点叉关闭");
					System.exit(1);
				}
			});
			primaryStage.show();
//			System.out.println(HomePageController.getShow_load_info());
			new Thread(){
				@Override
				public void run() {
					while(true){
						if((l1=HomePageController.getShow_load_info())!=null)
							break;
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					//----2
					while(true){
						try{
							Thread.sleep(800);
							l1.setText("223");
						}catch (InterruptedException e) {
							// TODO: handle exception
							e.printStackTrace();
						}
					}
				}
			}.start();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
//		Label l2 = HomePageController.getShow_load_info();
//		l2.setText("as1");
//		System.out.println(l2);
	}
}
