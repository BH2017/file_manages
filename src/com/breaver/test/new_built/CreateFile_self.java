/**
 * 
 */
package com.breaver.test.new_built;

import java.io.File;

/**
 * @author zzf
 *@date 2017��6��22�� ����11:35:17
 */
public class CreateFile_self {
	public static final String str_currentPath=System.getProperty("user.dir");
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("�����ļ�������");
		System.out.println(System.getProperty("user.dir"));
		CreateFile_self.createOneFile("");
	}
	//�������·��,�����ļ�
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
	//���뵱ǰ·�����ļ���,��������·��
	public static String createOneAbsolutePath(String path,String fileName){
		return null;
	}
	//���·���Ƿ����
	public static boolean checkPathIsExist(String path){
		return true;
	}
	//����ļ��Ƿ����
	public static boolean checkFileIsExist(String filePath){
		return true;
	}
	//������ǰ·��---
	public static String createPathCurrent(){
		return null;
	} 
}
