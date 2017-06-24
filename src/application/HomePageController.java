/**
 * 
 */
package application;

//import java.awt.TextField;
import java.net.URL;
import java.util.ArrayList;
//import java.util.Map;
import java.util.ResourceBundle;

import com.breaver.sys_file.Catalogue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

/**
 * @author zzf
 *@date 2017年6月24日 上午10:19:11
 */
public class HomePageController implements Initializable,Runnable {
	@FXML
	private SplitPane split_h1;
	@FXML
	private TreeView<String> tv_showDirectionStructure;
	@FXML
	private Button btn_search;
	@FXML
	private TextField input_path;
	@FXML
	private static Label show_load_info;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		readFileSystem();
		Thread t1 =  new Thread(){
			@Override
			public void run() {
				TreeItem<String> root = tv_showDirectionStructure.getRoot();
				System.out.println("开始读取....");
				Catalogue.getAllFileItem(root);
				System.out.println("读取完成...");
			}
		};
		t1.setDaemon(true);
		t1.start();
		/*new Thread(){
			@Override
			public void run() {
				try{
					Thread.sleep(3000);
				}catch (InterruptedException e) {
					e.printStackTrace();
					// TODO: handle exception
				}
				while(true){
					show_load_info.setText("正在加载:"+Catalogue.getCount());	
					
					try{
						Thread.sleep(800);
					}catch (InterruptedException e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}			
			}
		}.start();*/
	}
	
	/**
	 * @return the show_load_info
	 */
	public static Label getShow_load_info() {
		return show_load_info;
	}

	/**
	 * @param show_load_info the show_load_info to set
	 */
	public void setShow_load_info(Label show_load_info) {
		this.show_load_info = show_load_info;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		TreeItem<String> root = tv_showDirectionStructure.getRoot();
		System.out.println("开始读取....");
		Catalogue.getAllFileItem(root);
		System.out.println("读取完成...");
	}
	public void doSearch(ActionEvent actionEvent){
		
	}
	public void doExit(ActionEvent actionEvent){
		System.out.println("退出程序");
		System.exit(1);
	}
	public void readFileSystem(){
		TreeItem<String> root = new TreeItem<>("我的电脑");
		tv_showDirectionStructure.setRoot(root);
	}
	private void continueRead(){
		//
	}
	private void test_treeview(){
		TreeItem<String> item = new TreeItem<>("sas");
		TreeItem<String> i1 = new TreeItem<>("as");
//		ArrayList<TreeItem<String>> arrayList = ArrayList<TreeItem<String>>();
//		Map<K, V>
		ArrayList<TreeItem<String>> arrayList = new ArrayList<>();
		arrayList.add(new TreeItem<String>("lis1-----------------------------------------------------"));
		for(int i=0;i<20;i++)
		arrayList.add(new TreeItem<String>("lis2::"+i));
		item.getChildren().addAll(arrayList);
		tv_showDirectionStructure.setRoot(item);
	}
}
