package com.krieghb.javasnips.experiments.thread;

import java.io.File;
import java.util.Date;

public class FileSizeTest {
	
	public static void main (String [] args) {
		String filePath = "C:/Users/krido02/Documents/PAD/Data/Testing FTP/threadtest.txt.filepart";
//		String filePath = "C:/Users/krido02/Documents/PAD/Data/Testing FTP/threadtest.txt";
		
		if (isOpen(filePath)) {
			System.out.println("{FileLockTest} :: [isOpen] - File is OPEN:  '" + filePath + "'");
		}
		else {
			System.out.println("{FileLockTest} :: [isOpen] - File is CLOSED:  '" + filePath + "'");
		}
		
	}
	
	
	
	
	
	public static boolean isOpen(String path) {
		boolean fileOpen = false;

		File file = new File(path);
		Long lastModified = file.lastModified();
		
		Long currentTime;
		//= new Date().getTime();
//		System.out.println("{FileLockTest} :: [isOpen] - Last Modified:   " + lastModified);
//		System.out.println("{FileLockTest} :: [isOpen] - Current Time:    " + currentTime);
		
		long fileSize1 = file.length();
		long fileSize2;
		
//		System.out.println("{FileLockTest} :: [isOpen] - size of File:  " + fileSize1);
		
		try {
			Thread.sleep(5000);
		}
		catch (InterruptedException e) {
			System.out.println("{FileLockTest} :: [isOpen] - Sleep Interupted:   " + e.getMessage());
		}
		
		fileSize2 = file.length();
//		System.out.println("{FileLockTest} :: [isOpen] - size of File:  " + fileSize2);
		
		file = new File(path);
		lastModified = file.lastModified();
		currentTime = new Date().getTime();
		System.out.println("{FileLockTest} :: [isOpen] - Last Modified:   " + lastModified);
		System.out.println("{FileLockTest} :: [isOpen] - Current Time:    " + currentTime);
		
//		if (fileSize2 != fileSize1 || isOpenTime(lastModified, currentTime)) {
		if (isOpenTime(lastModified, currentTime)) {
			fileOpen = true;
		}
				
		return fileOpen;
	}
	
	public static boolean isOpenTime(Long lastModified, Long currentTime, Long... ranges) {
		boolean stillOpen = false;
		Long range = 100000L;
		
		if (ranges.length > 0) {
			range = ranges[0];
		}
		
		Long diff = Math.abs(lastModified - currentTime);
		
		if (diff <= range) {
			stillOpen = true;
		}
		System.out.println("{FileLockTest} :: [plusOrMinusTime] - Difference:    " + diff);
		
		
		
		
		return stillOpen;
	}
}
