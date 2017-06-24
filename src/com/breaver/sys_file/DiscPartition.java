/**
 * 
 */
package com.breaver.sys_file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author zzf
 * @date 2017��6��24�� ����11:09:41
 */
public class DiscPartition {
	private static final ArrayList<File> partitions;
	/**
	 * @param args
	 */
	static {
		partitions = new ArrayList<>();
		for (File file : File.listRoots()) {
			if (file.getTotalSpace() > 0)
				partitions.add(file);
			else
				System.out.println("����" + file.getAbsolutePath() + "�ռ�Ϊ0��������Ч��Χ");
		}
	}

	/**
	 * @return the partitions
	 */
	public static ArrayList<File> getPartitions() {
		return partitions;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ���գ�http://bbs.csdn.net/topics/310094540
		File[] root = File.listRoots();
		for (File file : root)
			try {
				System.out.println(file.getAbsolutePath() + "::����:" + file.getName() + "::���ڵ㣺" + file.getParent()
						+ "::�洢�ռ䣺" + file.getTotalSpace() / (1024 * 1024 * 1024) + "G" + "::ʣ��ռ䣺"
						+ file.getFreeSpace() + "b" + "::Ȩ����������" + file.getCanonicalFile());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
