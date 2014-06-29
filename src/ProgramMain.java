


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.restarent.controller.BestRestarent.BestChoiceController;

/**
 * @author ramakrishnak
 *
 */
public class ProgramMain {
	public static void main(String[] args) {
		List<String> inputData = new ArrayList<String>(Arrays.asList(args));
		int inputDataLength = inputData.size();
		if(inputDataLength < 2){
			System.err.println("Usage:: java ProgramMain item1 item2 .. ");
			return ;
		}
		String inputFileName = inputData.remove(0);
		String result = BestChoiceController.process(inputFileName, inputData);
		System.out.println(result);
	}
}
