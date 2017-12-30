import java.util.ArrayList;

public class QuickSort implements QuickSortInterface{

	private ArrayList<String> repeatedKeys = new ArrayList<>();
	
	public QuickSort() {
		//
	}
	
	@Override
	public void randomizedQuickSort(ArrayList<String> arr, int p, int r) { // sorts the strings in a randomized fashion
		
		if(p < r) {
			
			int q = randomizedPartition(arr, p, r);
			
			randomizedQuickSort(arr, p, q - 1);
			randomizedQuickSort(arr, q + 1, r);
			
		}
		
	}

	@Override
	public int randomizedPartition(ArrayList<String> arr, int p, int r) {
		
		int i = 0;
		boolean withinRange = false;
		
		while(withinRange == false) {
			
			i = random(p, r);
			
			if(i < arr.size()) {
				withinRange = true;
			} else {
				withinRange = false;
			}
			
		}
		
		String placeHolder = arr.get(r);
		arr.set(r, arr.get(i));
		arr.set(i, placeHolder);
		
		return partition(arr, p, r);
		
	}

	@Override
	public int partition(ArrayList<String> arr, int p, int r) {
		
		String x = arr.get(r); // pivot value
		int i = p - 1;
		
		ArrayList<Integer> repeatKeys = findRepeats(arr, x);
		
		for(int j = p; j < (r - 1); j++) {
		
			if((arr.get(j).compareTo(x) < 0) && (repeatKeys.contains(j) != true)) {
				
				i = i + 1;
				
				String placeHolder = arr.get(i);
				arr.set(i, arr.get(j));
				arr.set(j, placeHolder);
				
			}
			
		}
		
		String placeHolder = arr.get(i + 1);
		arr.set(i + 1, arr.get(r));
		arr.set(r, placeHolder);
		
		return i + 1;
		
	}

	@Override
	public int random(int p, int r) {
		return p + (int)(Math.random() * r);
	}

	@Override
	public void quickSort(ArrayList<String> arr, int p, int r) {
		
		if(p < r) {
			
			int q = partition(arr, p, r);
			
			quickSort(arr, p, q - 1);
			quickSort(arr, q + 1, r);
			
		}
		
		
	}
	
	public ArrayList<Integer> findRepeats(ArrayList<String> arr, String pivot) { // finds repeats of current pivot
		
		ArrayList<Integer> repeatPositions = new ArrayList<>();
		
		for(String s : arr) {
			
			if(s.equals(pivot)) {
				repeatPositions.add(arr.indexOf(s));
			}
			
		}
		
		return repeatPositions;
		
	}

}
