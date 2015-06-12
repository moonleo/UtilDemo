package number;

public class CommonDivisorAndMultiple {
    /**
     * zui da gong yue shu
     * @param a
     * @param b
     * @return
     */
	public int maxCommonDivisor(int a, int b) {
		if (a % b == 0)
			return b;
		else
			return maxCommonDivisor(b, a % b);
	}

    /**
     * zui xiao gong bei shu
     * @param a
     * @param b
     * @return
     */
	public int minCommonMultiple(int a, int b) {
		return a*b/maxCommonDivisor(a, b);
	}

	public static void main(String[] args) {
		CommonDivisorAndMultiple n = new CommonDivisorAndMultiple();
		System.out.println(n.maxCommonDivisor(4, 5));
		System.out.println(n.minCommonMultiple(4, 6));
	}

}
