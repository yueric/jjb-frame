package com.zplan.demo.fileupload;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 文件操作工具類
 * 
 * @author eric
 * 
 */
public class FileUtil {
	public static String getExtension(File f) {
		return (f != null) ? getExtension(f.getName()) : "";
	}

	public static String getExtension(String filename) {
		return getExtension(filename, "");
	}

	public static String getExtension(String filename, String defExt) {
		if ((filename != null) && (filename.length() > 0)) {
			int i = filename.lastIndexOf('.');

			if ((i > -1) && (i < (filename.length() - 1))) {
				return filename.substring(i + 1);
			}
		}
		return defExt;
	}

	public static String trimExtension(String filename) {
		if ((filename != null) && (filename.length() > 0)) {
			int i = filename.lastIndexOf('.');
			if ((i > -1) && (i < (filename.length()))) {
				return filename.substring(0, i);
			}
		}
		return filename;
	}

	/**
	 * 保存图片
	 * 
	 * @param img
	 *            原图路径
	 * @param dest
	 *            目标图路径
	 * @param top
	 *            选择框的左边y坐标
	 * @param left
	 *            选择框的左边x坐标
	 * @param width
	 *            选择框宽度
	 * @param height
	 *            选择框高度
	 * @return
	 * @throws IOException
	 */
	public static boolean saveImage(File img, String dest, int top, int left,
			int width, int height) throws IOException {
		File fileDest = new File(dest);
		if (!fileDest.getParentFile().exists())
			fileDest.getParentFile().mkdirs();
		String ext = FileUtil.getExtension(dest).toLowerCase();
		BufferedImage bi = (BufferedImage) ImageIO.read(img);
		height = Math.min(height, bi.getHeight());
		width = Math.min(width, bi.getWidth());
		if (height <= 0)
			height = bi.getHeight();
		if (width <= 0)
			width = bi.getWidth();
		top = Math.min(Math.max(0, top), bi.getHeight() - height);
		left = Math.min(Math.max(0, left), bi.getWidth() - width);

		BufferedImage bi_cropper = bi.getSubimage(left, top, width, height);
		return ImageIO.write(bi_cropper, ext.equals("png") ? "png" : "jpeg",
				fileDest);
	}
}
