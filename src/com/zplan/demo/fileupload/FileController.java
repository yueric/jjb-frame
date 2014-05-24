package com.zplan.demo.fileupload;

import java.io.Console;

import com.jfinal.core.Controller;
import com.jfinal.plugin.ehcache.CacheKit;
import com.jfinal.upload.UploadFile;

public class FileController extends Controller {
	
	public void index() {
		render("fndex.html");
	}

	public void cutpic() {
		render("cutpic.html");
	}
	
	public void cache(){
		System.out.println("we got : "+CacheKit.get("user", "one"));
		CacheKit.put("user", "one", "eric");
		System.out.println("we got again : "+CacheKit.get("user", "one"));		
	}

	/**
	 * 文件上传接收
	 */
	public void uploadFile() {
		String mHttpUrl = "uploadFiles\\";
		int maxSize = 10 * 1024 * 1024; // 10M
		UploadFile upFile = getFile("picfile", mHttpUrl, maxSize, "utf-8");
		render("fndex.html");
	}

	/**
	 * 剪切文件
	 */
	public void resizimg() {
		/*
		 * 获取参数 x,y,w,h,bigImage
		 */
		int x = Integer.valueOf(getPara("x"));
		int y = Integer.valueOf(getPara("y"));
		int w = Integer.valueOf(getPara("w"));
		int h = Integer.valueOf(getPara("h"));
		System.out.println("x:"+x+";y:"+y+";w:"+w+";h:"+h);
		//String bigImage = getPara("bigImage");

		// 获取文件真实路径
		// 获取文件名
		//String[] imageNameS = bigImage.split("/");
		//String imageName = imageNameS[imageNameS.length - 1];
		// 文件正式路径
		String imagePath = "\\upload\\uploadFiles\\1f0f79a8d6d6e08976d7fb530dafcfd4.jpg" ;

		// 切割图片
		ImageCut imageCut = new ImageCut();
		imageCut.cutImage(imagePath, x, y, w, h);

		render("index.html");
	}
}
