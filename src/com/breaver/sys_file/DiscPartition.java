/**
 * 
 */
package com.breaver.sys_file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author zzf
 * @date 2017年6月24日 上午11:09:41
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
				System.out.println("分区" + file.getAbsolutePath() + "空间为0，不在有效范围");
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
		// 参照：http://bbs.csdn.net/topics/310094540
		File[] root = File.listRoots();
		for (File file : root)
			try {
				System.out.println(file.getAbsolutePath() + "::名字:" + file.getName() + "::父节点：" + file.getParent()
						+ "::存储空间：" + file.getTotalSpace() / (1024 * 1024 * 1024) + "G" + "::剩余空间："
						+ file.getFreeSpace() + "b" + "::权威？？：：" + file.getCanonicalFile());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
