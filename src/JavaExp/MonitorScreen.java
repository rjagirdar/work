package JavaExp;

public class MonitorScreen {
	   
	   public  class PixelPoint {
	      private int x;
	      private int y;

	      public PixelPoint(final int x, final int y) {
	         this.x = x;
	         this.y = y;
	      }
		  
	      public int getX() {
	         return x;
	      }
		  
	      public int getY( ) {
	         return y;
	      }
	      @Override
	      public String toString(){
	    	  return "X:"+this.x+" Y:"+this.y;
	      }
	   }
	}
