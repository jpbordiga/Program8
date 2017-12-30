import java.util.ArrayList;

public interface QuickSortInterface {

	public void quickSort(ArrayList<String> arr, int p, int r);
	public void randomizedQuickSort(ArrayList<String> arr, int p, int r);
	public int randomizedPartition(ArrayList<String> arr, int p, int r);
	public int partition(ArrayList<String> arr, int p, int r);
	public int random(int p, int r);
	
}
