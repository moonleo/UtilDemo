package string;

public class SpecialString {
	// 判断是否为回文字符串
	public boolean isPalindromes(String str) {
		if (null != str) {
			int i = 0;
			int j = str.length() - 1;
			while (i < j) {
				if (str.charAt(i) == str.charAt(j)) {
					i++;
					j--;
				} else
					break;
			}
			if (i >= j) {
				return true;
			}
		}
		return false;
	}

}
