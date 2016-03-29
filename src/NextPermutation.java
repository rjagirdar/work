public class NextPermutation {

    /**
     * @param args
     */
    public static void main(String[] args) {
    	NextPermutation main = new NextPermutation();
    	int[] array = { 1, 2, 3, 4, 5 };
    	main.print(array);
    	main.next_permutation(array);
    	main.print(array);
    	main.next_permutation(array);
    	main.print(array);
    	main.next_permutation(array);
    	main.print(array);
    	System.exit(0);
    }

    public void print(int[] array) {
    	for (int tmp : array) {
    		System.out.print(" " + tmp);
    	}
    	System.out.println();
    }

    public void next_permutation(int[] array) {
    	int i, j;
    	// Find the largest index k such that a[k] < a[k + 1]. If no such index
    	// exists, the permutation is the last permutation.
    	for (i = array.length - 2; i >= 0; i--) {
    		if (array[i] < array[i + 1])
    			break;
    	}
    	if (i < 0) {
    		System.out.println("End");
    		return;
    	}

    	// Find the largest index l such that a[k] < a[l]. Since k + 1 is such
    	// an index, l is well defined and satisfies k < l.
    	for (j = array.length - 1; j > i; j--) {
    		if (array[j] > array[i])
    			break;
    	}

    	// Swap a[k] with a[l].
    	swap(array, i++, j);
    	
    	/*System.out.println("============================================================");
    	for(int temp : array)
    		System.out.print(temp+" ");
    	System.out.println();*/
    	// Reverse the sequence from a[k + 1] up to and including the final
    	// element a[n].
    	for (j = array.length - 1; j > i; i++, j--) {
    		swap(array, i, j);
    	}
    	/*for(int temp : array)
    		System.out.print(temp+" ");
    	System.out.println();
    	System.out.println("============================================================");*/
    }

    public void swap(int[] array, int x, int y) {
    	array[x] ^= array[y];
    	array[y] ^= array[x];
    	array[x] ^= array[y];
    }
}
