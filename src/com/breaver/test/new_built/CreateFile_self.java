/**
 * 
 */
package com.breaver.test.new_built;

import java.io.File;

/**
 * @author zzf
 *@date 2017年6月22日 上午11:35:17
 */
public class CreateFile_self {
	public static final String str_currentPath=System.getProperty("user.dir");
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("创建文件并保存");
		System.out.println(System.getProperty("user.dir"));
		CreateFile_self.createOneFile("");
	}
	//传入绝对路径,生成文件
	public static Boolean createOneFile(String pathFile){
		File file = new File("1.txt");
		try{
			if(!file.exists()){
				file.createNewFile();	
			}
		}catch (Exception e) {
				// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println(file.getAbsolutePath());
		System.out.println(System.getProperty("user.dir"));
		return true;
	}
	//传入当前路径和文件名,产生绝对路径
	public static String createOneAbsolutePath(String path,String fileName){
		return null;
	}
	//检查路径是否存在
	public static boolean checkPathIsExist(String path){
		return true;
	}
	//检查文件是否存在
	public static boolean checkFileIsExist(String filePath){
		return true;
	}
	//产生当前路径---
	public static String createPathCurrent(){
		return null;
	} 
}
