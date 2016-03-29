package JavaExp;

public class PublicInnerClassAccess {
	   public static final void main(final String[] args) {
		  MonitorScreen screenObj = new MonitorScreen();
	      MonitorScreen.PixelPoint obj =screenObj.new PixelPoint(5,6); // <= Compiler error.
	      System.out.println(obj.toString());
	   }
	}
