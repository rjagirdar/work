
public class VersionCompare {

	public static void main(String[] args) {
		String v1 ="1.0.2.1";
		String v2 = "1.0.2.2";
		
		System.out.println("Greater Version is "+ compareTwoReleaseVersion(v1, v2));
	}
	
	public static String compareTwoReleaseVersion( String version1, String version2){
        String splitV1[] = version1.split("\\.");
        String splitV2[] = version2.split("\\.");
        for( int pos = 0; pos < splitV1.length && pos < splitV2.length ; pos++){
            if( splitV1[ pos ].compareTo( splitV2[ pos ] ) > 0  ) return version1;
            if( splitV1[ pos ].compareTo( splitV2[ pos ] ) < 0 ) return version2;
        }
        return ( splitV1.length > splitV2.length  ) ? version1 : version2; 
   }

}
