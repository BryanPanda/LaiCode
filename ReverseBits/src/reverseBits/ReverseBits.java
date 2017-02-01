package reverseBits;

//Reverse all bits of an integer.

public class ReverseBits {

	public int reverseBits(int num) {
		for (int offset = 0; offset < 16; offset++) {
			int right = (num >> offset) & 1;
			int left = (num >> (31 - offset)) & 1;
			if (left != right) {
				num ^= (1 << offset);
				num ^= (1 << (31 - offset));
			}
		}
		return num;
	}

	public int reverseBits2(int num) {
		num = ((num & 0xFFFF0000) >>> 16) | ((num & 0x0000FFFF) << 16);
		num = ((num & 0xFF00FF00) >>> 8) | ((num & 0x00FF00FF) << 8);
		num = ((num & 0xF0F0F0F0) >>> 4) | ((num & 0x0F0F0F0F) << 4);
		num = ((num & 0xCCCCCCCC) >>> 2) | ((num & 0x33333333) << 2);
		num = ((num & 0xAAAAAAAA) >>> 1) | ((num & 0x55555555) << 1);
		return num;
	}
}
