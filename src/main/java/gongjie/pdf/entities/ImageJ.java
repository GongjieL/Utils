package gongjie.pdf.entities;

public class ImageJ {
	//图片宽度
	private float width;
	//图片高度
	private float heigth;
	//图片在页面的宽度
	private float locWidth;
	//图片在页面的高度
	private float locHeigth;
	//图片的字节码文件
	private byte[]bytes;
	//插到第几页（从1开始）
	private int page;
	public ImageJ() {
		
	}
	public ImageJ(float width, float heigth, float locWidth, float locHeigth, byte[] bytes, int page) {
		super();
		this.width = width;
		this.heigth = heigth;
		this.locWidth = locWidth;
		this.locHeigth = locHeigth;
		this.bytes = bytes;
		this.page = page;
	}







	public float getWidth() {
		return width;
	}
	public void setWidth(float width) {
		this.width = width;
	}
	public float getHeigth() {
		return heigth;
	}
	public void setHeigth(float heigth) {
		this.heigth = heigth;
	}
	public float getLocWidth() {
		return locWidth;
	}
	public void setLocWidth(float locWidth) {
		this.locWidth = locWidth;
	}
	public float getLocHeigth() {
		return locHeigth;
	}
	public void setLocHeigth(float locHeigth) {
		this.locHeigth = locHeigth;
	}
	public byte[] getBytes() {
		return bytes;
	}
	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	
}
