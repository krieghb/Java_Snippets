package com.krieghb.javasnips.experiments.thread;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockTest {
	
	
	
	public static void main(String [] args) {

		
		String osName = System.getProperty("os.name").toLowerCase();
		
		
//		String path = "C:/Users/krido02/Documents/PAD/Data/Testing FTP/threadtest.txt";
		String path = "C:/Users/krido02/Documents/PAD/Data/Testing FTP/threadtest.txt.filepart";
		
		System.out.println("OS:  '" + osName + "'");
		
		if (osName.indexOf("nix") >= 0 || osName.indexOf("nux") >= 0 || osName.indexOf("aix") > 0 ) {
			checkLinux( path);//, path2);
		}
		else if (osName.indexOf("win") >= 0) {
			checkWin(path);//, path2);
		}
		

		
	}
	
	public static void checkLinux(String path1) {//, String path2) {
		System.out.println("{FileLockTest} :: [checkLinux] - processing in Linux");
		
		File file1 = new File(path1);
//		File file2 = new File(path2);
		boolean filesopen = true;
		boolean file1open = true;
		boolean file2open = true;
		
		
		while (filesopen) {
		
			if (!isFileClosed(file1)) {
				System.out.println("{FileLockTest} :: [main] - File is OPEN:  '" + path1 + "'");
				file1open = true;
			}
			else {
				System.out.println("{FileLockTest} :: [main] - File is CLOSED:  '" + path1 + "'");
				file1open = false;
			}
//			if (!isFileClosed(file2)) {
//				System.out.println("{FileLockTest} :: [main] - File is OPEN:  '" + path2 + "'");
//				file2open = true;
//			}
//			else {
//				System.out.println("{FileLockTest} :: [main] - File is CLOSED:  '" + path2 + "'");
//				file2open = false;
//			}
			
			filesopen = file1open;// || file2open;
			try {
				Thread.sleep(5000);
			} 
			catch (InterruptedException e) {
				System.out.println("{FileLockTest} :: [checkLinux] - Interrupted Exception");
			}

		}
	System.out.println("{FileLockTest} :: [main] - File was closed:  '" + path1 + "'");
//	System.out.println("{FileLockTest} :: [main] - File was closed:  '" + path2 + "'");
	}

	
	public static void checkWin(String path1) {  //, String path2) {
		System.out.println("{FileLockTest} :: [main] - processing in Windows");

		boolean filesopen = true;
		boolean file1open = true;
		boolean file2open = true;
		
		while (filesopen) {
			
			
			if (isFileLocked(path1)) {
				System.out.println("{FileLockTest} :: [main] - File is OPEN:  '" + path1 + "'");
				file1open = true;
			}
			else {
				System.out.println("{FileLockTest} :: [main] - File is CLOSED:  '" + path1 + "'");
				file1open = false;
			}
//			if (isFileLocked(path2)) {
//				System.out.println("{FileLockTest} :: [main] - File is OPEN:  '" + path2 + "'");
//				file2open = true;
//			}
//			else {
//				System.out.println("{FileLockTest} :: [main] - File is CLOSED:  '" + path2 + "'");
//				file2open = false;
//			}
			try {
				Thread.sleep(5000);
			} 
			catch (InterruptedException e) {
				System.out.println("{FileLockTest} :: [checkWin] - Interrupted Exception");
			}
			
			filesopen = file1open;  // || file2open;
		}
		
		
		
		
		
		System.out.println("{FileLockTest} :: [main] - IsLocked:  " + isFileLocked(path1));
//		System.out.println("{FileLockTest} :: [main] - IsLocked:  " + isFileLocked(path2));
	}
	
	
	
	
	
	public static boolean isFileClosed(File file) {
		BufferedReader reader = null;
		Process plsof = null;
		String [] processCmd = {"lsof", "|", "grep",file.getAbsolutePath()};
		
	    try {
	        plsof = new ProcessBuilder(processCmd).start();
	        reader = new BufferedReader(new InputStreamReader(plsof.getInputStream()));
	        String line;
	        while((line=reader.readLine())!=null) {
	            if(line.contains(file.getAbsolutePath())) {                            
	                reader.close();
	                plsof.destroy();
	                return false;
	            }
	        }
	    } 
	    catch(Exception e) {
    		System.out.println("{FileLockTest} :: [isFileClosed] - Exception:  " + e.getMessage());
	    }
	    if (reader != null) {
	    	try {
	    	reader.close();
	    	}
	    	catch (IOException e) {
	    		System.out.println("{FileLockTest} :: [isFileClosed] - IO Exception:  " + e.getMessage());
	    	}
	    }
	    if (plsof != null) {
	    	plsof.destroy();
	    }
	    return true;
	}
	
	
	public static boolean isFileLocked(String filePath) {
		

		System.out.println("{FileLockTest} :: [isFileLocked] - File:  '" + filePath + "'");
		
		boolean isLocked = false;
		
		File file = new File(filePath);
		FileChannel channel = null;
		FileLock lock = null;
		try {
			channel = new RandomAccessFile(file, "rw").getChannel();
			lock = channel.tryLock();
//			isLocked = 
		} 
		catch (FileNotFoundException e) {
			System.out.println("{FileLockTest} :: [isFileLocked] - File is not found:  '" + filePath + "'");
			isLocked = true;
//			e.printStackTrace();
		}
		catch (IOException e) {
			System.out.println("{FileLockTest} :: [isFileLocked] - IO Exception:  '" + filePath + "'");
//			e.printStackTrace();
		}
		finally {
			if (lock != null) {
				try {
					lock.release();
				} catch (IOException e) {
					System.out.println("{FileLockTest} :: [isFileLocked] - IO Exception while releasing lock:  '" + filePath + "'");
					e.printStackTrace();
				}
			}
		}
		
		
		return isLocked;
	}

}
