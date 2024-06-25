package genericUtilities;

import java.util.Random;

public class JavaUtility {
public int getRandomNum() {
	Random ran=new Random();
	int r = ran.nextInt(100);
	return r;
}
}
