/**
 * 
 */
package com.breaver.sys_file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import application.HomePageController;
import javafx.scene.control.TreeItem;

/**
 * @author zzf
 *@date 2017年6月24日 上午11:26:56
 */
public class Catalogue {
	private static int count=0;
	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Catalogue.getAllFilesUnderThePath("c:\\");
		Long t1 = new Date().getTime();
		System.out.println(t1);
//		Catalogue.getAllFileItem();
		/*try{
			Thread.sleep(1000);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}*/
		Long t2 = new Date().getTime();
//		System.out.println("::"+(t2-t1)/1000+"s");
	}
	/**
	 * @return the count
	 */
	public static int getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public static void setCount(int count) {
		Catalogue.count = count;
	}
	public static void getAllFileItem(TreeItem<String> root){
//		TreeItem<String> root = new TreeItem<String>("我的电脑");
		//----step1---分区---递归-来添加item---
		/*TreeItem<String> item = new TreeItem<>("H");
		root.getChildren().add(item);
		addAllFile(item, "h:\\");*/
//		return root;
		for(File file:DiscPartition.getPartitions()){
			TreeItem<String> i1 = new TreeItem<>(file.getAbsolutePath());
			root.getChildren().add(i1);
			new Thread(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
//					super.run();
					addAllFile(i1, file.getAbsolutePath());
				}
			}.start();		
		}
			
	}
	private static void addAllFile(TreeItem<String> head,String path){
		File file = new File(path);
		File[] fs = file.listFiles();
		if(file == null || fs == null)
			return;
		if(!file.isDirectory()||fs.length == 0)
			return;
//		System.out.println(file.getAbsolutePath());
		for(File file2:fs){
//			System.out.println("::"+count++);
			count++;
			if(file2.isHidden())
				continue;
			TreeItem<String> item = new TreeItem<>(file2.getName());
			head.getChildren().add(item);
			if(file2.isDirectory())
				try {
					addAllFile(item, file2.getCanonicalPath());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	public static File[] getAllFilesUnderThePath(String path){
		File[] files = new File(path).listFiles();
		/*int i=1;
		for(File file:files){
			System.out.println(i+++"::"+file.getName()
			+"file or dir::"+(file.isDirectory()?"D":"F")
			+"is-Hiden:"+file.isHidden());
			if(file.getName().equals("tempd1"))
				System.out.println(file.mkdir()
						+"::"+file.lastModified()
						+"::"+file.listFiles().length);
		}*/
		return files;
	}
}
