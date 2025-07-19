class StringConcatPerformance {
	public static void main(String[] args) {
		int n = 1_000_000; //Number of string to append
		
		//StringBuilder performance
		long startBuilder = System.nanoTime();
		StringBuilder sbBuilder = new StringBuilder();
		for(int i = 0; i < n; i++) {
			sbBuilder.append("hello");
		}
		long endBuilder = System.nanoTime();
		long timeBuilder = endBuilder - startBuilder;
		
		//StringBuffer performance
		long startBuffer = System.nanoTime();
		StringBuffer sbBuffer = new StringBuffer();
		for(int i = 0; i < n; i++) {
			sbBuffer.append("hello");
		}
		long endBuffer = System.nanoTime();
		long timeBuffer = endBuffer - startBuffer;
		
		//Output time in milliseconds
		System.out.println("Time taken by StringBuilder: " + timeBuilder / 1_000_000 + "ms");
		System.out.println("Time taken by StringBuffer: " + timeBuffer / 1_000_000+ "ms");
		
				
	}
}